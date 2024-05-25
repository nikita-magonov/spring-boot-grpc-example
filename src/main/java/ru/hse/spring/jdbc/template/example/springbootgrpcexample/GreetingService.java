package ru.hse.spring.jdbc.template.example.springbootgrpcexample;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void createGreeting(CreateGreetingRequest request, StreamObserver<CreateGreetingResponse> responseObserver) {
        CreateGreetingResponse createGreetingResponse =
                CreateGreetingResponse.newBuilder()
                        .setGreeting("Hello, " + request.getName() + "!")
                        .build();

        responseObserver.onNext(createGreetingResponse);
        responseObserver.onCompleted();
    }
}
