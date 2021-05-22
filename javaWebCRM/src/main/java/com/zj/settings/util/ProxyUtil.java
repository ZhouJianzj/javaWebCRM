package com.zj.settings.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public ProxyUtil() {
    }
    public static Object getProxy(Object factory,InvocationHandler myInvocationHandler){
        Object o = Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                myInvocationHandler);
        return o;
    }
}
