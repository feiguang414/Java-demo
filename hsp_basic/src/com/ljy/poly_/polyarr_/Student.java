package com.ljy.poly_.polyarr_;

public class Student extends Person {
    private int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String say() {
        return "student" + super.say() + "\tscore" + score;
    }
    public void study() {
        System.out.println("学生" + getName() + "正在学习");
    }
}
