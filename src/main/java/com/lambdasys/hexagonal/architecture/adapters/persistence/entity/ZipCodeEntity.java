package com.lambdasys.hexagonal.architecture.adapters.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value="zip-codes")
public class ZipCodeEntity {

    @Id
    private String id;
    private String zipCode;
    private Integer storeCount;

}
