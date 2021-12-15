package com.example.designmodel.design.single;

/**
 * 静态内部类
 * SingletonHolder是一个静态内部类，当外部类IdGenerator被加载的时候，并不会创建SingletonHolder对象，
 * 只有getInstance被调用时，instance才会被创建
 */
public class IdGeneratorStaticInnerClass {

    private static class SingletonHolder {
        private static IdGeneratorStaticInnerClass instance = new IdGeneratorStaticInnerClass();
    }

    public static IdGeneratorStaticInnerClass getInstance() {
        return SingletonHolder.instance;
    }




    public static void main(String[] args) {
        IdGeneratorStaticInnerClass instance = IdGeneratorStaticInnerClass.getInstance();
        System.out.println(instance);
        System.out.println(instance);
        System.out.println(instance);
        System.out.println(new IdGeneratorStaticInnerClass());
    }

}
