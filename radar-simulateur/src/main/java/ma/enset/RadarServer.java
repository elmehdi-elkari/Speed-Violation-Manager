package ma.enset;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class RadarServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder
                .forPort(1010)
                .addService(new Radar())
                .build();
        server.start();
        server.awaitTermination();
    }

}
