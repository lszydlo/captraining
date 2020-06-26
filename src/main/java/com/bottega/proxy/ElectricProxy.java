package com.bottega.proxy;

public class ElectricProxy extends ElectricEngine {

    @Override
    public void run(String options) {
        System.out.println("before");
        super.run(options);
        System.out.println("after");
    }
}

