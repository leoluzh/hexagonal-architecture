package com.lambdasys.hexagonal.architecture.adapters.persistence;

import com.lambdasys.hexagonal.architecture.adapters.persistence.entity.ZipCodeEntity;
import com.lambdasys.hexagonal.architecture.application.domain.Store;
import com.lambdasys.hexagonal.architecture.application.ports.out.StorePort;
import com.lambdasys.hexagonal.architecture.application.ports.out.UpdateStoreCountInZipCodePort;
import com.lambdasys.hexagonal.architecture.mappers.StoreEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreManagementDBAdapter implements StorePort , UpdateStoreCountInZipCodePort {

    private final StoreRepository storeRepository;
    private final ZipCodeRepository zipCodeRepository;
    private final StoreEntityMapper storeEntityMapper;

    @Override
    public Mono<Store> add(final Store store) {
        return this.storeRepository
                .save(storeEntityMapper.toEntity(store))
                .map(storeEntityMapper::toDomain);
    }

    @Override
    public void incrementStoreCount(String zipCode) {
        this.zipCodeRepository.findByZipCode(zipCode)
                .flatMap( zipCodeEntity ->
                        zipCodeRepository.save(this.createNewInstanceWithStoreCountIncrementedByOne(zipCodeEntity))).subscribe();
    }

    private ZipCodeEntity createNewInstanceWithStoreCountIncrementedByOne(final ZipCodeEntity zipCodeEntity){
        return new ZipCodeEntity(
                zipCodeEntity.getId(),
                zipCodeEntity.getZipCode() ,
                zipCodeEntity.getStoreCount() + 1 );
    }

}
