package com.bottega.captraining;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {


    void addAddress(String address) {
        System.out.println("CS: " + address);
    }
}
