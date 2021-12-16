package com.example.designmodel.design.structural.proxy;

public class UserControllerProxy implements IUserController {
    private MetricsController metricsController;
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.metricsController = new MetricsController();
        this.userController = userController;
    }

    @Override
    public void login(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        //省略login逻辑...
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        metricsController.recordRequest();
    }

    @Override
    public void register(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        //省略register逻辑...
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        metricsController.recordRequest();
    }

    public static void main(String[] args) {
        //UserControllerProxy使用举例
        //因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        //将UserController类对象替换为UserControllerProxy对象，不需要改动太多代码
        IUserController userController = new UserControllerProxy(new UserController());
    }
}
