package com.sky;

/**
 * Created by skyjilygao on 2017/7/25.
 * 大数相乘。参考
 * http://blog.csdn.net/sunkun2013/article/details/11822927
 *
 */
public class SuperMultiply {
    public static void main(String[] args){
        String str1="978967834563835640";
        String str2="988964354654040";
        String retv="";
        retv= multiply(str1,str2);
        System.out.println(str1+" * "+str1+" = "+retv);
    }

    /**
     * 将字符串转换乘char数组，调用multiply2方法
     * @param str1
     * @param str2
     * @return 结果retv
     */
    public static String multiply(String str1, String str2){
        String retv="";
        char[] char1=str1.toCharArray();
        char[] char2=str2.toCharArray();
        retv= multiply2(char1,char2);
        return retv;
    }

    /**
     * 将char数组转换乘int数组，调用multiply3方法
     * @param char1
     * @param char2
     * @return 结果retv
     */
    public static String multiply2(char[] char1, char[] char2){
        String retv="";
        int[] int1=new int[char1.length];
        int[] int2=new int[char2.length];
        for(int i=0;i<char1.length;i++){
            int1[i]=Integer.parseInt(char1[i]+"");
        }
        for(int i=0;i<char2.length;i++){
            int2[i]=Integer.parseInt(char2[i]+"");
        }
        retv= multiply3(int1,int2);
        return retv;
    }

    /**
     * 乘积的位数
     * 1、将乘数和被乘数中各个相乘，放入intRetv二维数组中。在根据同位相加放入intRetv数组中。
     * 2、考虑进位问题：将intRetv二维数组中元素大于9的，全部进位，放入intr数组中
     * @param int1
     * @param int2
     * @return
     */
    public static String multiply3(int[] int1, int[] int2){
        String retv="";
        int[][] intRetv=new int[int1.length][int2.length];
        for(int i=0;i<int1.length;i++){
            for(int j=0;j<int2.length;j++){
                intRetv[i][j]=int1[i]*int2[j];
            }
        }
        int size=int1.length+int2.length-1;
        int k=0;
        int[] intr=new int[size];
        //考虑进位问题：将intRetv二维数组中元素大于9的，全部进位
        while (k<size){
            for(int i=0;i<int1.length;i++){
                for(int j=0;j<int2.length;j++){
                    if (i+j==k) {
                        intr[k] += intRetv[i][j];
                        break;
                    }
                }
            }
            k++;
        }
        retv= multiply4(intr);
        return retv;
    }

    /**
     * 根据结果，考虑进位。
     * @param intr
     * @return 返回最终计算结果
     */
    public static String multiply4(int[] intr){
        String retv="";
        for(int i=intr.length-1;i>0;i--){
            if(intr[i]>9) {
                intr[i - 1] += intr[i] / 10;
                intr[i] = intr[i] % 10;
            }
        }
        for(int i=0;i<intr.length;i++){
            retv+=intr[i];
        }
        return retv;
    }
}
