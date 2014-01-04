package com.zm.research.inf.adapter;

/**
 * Created by 志明 on 14-1-4.
 */
public class ObjectAdapter implements TargetInterface {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void opt1() {
       adaptee.opt1();
    }

    @Override
    public void opt2() {
        System.out.println(this.getClass().getSimpleName() + "  opt2");
    }
}
