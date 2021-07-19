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
public class Location implements Serializable {

    private String zipCode;
    private Double latitude;
    private Double longitude;

}
