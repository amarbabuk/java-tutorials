package com.ab.api.service;

import com.ab.model.CPUIOServiceGrpc;
import com.ab.model.Input;
import com.ab.model.Output;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class GRPCCPUIOService {

    @GrpcClient("square")
    private CPUIOServiceGrpc.CPUIOServiceBlockingStub blockingStub;

    @GrpcClient("square")
    private CPUIOServiceGrpc.CPUIOServiceStub asyncStub;

    public Flux<Object> getSquareResponseUnary(int number){
        return Flux.create(fluxSink -> {
            for (int i = 1; i <= number ; i++) {
                Input input = Input.newBuilder().setNumber(i).build();
                Output output = this.blockingStub.findSquareUnary(input);
                fluxSink.next(Map.of(output.getNumber(), output.getResult()));
            }
            fluxSink.complete();
        });
    }

    public Flux<Object> getSquareResponseStream(int number){
        Input input = Input.newBuilder().setNumber(number).build();
        return Flux.create(fluxSink -> {
            this.blockingStub
                    .findSquareStream(input)
                    .forEachRemaining(output -> fluxSink.next(Map.of(output.getNumber(), output.getResult())));
            fluxSink.complete();
        });
    }

}
