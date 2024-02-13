package com.ljy.houserent.view;

import com.ljy.houserent.domain.House;
import com.ljy.houserent.service.HouseService;
import com.ljy.houserent.utilty.Utility;

/**
 * 1.显示页面
 * 2.接收用户的输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;    //控制显示菜单
    private char key = ' ';     //接收用户的选择
    private HouseService houseService = new HouseService(6);  //通过houseService来调用一些方法

    //编写delHouse()，接收输入，调用HouseService的del方法
    public void delHouse() {
        System.out.println("==========删除房屋==========");
        System.out.print("请输入要删除的房屋编号：");
        int id = Utility.readInt();
        if (houseService.del(id)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //编写addHouse()，接收输入，创建House对象，调用add方法
    public void addHouse() {
        System.out.println("==========添加房屋==========");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        double rent = Utility.readInt();
        System.out.print("状态（未出租/已出租）：");
        String state = Utility.readString(3);
        // 创建一个House对象,id是系统分配的，用户不能输入
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //编写listHouse()，显示房屋列表
    public void listHouse() {
        System.out.println("=======房屋列表=======");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null){
                continue;
            }
            System.out.println(houses[i]);
        }
        System.out.println("======房屋显示完毕======");
    }

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("==========房屋出租系统==========");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出 系 统");
            System.out.print("请输入你的选择(1-6)：");
            key = Utility.readChar();
            switch (key){
                case '1':
                    System.out.println("新增房源");
                    addHouse();
                    break;
                case '2':
                    System.out.println("查找房屋");
                    System.out.println("请输入要查找的房屋编号");
                    break;
                case '3':
                    System.out.println("删除房屋");
                    delHouse();
                    break;
                case '4':
                    System.out.println("修改房屋信息");
                    System.out.println("请输入要修改的房屋编号");
                    break;
                case '5':
                    System.out.println("房屋列表");
                    listHouse();
                    break;
                case '6':
                    System.out.println("退出系统");
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误");
                    loop = false;
                    break;
            }
        }while (loop);
    }
}
