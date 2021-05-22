package com.zj.settings.proxyHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserLoginServcieProxy implements InvocationHandler {
    private Object object;

    public UserLoginServcieProxy(Object object) {
        this.object = object;
    }

    public UserLoginServcieProxy() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (object !=null){
//            这里是工厂方法的返回值
            Object invoke = method.invoke(object, args);

            return invoke;
        }
        return null;
    }
}
