package com.ljy.poly_.detail_.exercise_;

public class PolyExercise01 {
    public static void main(String[] args) {
        // 双精度转为整型，精度会丢失，但可以进行强转
        double d = 2.1;
        long l = (long)d;
        System.out.println(d);
        System.out.println(l);
        // 整型不能强转为布尔型，编译就会报错
        int i = 9;
//        boolean b = (boolean) i;  // boolean -> int 是错误的
        // Object 对象引用String类型对象，可以通过向下转型，转为String类型
        Object obj = "hello";   // 向上转型
        String str = (String)obj;
        System.out.println(str);
        // Object 对象引用Integer类型对象，可以通过向下转型，转为Integer类型；不能转为String的对象引用
        Object obj2 = new Integer(4);   // 向上转型
//        String str2 = (String)obj2; // 报错
        Integer str3 = (Integer)obj2;   // 正确

    }
}
