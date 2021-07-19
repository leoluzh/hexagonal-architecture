package com.lambdasys.hexagonal.architecture.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store implements Serializable {

    private String id;
    private String name;

    @Builder.Default
    private Location location = new Location();

}
