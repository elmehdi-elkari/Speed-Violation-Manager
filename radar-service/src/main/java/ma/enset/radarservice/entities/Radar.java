package ma.enset.radarservice.entities;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.radarservice.services.InfractionService;
import ma.enset.radarservice.web.grpc.stub.sendInfractionGrpc;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Double Longitude ;
    private Double Latitude ;
    private Float vitesse_maximale ;


    public void start(InfractionService service){

        ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost",1010).usePlaintext().build();
        sendInfractionGrpc.sendInfractionStub sendInfractionStub=sendInfractionGrpc.newStub(managedChannel);
        ma.enset.radarservice.web.grpc.stub.Radar.Empty empty= ma.enset.radarservice.web.grpc.stub.Radar.Empty.newBuilder().build();



        sendInfractionStub.send(empty, new StreamObserver<ma.enset.radarservice.web.grpc.stub.Radar.infractionInfo>(  ) {

            @Override
            public void onNext(ma.enset.radarservice.web.grpc.stub.Radar.infractionInfo infractionInfo) {
                System.out.println(infractionInfo.getMatricule()+" -> "+Radar.this.id);

                Infraction infraction=Infraction.builder()
                        .date(new Date())
                        .numeroRadar(Radar.this.id)
                        .vitesseVehicule(infractionInfo.getVitesse())
                        .montant((infractionInfo.getVitesse()-Radar.this.vitesse_maximale)*10)
                        .vitesseMax(Radar.this.vitesse_maximale)
                        .matricule(infractionInfo.getMatricule())
                        .build();
                service.saveInfractions(infraction);


            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("fin");
            }
        });

    }

}
