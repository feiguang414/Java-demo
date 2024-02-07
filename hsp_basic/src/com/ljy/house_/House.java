package com.ljy.house_;

import java.util.Scanner;

public class House {
    private String name;
    private String phone;
    private String address;
    private double rent;
    private String state;

    public House addHouseView() {
        System.out.println("==========添加房屋==========");
        House house = new House();
        Scanner scanner = new Scanner(System.in);
        System.out.print("姓名：");
        house.setName(scanner.next());
        System.out.print("电话：");
        house.setPhone(scanner.next());
        System.out.print("地址：");
        house.setAddress(scanner.next());
        System.out.print("月租：");
        house.setRent(scanner.nextFloat());
        System.out.print("状态（未出租/已出租）：");
        house.setState(scanner.next());
        System.out.print("==========添加完成==========");
        return house;
    }

    public House() {
    }

//    @Override
//    public String toString() {
//        return
//    }

    public House(String name, String phone, String address, double rent, String state) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void modifyHouse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========修改房屋信息==========");
        System.out.print("姓名：");
        this.setName(scanner.next());
        System.out.print("电话：");
        this.setPhone(scanner.next());
        System.out.print("地址：");
        this.setAddress(scanner.next());
        System.out.print("月租：");
        this.setRent(scanner.nextFloat());
        System.out.print("状态（未出租/已出租）：");
        this.setState(scanner.next());
        System.out.println("==========修改完成==========");
    }
}
