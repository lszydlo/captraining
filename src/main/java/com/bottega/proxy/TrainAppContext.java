package com.bottega.proxy;

import java.lang.reflect.Proxy;

public class TrainAppContext {

    MainProxyApp.Train getTrain(boolean isProxy) {
        if (isProxy) {
            return new MainProxyApp.Train((Engine) Proxy.newProxyInstance(
                    Engine.class.getClassLoader(),
                    new Class[]{Engine.class},
                    new EngineInvocationHandler(new ElectricEngine())));
        } else {
            return new MainProxyApp.Train(new ElectricEngine());
        }
    }
}

