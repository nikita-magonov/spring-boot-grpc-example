package ru.hse.spring.jdbc.template.example.springbootgrpcexample;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ru.hse.spring.jdbc.template.example.springbootgrpcexample.GreetingServiceGrpc.GreetingServiceBlockingStub;

public class GreetingClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        CreateGreetingRequest request = CreateGreetingRequest.newBuilder()
                .setName("April")
                .build();

        CreateGreetingResponse response = stub.createGreeting(request);

        System.out.println(response.getGreeting());

        channel.shutdown();
    }
}
