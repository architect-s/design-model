package com.example.designmodel.design.structural.proxy;

/**
 * login/register写法问题：
 * 1、性能计数器框架代码侵入到业务代码中，跟业务代码高度耦合，如果未来需要替换这个框架，那替换成本比较大
 * 2、收集接口请求的代码跟业务代码无关，本就不应该放到一个类中，业务类最好职责更加单一，只聚焦业务处理。
 */
public class UserController1 {
    private MetricsController metricsController;

    public UserController1(MetricsController metricsController) {
        this.metricsController = metricsController;
    }

    public void login(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        //省略login逻辑...
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        metricsController.recordRequest();
    }

    public void register(String telephone,String password){
        long startTime = System.currentTimeMillis();
        //省略register逻辑...
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        metricsController.recordRequest();
    }
}
