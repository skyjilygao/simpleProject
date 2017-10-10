package com.sky.interview;

import org.hibernate.Criteria;

import java.util.HashMap;
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

        Integer i3=1;
        Integer i4=1;
        System.out.println("i3==i4:"+(i3==i4));

        String str1="hello";
        String str2=str1;
        str1="abc";
//        changeStr(str1);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("str1==str2:"+(str1==str2));

        int ai=1;
        System.out.println(ai++);
        System.out.println(ai);
        HashMap map=new HashMap();
        map.values();

        Object object=new Object();
        object.hashCode();
        HashMap map1=new HashMap();
        map1.hashCode();
    }
    public static void changeStr(String str){
        str="abc";
    }
    public void dao(){

//        Criteria.ALIAS_TO_ENTITY_MAP;
//Criteria.DISTINCT_ROOT_ENTITY
//Criteria.PROJECTION
//        Criteria.ROOT_ENTITY

    }

}
