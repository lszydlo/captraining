package com.bottega.captraining;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class WrapperController {

    private final AddressService addressService;
    private final CaptrainingApplication.AddressValidator validator;
    private final CompanyService companyService;

    public WrapperController(AddressService addressService, CaptrainingApplication.AddressValidator validatorFactory, CompanyService companyService) {
        this.addressService = addressService;
        this.validator = validatorFactory;
        this.companyService = companyService;
    }

    // { "street": "ul. Kolorowa", "city":"Poznań" }

    @GetMapping("/private/start")
    public MyResponse getPrivate() {
        addressService.addAddress();
        return new MyResponse("success Priv");
    }

    @GetMapping("/public/start")
    public MyResponse getPublic() {
        return new MyResponse("success Pub");
    }

    @PostMapping("/do")
    public ResponseEntity<Void> doSomething(@RequestBody @Valid AddAddressRequest request) {
        addressService.addAddress();
        companyService.addAddress("Wrocław");


        return ResponseEntity.status(201).build();

    }


//


}
