package com.lambdasys.hexagonal.architecture.mappers;

import com.lambdasys.hexagonal.architecture.adapters.persistence.entity.GeoJSONPoint;
import com.lambdasys.hexagonal.architecture.adapters.persistence.entity.StoreEntity;
import com.lambdasys.hexagonal.architecture.application.domain.Location;
import com.lambdasys.hexagonal.architecture.application.domain.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StoreEntityMapper {

    @Mapping(target = "id", source = "source.id")
    @Mapping(target = "name", source = "source.name")
    @Mapping(target = "zipCode", source = "source.location.zipCode")
    @Mapping(target = "geoJSONPoint", source = "source")
    StoreEntity toEntity(final Store source);

    default GeoJSONPoint toGeoJSONPoint(final Store store) {
        return GeoJSONPoint.builder()
                .coordinate(store.getLocation().getLongitude())
                .coordinate(store.getLocation().getLatitude())
                .build();
    }
    
    @Mapping(target = "id", source = "source.id")
    @Mapping(target = "name", source = "source.name")
    @Mapping(target = "location", source = "source")
    Store toDomain(final StoreEntity source);

    default Location toLocation(final StoreEntity source) {
        return Location
                .builder()
                .zipCode(source.getZipCode())
                .longitude(source.getGeoJSONPoint().getCoordinates().get(0))
                .latitude(source.getGeoJSONPoint().getCoordinates().get(1))
                .build();
    }

}
