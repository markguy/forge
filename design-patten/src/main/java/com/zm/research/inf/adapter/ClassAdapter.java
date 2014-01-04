package com.zm.research.inf.adapter;

/**
 * Created by 志明 on 14-1-4.
 */
public class ClassAdapter extends Adaptee implements TargetInterface {

    @Override
    public void opt2() {
        System.out.println(this.getClass().getSimpleName() + "  opt2");
    }
}
