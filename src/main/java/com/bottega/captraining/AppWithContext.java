package com.bottega.captraining;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

public class AppWithContext {


    @Configuration
    static class AppConfig {


        @Bean
        @Primary
        public AddressBookService2 addressBookService2() {
            return new AddressBookService2("JavaConfig");
        }

        @Bean
        @Profile("DEV")
        public AddressBookService2 addressBookService3() {
            return new AddressBookService2("JavaConfig2");
        }


    }

    @Component
    static class Wrapper2 {


        private AddressBookService2 abs2;

        public Wrapper2(@Qualifier("formAnn") AddressBookService2 abs2) {

            this.abs2 = abs2;
        }

        public void addAddress(String address) {
            abs2.addAddress(new AddAddressRequest("",""));
        }
    }


    @Component("formAnn")
    static class AddressBookService2 {


        private final String value;

        public AddressBookService2(@Value("Annotation") String value) {
            this.value = value;
            System.out.println("Constructed with: " + value);
        }

        public void addAddress(AddAddressRequest address) {

         AtomicInteger counter2 = new AtomicInteger();
            System.out.println("Service: " + address.city);
            System.out.println("From: " + value);
            counter2.incrementAndGet();
        }
    }

    static class AddressRepo {
        public void save(String sdsd) {


        }
    }

    private static class AppContext {

        // ...
        // cofig
        // JDBC
        //data source
//        AddressRepo repo = new AddressRepo(dataso);
//        AddressBookService service = new AddressBookService(repo);


        public AddressService getBean(Class<AddressService> addressBookServiceClass) {
            return null;
        }
    }
}
