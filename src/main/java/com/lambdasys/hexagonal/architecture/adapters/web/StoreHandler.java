package com.lambdasys.hexagonal.architecture.adapters.web;

import com.lambdasys.hexagonal.architecture.adapters.web.presenter.StorePresenter;
import com.lambdasys.hexagonal.architecture.application.ports.in.StoreManagementUseCase;
import com.lambdasys.hexagonal.architecture.mappers.StorePresenterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreHandler implements Serializable {

    private final StoreManagementUseCase storeManagementUseCase;
    private final StorePresenterMapper storePresenterMapper;


    public Mono<ServerResponse> add(final ServerRequest request){
        return request.bodyToMono(StorePresenter.class)
                .flatMap(
                        storePresenter -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(
                                this.storeManagementUseCase
                                        .add(this.storePresenterMapper.toDomain(storePresenter))
                                        .map(this.storePresenterMapper::toPresenter)
                                ,StorePresenter.class));
    }

}
