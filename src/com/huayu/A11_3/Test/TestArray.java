package com.huayu.A11_3.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Qiyeah on 2015/10/18.
 */
public class TestArray {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,4,5};
        method(arr);
    }
    public static void method(int[] x){
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < x.length; i++) {
            hs.add(x[i]);
        }
        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()){
            int count = 0;
            int val = it.next();
            for (int i = 0; i < x.length; i++) {
                if (val == x[i]){
                    count++;
                }
            }
            System.out.println(val+":"+count);
        }
    }
}
