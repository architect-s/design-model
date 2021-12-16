package com.example.designmodel.design.structural.proxy.dynamic;

import com.example.designmodel.design.structural.proxy.IUserController;
import com.example.designmodel.design.structural.proxy.MetricsController;
import com.example.designmodel.design.structural.proxy.UserController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理问题：1、需要在代理类中，将原始类中的所有方法都实现一遍，并且为每个方法都附加相似的逻辑；
 * 2、如果要添加的附加功能的类有不止一个，我们需要针对每个类都创建一个代理类。
 * 如果有50个要添加附加功能的原始类，我们就要创建50个对应的代理类。
 * <p>
 * 动态代理：不事先为每个原始类编写代理类，而是在运行的时候，动态的创建原始类对应的代理类，然后
 * 在系统中用代理类替换掉原始类。(动态代理底层依赖的是java的反射语法)
 * <p>
 * SpringAOP底层就是动态代理(1、JDK动态代理;2、CGLIB动态代理)。用户配置好需要给哪些类创建代理，并定义好在
 * 执行原始类的业务代码前后执行哪些附加功能。Spring为这些类创建动态代理对象，并在JVM中替代原始类对象。
 */
public class MetricsControllerProxy {
    private MetricsController metricsController;

    public MetricsControllerProxy() {
        this.metricsController = new MetricsController();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTime = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTime = System.currentTimeMillis();
            long response = endTime - startTime;
            metricsController.recordRequest();
            return result;
        }
    }

    public static void main(String[] args) {
        MetricsControllerProxy proxy = new MetricsControllerProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.login("", "");
        userController.register("", "");
    }

}
