package com.ljy.houserent;

import com.ljy.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        // 创建HouseView对象，并调用mainMenu方法，显示主菜单
        new HouseView().mainMenu();
        System.out.println("====你退出了系统====");
    }
}
