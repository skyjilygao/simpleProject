package com.sky.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by SKYJILYGAO on 2017/8/18.
 */
public class JNumbersByRecursion2 {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        new Thread(new Runnable() {
//            @Override
            public void run() {
                int nNumber = 3;//测试数据n为5
                try {
                    if (reader.read() != -1) {
                        String inPut = reader.readLine();
                        try {
                            nNumber = Integer.valueOf(inPut);
                        } catch (NumberFormatException e) {
                            System.out.print("请输入正整数!");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                char[] num = new char[nNumber];
                for (int i = 0; i < 10; i++) {//此处的i代表字符数组的最高位的值可从0取到9
                    num[0] = (char) ('0' + i);
                    inc(num, nNumber, 0);
                }
            }
        }).start();
    }

    /**
     * * @param num 代表字符数组 从0开始，依次表示高位到低位。如果输入是3，表示 0：百位上的数，1：十位上的数，2：个位上的数。
     * @param len len 代表祖父数组的长度
     * @param i i 代表的是字符数组上的某一位
     */
    private static void inc(char[] num, int len, int i) {
        int j = 0;
        if (i == len - 1) {//当i为最后一位的时候输出此数
            print(num);//每执行一次此方法就是确定了一个数，此处会执行n的10次方次
            return;
        }
        for (j = 0; j < 10; j++) {
            //j代表的是数组上每一位都可以从0增加到9
            //num 从0开始，依次表示高位到低位。如果输入是3，表示 0：百位上的数，1：十位上的数，2：个位上的数。
            num[i + 1] = (char) ('0' + j);//例如n等于20，那么当i等于19的时候，此处代码任会执行10次，输出10个数，在这个过程中i不会增加
            inc(num, len, i + 1);//迭代使得字符数组上的每一位都可以从0增到9，那么总共执行了此方法n的10次方次
        }
    }

    /**
     * 此方法用于将字符数组（过滤高位的0，以符合阅读习惯）输出到控制台
     * @param num 字符数组 .从0开始，依次表示高位到低位。如果输入是3，表示 0：百位上的数，1：十位上的数，2：个位上的数。
     */
    private static void print(char[] num) {
        int i = 0;
        int len = num.length;
        while (i < len && num[i] == '0') {
            i++;
        }
        char[] number = new char[len - i];
        for (int j = i; j < len; j++) {
            number[j - i] = num[j];
        }
        System.out.print(number);
        System.out.println();
    }
}

