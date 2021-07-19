package com.lambdasys.hexagonal.architecture.application;

import com.lambdasys.hexagonal.architecture.application.domain.Store;
import com.lambdasys.hexagonal.architecture.application.ports.in.StoreManagementUseCase;
import com.lambdasys.hexagonal.architecture.application.ports.out.StorePort;
import com.lambdasys.hexagonal.architecture.application.ports.out.UpdateStoreCountInZipCodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreService implements StoreManagementUseCase {

    private final StorePort storePort;
    private final UpdateStoreCountInZipCodePort updateStoreCountInZipCodePort;

    @Override
    @Transactional()
    public Mono<Store> add(final Store store) {
        final var result = storePort.add(store);
        updateStoreCountInZipCodePort.incrementStoreCount(store.getLocation().getZipCode());
        return result;
    }
}
