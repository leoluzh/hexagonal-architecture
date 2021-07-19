package com.lambdasys.hexagonal.architecture.adapters.persistence;

import com.lambdasys.hexagonal.architecture.adapters.persistence.entity.ZipCodeEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ZipCodeRepository extends ReactiveMongoRepository<ZipCodeEntity, String> {

    Mono<ZipCodeEntity> findByZipCode(final String zipCode);
}
