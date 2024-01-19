关于转义字符 \u

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191412581.png)

**<u>关于char类型</u>**

有些Unicode字符可以用一个char来描述，有些Unicode字符需要两个char字符。所以，尽量不要用char类型。

在Java中，整数表达式 x = 0 不能转化为布尔值，无法通过编译。

```java
if (x = 0) {
	...
}
```

**<u>关于Math计算：</u>**

floorMod解决余数为负数的情况，当被除数为负数的时候，使用floorMod，余数不为负数，但倘若除数为负数，余数仍为负数。`floorMod(position+adjustment, 12)`。

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191430761.png)

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191430430.png)

**<u>关于数值类型之间的转化：</u>**

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191433233.png)

<u>关于字符串的操作：</u>

```java
// 将多个字符串放在一起，用一个界定符分隔，可以使用静态join方法
String all = String.join("/","S","M","L","XL");
// all is the string "S/M/L/XL"
在Java11 中，提供了一个repeat方法：
String repeted = "Java".repeat(3); // repeated is "JavaJavaJava"
```

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191441981.png)

关于空串和 Null串 

```java
if (str != null && str.length() != 0)
```

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191444534.png)

StringBuilder 

StringBuilder 为了减少字符串的复制，可以采用 `append` 方法。

封装encapsulation

封装，有时候称作数据隐藏，是处理对象的一个重要概念。封装给对象赋予了“黑盒”的特征，程序只能通过对象的方法与对象的数据进行交互，绝对不会让类中的方法直接访问其他类中的实例字段。

区分对象与对象变量

对象变量可以更换引用指向，

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191525061.png)

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191526511.png)



访问器方法 和 更改器方法

`LocalDate.plusDates()` 就是访问器方法，不会更改原来的值，而是会创建新的对象。

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191551842.png)

![](https://gitee.com/feiguang4/blog-image/raw/master/img/202401191552333.png)

