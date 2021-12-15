package com.example.designmodel.design.single;

/**
 * 双重检测
 */
public class IdGeneratorDoubleCheck {
    private static IdGeneratorDoubleCheck instance;

    public static IdGeneratorDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorDoubleCheck.class) {
                if (instance == null) {
                    instance = new IdGeneratorDoubleCheck();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        IdGeneratorDoubleCheck instance = IdGeneratorDoubleCheck.getInstance();
        IdGeneratorDoubleCheck instance1 = IdGeneratorDoubleCheck.getInstance();
        IdGeneratorDoubleCheck instance2 = IdGeneratorDoubleCheck.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
