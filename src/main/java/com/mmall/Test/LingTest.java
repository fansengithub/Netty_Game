package com.mmall.Test;

import java.util.Arrays;

public class LingTest {
    public static void main(String[] args) {
        String[] arrayid="1|2|38".split("\\|");
        for (int i=0;i<arrayid.length;i+=1){
            System.out.println("a"+arrayid[i]);

        }
        System.out.printf("aaaa"+Arrays.toString(arrayid));
    }
}
