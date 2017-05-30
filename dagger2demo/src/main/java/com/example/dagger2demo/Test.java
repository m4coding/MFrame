package com.example.dagger2demo;

import javax.inject.Inject;

/**
 * @author mochangsheng
 * @description 该类的主要功能描述
 */
public class Test {

    private int a;

    @Inject
    public Test() {

    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}
