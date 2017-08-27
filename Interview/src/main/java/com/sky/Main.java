package com.sky;
class PrintToMax {
    public String[] s;
    public PrintToMax(int length){
        this.s=new String[length];
    }

    public void printToMax() {
        //将字符串数组中的值初始化为零
        for (int i = 0; i < s.length; i++) {
            s[i] = "0";
        }
        for (int i = s.length - 1; i >= 0; i--) {//++
            //如果小于等于9，就应该打印出该数
            while (Integer.parseInt(s[i]) <= 9) {
                if (i == s.length - 1)
                    print(s);
                //自增
                s[i] = Integer.parseInt(s[i]) + 1 + "";
                //判断s[i]是否是进位
                if (Integer.parseInt(s[i]) <= 9 && i != s.length - 1)
                    //进位完又从个位打印
                    i = s.length - 1;
            }
            //已经是最高位，进不了位，结束退出循环
            if (i == 0)
                break;
            //要进位将前位设置为零
            s[i] = "0";
        }
    }

    public void print(String[] s) {
        boolean flag = false;
        for (int i = 0; i < s.length ; i++) {//length-1
            if (i == s.length - 1) {
                //打印出零
                System.out.print(s[i]);
            }else{
            //从高位到低位找到第一个大于零的数
            if (Integer.parseInt(s[i]) > 0 || flag) {
                if (!flag)
                    flag = true;
                System.out.print(s[i]);
            }
            }
        }
        System.out.println("");
    }

}
public class Main{

    public static void main(String[] args){
        PrintToMax ptm = new PrintToMax(1);
        ptm.printToMax();
    }
}