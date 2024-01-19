package com.ljy.poly_.dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {
        // 向上转型
        A a = new B();  // a的编译类型是A，运行类型是B，方法从运行类型中开始查找
        System.out.println(a.sum()); // 30，错误；应该是40；若将子类是sum()方法注销，则输出30
        System.out.println(a.sum1()); // 20，错误；应该是30

        // 向下转型
        B b = (B)a;
        System.out.println(b.sum()); // 40
        System.out.println(b.sum1());  // 30

    }
}

class A {
    public int i = 10;
    public int sum() {
        return getI() + 10; // 子类中
    }
    public int sum1() {
        // 属性没有动态绑定机制，所以这里的i是A类的i
        return i + 10;  // 这里的i相当于this.i，即 return this.i + 10;
    }
    public int getI() {
        return i;
    }
}
class B extends A {
    public int i = 20;

//    @Override
//    public int sum() {
//        return i + 20;
//    }
//    @Override
//    public int sum1() {
//        return i + 10;
//    }
    @Override
    public int getI() {
        // 属性没有动态绑定机制，哪里声明，哪里使用
        return i;   // 这里的i相当于this.i
    }
}
