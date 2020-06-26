package com.bottega.proxy;

public class ElectricEngine implements Engine {

    @Override
    public void run(String options) {
        System.out.println("Run electric");
        System.out.println("With options: " + options);
    }

    @Override
    public void stop() {
        System.out.println("Stop Electric Engine");
    }
}
