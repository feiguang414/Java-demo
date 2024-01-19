package com.ljy.poly_.detail_.exercise_;

public class PolyExercise02 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count); // 20
        sub.show(); // 20
        // 向上转型
        Base base = sub;
        System.out.println(base.count); // 10,属性没有重写，所以是父类的属性
        base.show(); // 20,方法被重写，所以是子类的方法
        System.out.println(base == sub); // true,指向的对象是同一个
    }
}

class Base {
    int count = 10;
    public void show () {
        System.out.println("Base::show() count=" + count);
    }
}
class Sub extends Base {
    int count = 20;

    @Override
    public void show() {
        System.out.println("Sub::show() count=" + count);
    }
}
