package com.lambdasys.hexagonal.architecture.adapters.persistence;

import com.lambdasys.hexagonal.architecture.adapters.persistence.entity.StoreEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends ReactiveMongoRepository<StoreEntity, String> {
}