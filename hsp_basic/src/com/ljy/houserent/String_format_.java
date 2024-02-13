package com.ljy.houserent;

import java.util.Calendar;

public class String_format_ {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
        System.out.println(s);
        System.out.println(c);
//        String str = String.format()
    }
}
