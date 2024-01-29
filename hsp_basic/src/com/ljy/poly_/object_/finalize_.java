package com.ljy.poly_.object_;

import sun.misc.GC;

public class finalize_ {
    public static void main(String[] args) {
        Car byd = new Car("比亚迪", 100000);
        byd = null;
        Car bmw = new Car("宝马", 200000);
        bmw = null;
        System.gc();
        System.out.println("程序退出了");
    }
}
class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾被回收了"+this.name);
    }
}

