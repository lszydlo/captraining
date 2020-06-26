package com.bottega.captraining;

import com.bottega.order.MyService;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class AddressService {


    private ResourceLoader loader;

    public AddressService(ResourceLoader loader) {
        this.loader = loader;
    }

    @MyService
    public void addAddress() {
        try {
            InputStream inputStream = loader.getResource("classpath:files/sample.txt").getInputStream();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream))) {
                String text = reader.lines()
                        .collect(Collectors.joining("\n"));

                System.out.println("TEST: " + text);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //throw new DomainException(503);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
