package com.duoduo.hashming.artisan.config;

import java.util.ArrayList;

public class JavaTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        for (int j = 0; j < arr.length; j++) {
            System.out.println("索引是："+j+" 对应的值是："+arr[j]);
        }

        System.out.println("----------------------------");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int j = 0; j < list.size(); j++) {
            System.out.println("索引是：" + j + " 对应的值是：" + list.get(j));
        }
    }
}
