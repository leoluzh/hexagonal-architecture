package com.lambdasys.hexagonal.architecture.application.ports.in;

import com.lambdasys.hexagonal.architecture.application.domain.Store;
import reactor.core.publisher.Mono;

public interface StoreManagementUseCase {

    Mono<Store> add(final Store store);

}
