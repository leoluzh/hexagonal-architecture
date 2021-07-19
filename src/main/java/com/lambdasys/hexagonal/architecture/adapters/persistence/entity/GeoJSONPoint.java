package com.lambdasys.hexagonal.architecture.adapters.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoJSONPoint implements Serializable {

    @Setter(AccessLevel.NONE)
    @Builder.Default
    private String type = "Point";

    @Singular
    @Builder.Default
    private List<Double> coordinates = new ArrayList<>();

}
