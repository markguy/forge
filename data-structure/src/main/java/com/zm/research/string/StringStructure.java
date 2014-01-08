package com.zm.research.string;

import java.util.Arrays;

/**
 * Created by 志明 on 14-1-4.
 */
public class StringStructure {

    public static void main(String[] args) {
        String temp = "DKKDHSDUjjkjsdkjslf";
        char[] tempArray = temp.toCharArray();
        System.out.println(tempArray);
        Arrays.sort(tempArray);
        System.out.println(tempArray);
    }
}
