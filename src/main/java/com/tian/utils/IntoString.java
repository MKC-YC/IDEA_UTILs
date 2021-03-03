package com.tian.utils;

public class IntoString {
    public static void main(String[] args) {
        String str = "13260508536";
        if(str.length() !=0 && str != null){
//            Integer i = Integer.parseInt(str);
            Integer i = Integer.valueOf(str);
            System.out.println(i);
        }
        System.out.println();
    }
}
