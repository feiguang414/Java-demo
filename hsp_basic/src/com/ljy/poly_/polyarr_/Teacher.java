package com.ljy.poly_.polyarr_;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public String say() {
        return "teacher" + super.say() + "\tsalary=" + salary;
    }
    public void teach() {
        System.out.println("老师" + getName() + "正在讲课");
    }
}
