package com.bottega.order;

import com.bottega.captraining.AddAddressRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class OrderingApp {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.bottega.order");

//        OrderService service = context.getBean(OrderService.class);
//        service.payOrder();


//        OrderServiceNew serviceNew = context.getBean(OrderServiceNew.class);
//        serviceNew.payOrder();


        PrototypeSample bean = context.getBean(PrototypeSample.class);
        bean = context.getBean(PrototypeSample.class);
        bean = context.getBean(PrototypeSample.class);
        bean = context.getBean(PrototypeSample.class);
        bean.hello();


        OrderService service = context.getBean(OrderService.class);
        service = context.getBean(OrderService.class);
        service = context.getBean(OrderService.class);
        service = context.getBean(OrderService.class);
        service = context.getBean(OrderService.class);
        service.payOrder();

    }



    @Component
    @Scope("prototype")
    static class PrototypeSample {

        public PrototypeSample() {
            System.out.println("Prototype was created");
        }

        public void hello() {
            System.out.println("hello");
        }
    }


    @MyService
    static class OrderServiceNew {


        // payu
        private PaymentProvider provider;

        public OrderServiceNew(@Qualifier("PAYU") PaymentProvider provider) {
            this.provider = provider;
        }

        void payOrder() {
            provider.makePayment();
        }
    }


    @Configuration
    static class AppConfig {

        @Bean("PAYU")
        @Profile("PROD")
        public PaymentProvider paymentProvider(){
            return new PayUPaymentProvider();
        }

    }

    @Component
    static class OrderService {

        private PaymentProvider paymentProvider;

        public OrderService(PaymentProvider paymentProvider) {
            System.out.println("OrderService Created");
            this.paymentProvider = paymentProvider;
        }

        void payOrder() {
            System.out.println("payOrder");
           paymentProvider.makePayment();
        }
    }


    interface PaymentProvider {
        boolean makePayment();
    }

    static class PayUPaymentProvider implements PaymentProvider{

        public PayUPaymentProvider() {
            System.out.println("PAYU");
        }

        public boolean makePayment() {
            System.out.println("PAYU");
            return true;
        }
    }


    static class MyCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }




    @Component
    @Profile("TEST")
    static class BlueMediaPaymentProvider implements PaymentProvider{

        public BlueMediaPaymentProvider() {
            System.out.println("BM");
        }

        public boolean makePayment() {
            System.out.println("BM");
            return false;
        }
    }



}
