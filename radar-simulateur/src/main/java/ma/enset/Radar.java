package ma.enset;

import io.grpc.stub.StreamObserver;
import ma.enset.stub.sendInfractionGrpc;

import java.sql.Time;
import java.util.*;

public class Radar extends sendInfractionGrpc.sendInfractionImplBase {

    @Override
    public void send(ma.enset.stub.Radar.Empty request, StreamObserver<ma.enset.stub.Radar.infractionInfo> responseObserver) {

        List<String> caracteresMatricule = new ArrayList<>();
        caracteresMatricule.add("A763BC");
        caracteresMatricule.add("C268NM");
        caracteresMatricule.add("E767OP");
        caracteresMatricule.add("K757NE");
        caracteresMatricule.add("W768BR");
        caracteresMatricule.add("M766LL");
        Random random = new Random();
        Timer timer = new Timer();



        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                //génerer matricule
                StringBuilder matriculeBuilder = new StringBuilder();
                matriculeBuilder.append(caracteresMatricule.get(random.nextInt(5)));

                //génerer une vitesse
                float vitesse =  random.nextFloat((float) 150);

                if(vitesse>100){
                    ma.enset.stub.Radar.infractionInfo infractionInfo = ma.enset.stub.Radar.infractionInfo.newBuilder()
                            .setMatricule(matriculeBuilder.toString())
                            .setVitesse(vitesse)
                            .build();
                    responseObserver.onNext(infractionInfo);
                }

            }
        },1500,10000);

    }
}