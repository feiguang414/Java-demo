package com.ljy.poly_.detail_;

public class Cat extends Animal{
    @Override
    public void cry() {
        System.out.println("小猫喵喵叫");
    }
    public void catchMouse() {  // 特有方法
        System.out.println("小猫抓老鼠");
    }
}
