package com.ljy.poly_.polyarr_;

public class polyarr_exercise {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("tom", 18, 100);
        persons[2] = new Teacher("mary", 30, 10000);
        persons[3] = new Teacher("smith", 33, 20000);
        persons[4] = new Student("king", 22, 99);
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());
            // 如果是学生，调用学生的特有方法；如果是老师，调用老师的特有方法
            if (persons[i] instanceof Student) {
                ((Student)persons[i]).study();
            } else if (persons[i] instanceof Teacher) {
                ((Teacher)persons[i]).teach();
            }

        }
    }
}
