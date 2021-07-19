package com.lambdasys.hexagonal.architecture.adapters.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import java.io.Serializable;

@Configuration
public class StoreRouter implements Serializable {

    @Bean
    public RouterFunction<ServerResponse> routes(final StoreHandler storeHandler) {
        return RouterFunctions.route(
                RequestPredicates.POST("/api/v1/stores")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), storeHandler::add);
    }

}
