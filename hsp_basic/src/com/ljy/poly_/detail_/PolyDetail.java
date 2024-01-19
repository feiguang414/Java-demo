package com.ljy.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {
        // 向上转型
        Object obj = new Cat(); // 向上转型，父类引用指向子类对象，这里的“父类”包含父类，父类的父类，...
        Animal animal = new Cat();
        // 编译类型看左边，运行类型看右边。
        // 可以调用的方法只能是编译类型里面的方法，除非强制转换。
        animal.cry(); // 小猫喵喵叫，执行结果看运行类型，从子类开始查找方法
        animal.show(); // hello,i am an animal.

        // 强制转换：向下转型，
        // 只能强转父类的引用，不能强转父类的对象。（称呼可以变化，但是本质不变）
        // 父类的对象引用 -> 子类的对象引用
        // 向下转型后，就可以调用子类中的特有方法了。
        Cat cat = (Cat)animal;
        cat.catchMouse(); // 小猫抓老鼠
    }
}
