package com.lambdasys.hexagonal.architecture.adapters.web.presenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorePresenter implements Serializable {

    private String id;
    private String name;
    private String zipCode;
    private Double latitude;
    private Double longitude;

}
