package com.zm.research.inf.adapter;

/**
 * Created by 志明 on 14-1-4.
 */
public class MainTest {

    public static void main(String[] strings){
        TargetInterface target = new Adapter();
        target.opt1();
        target.opt2();
    }
}
