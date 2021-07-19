package com.lambdasys.hexagonal.architecture.application.ports.out;

import com.lambdasys.hexagonal.architecture.application.domain.Store;
import reactor.core.publisher.Mono;

public interface StorePort {

    Mono<Store> add(final Store store);
}
