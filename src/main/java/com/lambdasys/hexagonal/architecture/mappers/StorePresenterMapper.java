package com.lambdasys.hexagonal.architecture.mappers;

import com.lambdasys.hexagonal.architecture.adapters.web.presenter.StorePresenter;
import com.lambdasys.hexagonal.architecture.application.domain.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StorePresenterMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "zipCode", source = "location.zipCode")
    @Mapping(target = "latitude", source = "location.latitude")
    @Mapping(target = "longitude", source = "location.longitude")
    StorePresenter toPresenter(final Store source);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "location.zipCode", source = "zipCode")
    @Mapping(target = "location.latitude", source = "latitude")
    @Mapping(target = "location.longitude", source = "longitude")
    Store toDomain(final StorePresenter source);

}
