package com.bottega.captraining;

import javax.validation.constraints.NotNull;

public class AddAddressRequest {


    @NotNull String street;
    @NotNull String city;

    public AddAddressRequest(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddAddressRequest{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
