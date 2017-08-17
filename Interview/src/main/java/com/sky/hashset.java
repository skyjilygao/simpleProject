package com.sky;

import java.util.HashSet;

/**
 * Created by SKYJILYGAO on 2017/8/16.
 */
public class hashset {
    HashSet set=new HashSet();
    public static void main(String[] args){
        int a=1;
        int b=0;
        b+=a++;
        System.out.println("a="+a);
        System.out.println("b="+b);
        Integer i1=150;
        Integer i2=150;
        System.out.println(i1==i2);

        String str1="hello";
        String str2=str1;
        str1="abc";
//        changeStr(str1);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("str1==str2:"+(str1==str2));
    }
    public static void changeStr(String str){
        str="abc";
    }
}
