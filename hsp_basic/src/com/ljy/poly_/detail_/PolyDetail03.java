package com.ljy.poly_.detail_;

public class PolyDetail03 {
    public static void main(String[] args) {
        // instanceOf 方法，看的是运行类型
        BB b = new BB();
        System.out.println(b instanceof AA); // true
        System.out.println(b instanceof BB); // true
        // 向上转型
        AA a = b;
        System.out.println(a instanceof AA); // ture
        System.out.println(a instanceof BB); // true

        String str = "hello";
        System.out.println(str instanceof Object); // true
    }
}
class AA {}
class BB extends AA {}
