package com.ljy.houserent.service;

import com.ljy.houserent.domain.House;

/**
 * 业务层
 * 定义House[],保存House对象
 * 1.响应HouseView的调用
 * 2.完成对房屋信息的各种操作（增删改查）
 */
public class HouseService {
    private House[] houses;
    private int houseNums = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;//记录当前id的值
    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "jack", "1234", "西安", 1000, "未出租");
    }
    //del方法，删除房屋信息
    public boolean del(int id) {
        if (id < 0 || id > houseNums) {
            return false;
        }
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == id) {
                for (int j = i; j < houseNums - 1; j++) {
                    houses[j] = houses[j + 1];
                }
                houses[--houseNums] = null;
                return true;
            }
        }
        return true;
    }

    //add方法，添加房屋信息
    public boolean add(House newHouse) {
        if (houseNums == houses.length) {
            System.out.println("房屋信息已满，无法添加");
            return false;
        }
        houses[houseNums++] = newHouse;
        // id自增长
        newHouse.setId(++idCounter);
//        idCounter++;
//        newHouse.setId(idCounter);
        return true;
    }

    //list方法，返回houses数组
    public House[] list() {
        return houses;
    }

}
