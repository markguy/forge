package com.zm.research.inf.adapter;

/**
 * Created by 志明 on 14-1-4.
 */
public class Adapter extends Adaptee implements TargetInterface {

    @Override
    public void opt2() {
        System.out.println("Adapter opt2");
    }
}
