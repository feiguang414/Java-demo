package com.ljy.house_;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        House[] houses = new House[100];
        int i = 0;
        char ch;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            MenuPrint();
            System.out.print("请选择(1-6):");
            ch = scanner.next().charAt(0);  //获取输入的第一个字符
            switch (ch) {
                case '1':
                    System.out.println("新增房源");
                    houses[i++] = new House().addHouseView();
                    break;
                case '2':
                    System.out.println("查找房屋");
                    break;
                case '3':
                    System.out.println("删除房屋");
                    break;
                case '4':
                    System.out.println("修改房屋信息");
                    break;
                case '5':
//                    System.out.println("房屋列表");
                    printHouseList(houses,i);
                    break;
                case '6':
                    System.out.println("退出系统");
                    flag = false;
                    break;
                default:
                    System.out.println("输入有误");
                    flag = false;
                    break;
            }
        }

    }
    public static void MenuPrint() {
        System.out.println("===房屋出租系统菜单===");
        System.out.println("\t1 新 增 房 源");
        System.out.println("\t2 查 找 房 屋");
        System.out.println("\t3 删 除 房 屋");
        System.out.println("\t4 修 改 房 屋 信 息");
        System.out.println("\t5 房 屋 列 表");
        System.out.println("\t6 退 出 系 统");
    }
    public static void printHouseList(House[] houses,int num) {
        System.out.println("==========房屋列表==========");
        // 实现左对齐
        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-%15s-15s","编号","房主","电话","地址","月租","状态"));
        for (int i = 0; i < num; i++) {
            System.out.println(String.format("%-10d%-20s%-20s%-20s%-20.2f%-%15s-15s",
                    i+1,houses[i].getName(),houses[i].getPhone(),
                    houses[i].getAddress(), houses[i].getRent(),houses[i].getState()));
        }
        System.out.println("=========房屋列表完成=========");
    }
}
