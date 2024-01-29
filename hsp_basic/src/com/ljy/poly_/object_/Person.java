package com.ljy.poly_.object_;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String say() {
        return name + "\t" + age;
    }

    // 重写equals方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {  // 地址相同，是同一个对象
            return true;
        }
        if (obj instanceof Person) {// obj是Person类型
            Person p = (Person)obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }
}
