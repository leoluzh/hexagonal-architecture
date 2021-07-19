package com.lambdasys.hexagonal.architecture.mappers;

import com.lambdasys.hexagonal.architecture.adapters.persistence.entity.GeoJSONPoint;
import com.lambdasys.hexagonal.architecture.adapters.persistence.entity.StoreEntity;
import com.lambdasys.hexagonal.architecture.application.domain.Location;
import com.lambdasys.hexagonal.architecture.application.domain.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper
public interface StoreEntityMapper {

    @Mapping(target = "id", source = "source.id")
    @Mapping(target = "name", source = "source.name")
    @Mapping(target = "zipCode", source = "source.location.zipCode")
    @Mapping(target = "geoJSONPoint", source = "source", qualifiedByName = "mapGeoJSONPoint")
    StoreEntity toEntity(final Store source);


//    default void mapGeoJSONPoint(final Store source, @MappingTarget StoreEntity target) {
//        target.setGeoJSONPoint(toGeoJSONPoint(source));
//    }


    @Named("mapGeoJSONPoint")
    default GeoJSONPoint toGeoJSONPoint(final Store store) {
        return GeoJSONPoint.builder()
                .coordinate(store.getLocation().getLongitude())
                .coordinate(store.getLocation().getLatitude())
                .build();
    }

    @Mapping(target = "id", source = "source.id")
    @Mapping(target = "name", source = "source.name")
    @Mapping(target = "location", source = "source", qualifiedByName = "mapLocation")
    Store toDomain(final StoreEntity source);

//    default void mapLocation(final StoreEntity source, @MappingTarget Store target){
//        target.setLocation(toLocation(source));
//    }

    @Named("mapLocation")
    default Location toLocation(final StoreEntity source) {
        return Location
                .builder()
                .zipCode(source.getZipCode())
                .longitude(source.getGeoJSONPoint().getCoordinates().get(0))
                .latitude(source.getGeoJSONPoint().getCoordinates().get(1))
                .build();
    }

}
