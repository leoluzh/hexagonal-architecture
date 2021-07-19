package com.lambdasys.hexagonal.architecture.application.ports.out;

public interface UpdateStoreCountInZipCodePort {

    void incrementStoreCount(final String zipCode);

}
