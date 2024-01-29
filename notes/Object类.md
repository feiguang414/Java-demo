# Object类

```
equals(Object obj)
finalize()
getClass()
hashCode()
toString()
```

**`==` 和 `equal` 的区别？**

== 是一个比较运算符，可以判断基本类型，也可以判断引用类型。
== 判断基本类型：判断值
== 判断引用类型：判断地址是否相等。

**equals 方法**

1. 是Object类中的一个方法，只能判断引用类型。
2. 默认是判断地址是否相同，子类中往往重写该方法，用于判断内容是否相等。 

```java
/**
 * Compares this string to the specified object.  The result is {@code
 * true} if and only if the argument is not {@code null} and is a {@code
 * String} object that represents the same sequence of characters as this
 * object.
 *
 * @param  anObject
 *         The object to compare this {@code String} against
 *
 * @return  {@code true} if the given object represents a {@code String}
 *          equivalent to this string, {@code false} otherwise
 *
 * @see  #compareTo(String)
 * @see  #equalsIgnoreCase(String)
 */
public boolean equals(Object anObject) { // 形参只要是Object对象，都可以传进去
    if (this == anObject) {	//先通过==判断地址是否相同，即是否是同一个对象
        return true;
    }
    if (anObject instanceof String) {	//判断类型是否相同，
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {	//然后一个一个地比较字符
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

**如何重写 equals 方法？**

```java
// 重写equals方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {  // 地址相同，是同一个对象
            return true;
        }
        if (obj instanceof Person) {// obj是Person类型
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }
```

**`hashCode` 方法**

1. 提高具有哈希结构的容器的效率
2. 两个引用，指向的是同一个对象，哈希值一定相同。
3. 两个引用，指向的是不同对象，哈希值不一样。
4. 哈希值主要从地址号来，但是不能将哈希值等价为地址。
5. 后面在集合中，`hashCode` 如果需要的话，也会重写

**finalize 方法**

1. 当对象被回收的时候，系统自动调用该对象的finalize方法。子类可以重写该方法做一些释放资源的操作。
2. 什么时候被回收？
   当某个对象没有任何引用时，则`jvm`就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁该对象，在销毁该对象前，会先调用finalize方法。比如：数据库的连接，或者打开的文件流。
3. 垃圾回收机制的调用，由系统来决定，也可以通过`System.gc()`主动触发垃圾回收机制，测试：Car

```
Car bmw = new Car("宝马");
bmw = null; //堆中的car对象 没有任何对象引用指向它，car对象成为了一个垃圾。

```

