package com.bottega.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EngineInvocationHandler implements InvocationHandler {

    private final Object original;

    EngineInvocationHandler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equals("run")) {
            try {
                System.out.println(String.format(">> before method: [%s]", method.getName()));
                return method.invoke(original, args);
            } finally {
                System.out.println(String.format("<< after method: [%s]", method.getName()));
            }
        } else {
            return  method.invoke(original, args);
        }

    }
}
