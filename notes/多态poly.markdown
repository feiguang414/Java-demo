# 多态

多态存在于继承关系的两个对象（类）中。

向上转型：父类的引用指向子类的对象。`Animal animal = new Cat();` 对于 `Object obj = new Cat();`也是可以的，因为Object是所有对象的父类。我们讲的“父类”，可以认为是父类，父类的父类，... 。 

目的是什么？

**向上转型的特点是什么？**

	1. 编译类型看左边（父类），执行类型看右边（子类）。
	1. 可以调用父类的所有成员，需要遵守访问权限；不能调用子类的特有成员。
	1. 运行结果看执行类型，即从子类开始查找方法，然后调用。
	1. 在编译阶段，能调用哪些成员，是由编译器决定的。
	1. 我们在将一个细分的类型，向上转型到一个笼统的类型，那就是看中了这些个细分类型的共同的属性和方法，也就是父类的属性和方法；等到运行时候，具体实现还是要看各个细分类型的具体实现，即看子类。

**向下转型：**

1. 强制转换：向下转型，
2.  只能强转父类的引用，不能强转父类的对象。（称呼可以变化，但是本质不变）
3. 父类的对象引用 -> 子类的对象引用
4. 向下转型后，就可以调用子类中的特有方法了。

```java
public static void main(String[] args) {
        // 向上转型
        Object obj = new Cat(); // 向上转型，父类引用指向子类对象，这里的“父类”包含父类，父类的父类，...
        Animal animal = new Cat();
        // 编译类型看左边，执行类型看右边。
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
```

属性没有重写之说，属性看编译类型。

```java
public class PolyDetail02 {
    public static void main(String[] args) {
        //属性没有重写之说，属性的值看编译类型
        Base base = new Sub();
        System.out.println(base.count); // 10
        Sub sub = new Sub();
        System.out.println(sub.count);  // 20
    }
}

class Base {
    int count = 10;
}
class Sub extends Base {
    int count = 20;
}
```

`instanceOf` 比较符，看运行类型

```java
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
```



**Java的动态绑定机制（十分重要）**

1. 当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定。
2. 当调用对象属性的时候，没有动态绑定机制，哪里声明，哪里使用（按作用域走）

```java
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
```

**多态数组**

1. 多态数组是遵守动态绑定机制的，

**多态参数**

方法定义是父类类型的参数，形参可以是子类类型的参数。
