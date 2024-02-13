//package com.ljy.houserent;
//
//import com.ljy.houserent.domain.House;
//
//import java.util.Scanner;
//
//public class Menu {
//    public static void main(String[] args) {
//        House[] houses = new House[100];
//        int i = 0;
//        // 测试数据：House[0]用来测试，打印房屋列表的格式。
//        houses[0] = new House("张小斐", "123456", "杭州", 1000, "未出租");
//        i = 1;
//        char ch;
//        boolean flag = true;
//        Scanner scanner = new Scanner(System.in);
//        while (flag) {
//            MenuPrint();
//            System.out.print("请选择(1-6):");
//            ch = scanner.next().charAt(0);  //获取输入的第一个字符
//            switch (ch) {
//                case '1':
//                    System.out.println("新增房源");
//                    houses[i++] = new House().addHouseView();
//                    break;
//                case '2':
//                    System.out.println("查找房屋");
//                    System.out.println("请输入要查找的房屋编号");
//                    int findIndex = scanner.nextInt();
//                    FindHouse(houses,findIndex,i);
//                    break;
//                case '3':
//                    System.out.println("删除房屋");
//                    System.out.println("请输入要删除的房屋编号");
//                    int deleteId = scanner.nextInt();
//                    DeleteHouse(houses,deleteId-1,i);
//                    break;
//                case '4':
//                    System.out.println("修改房屋信息");
//                    System.out.println("请输入要修改的房屋编号");
//                    int modifyId = scanner.nextInt();
//                    houses[modifyId-1].modifyHouse();
//                    break;
//                case '5':
////                    System.out.println("房屋列表");
//                    printHouseList(houses,i);
//                    break;
//                case '6':
//                    System.out.println("退出系统");
//                    flag = false;
//                    break;
//                default:
//                    System.out.println("输入有误");
//                    flag = false;
//                    break;
//            }
//        }
//
//    }
//    public static void DeleteHouse(House[] houses,int id,int num) {
//        if (id < 0 || id >= num) {
//            System.out.println("=====没有找到房屋信息======");
//            return;
//        } else {
//            for (int i = id; i < num - 1; i++) {
//                houses[i] = houses[i+1];
//            }
//            System.out.println("=====删除房屋信息成功======");
//        }
//    }
//    private static void FindHouse(House[] houses,int findIndex,int num) {
//        if (findIndex < 0 || findIndex >= num) {
//            System.out.println("=====没有找到房屋信息======");
//            return;
//        } else {
//            PrintOneHouse(houses,findIndex);
//        }
//    }
//
//    // 按id来打印一个房屋信息
//    public static void PrintOneHouse(House[] houses,int id) {
//        System.out.println("编号\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
//        System.out.println((id+1) + "\t" + houses[id].getName() + "\t" + houses[id].getPhone() + "\t" +
//                houses[id].getAddress() + "\t" + houses[id].getRent() + "\t" + houses[id].getState());
//    }
//
//    public static void MenuPrint() {
//        System.out.println("===房屋出租系统菜单===");
//        System.out.println("\t1 新 增 房 源");
//        System.out.println("\t2 查 找 房 屋");
//        System.out.println("\t3 删 除 房 屋");
//        System.out.println("\t4 修 改 房 屋 信 息");
//        System.out.println("\t5 房 屋 列 表");
//        System.out.println("\t6 退 出 系 统");
//    }
//    public static void printHouseList(House[] houses,int num) {
//        System.out.println("==========房屋列表==========");
//        System.out.println("编号\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
//        for (int i = 0; i < num; i++) {
//            System.out.println((i+1) + "\t" + houses[i].getName() + "\t" + houses[i].getPhone() + "\t" +
//                    houses[i].getAddress() + "\t" + houses[i].getRent() + "\t" + houses[i].getState());
//        }
//        // 实现左对齐
////        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-%15s-15s","编号","房主","电话","地址","月租","状态"));
////        for (int i = 0; i < num; i++) {
////            System.out.println(String.format("%-10d%-20s%-20s%-20s%-20.2f%-%15s-15s",
////                    i+1,houses[i].getName(),houses[i].getPhone(),
////                    houses[i].getAddress(), houses[i].getRent(),houses[i].getState()));
////        }
//        System.out.println("=========房屋列表完成=========");
//    }
//}
