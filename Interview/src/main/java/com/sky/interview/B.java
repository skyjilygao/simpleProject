package com.sky.interview;

/**
 * Created by SKYJILYGAO on 2017/8/16.
 */

/**
 * 父类子类，父类优先，父子类有static块，static块优先，再执行构照方法。
 */
public class B extends A {
    static {
        System.out.println("子类中静态块static B");
    }
    public B(){
        System.out.println("子类中构照方法construct B");
    }
    public static void main(String[] args){
        B b=new B();
    }
}

