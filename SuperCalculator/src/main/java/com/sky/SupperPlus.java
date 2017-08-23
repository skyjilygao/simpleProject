package com.sky;

/**
 * Created by SKYJILYGAO on 2017/8/23.
 * 大数相加
 */
public class SupperPlus {
    public static void main(String[] args){
        String str1="95209078998420089760";
        String str2="91413312386238923670";//12065400=652090+11413310
        String retv="";
        retv= plus(str1,str2);
        System.out.println(str1+" + "+str2+" = "+retv);
    }

    /**
     * 2数相加
     * @param str1
     * @param str2
     * @return
     */
    public static String plus(String str1,String str2){
        String retv="";
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        char[] arr11=pchange(arr1);
        char[] arr22=pchange(arr2);
        int[] he;
        if(arr11.length<arr22.length){
            he=new int[arr22.length+1];
        }else{
            he=new int[arr11.length+1];
        }
        //由于加法和乘法不同，加法以末尾对其相加，循环时以长度短的为主，进行相加，最后再将长度较长的数多出的部分加到和中。
        if(arr11.length<arr22.length){
            int a=0;
            for(int i=0;i<arr11.length;i++){
                he[i]=(Integer.parseInt(arr11[i]+"")+Integer.parseInt(arr22[i]+""));
                a++;
            }
            if(a==arr11.length){
                for(;a<arr22.length;a++){
                    he[a]=(Integer.parseInt(arr22[a]+""));
                }
            }
        }else if(arr11.length>arr22.length){
            int a=0;
            for(int i=0;i<arr22.length;i++){
                he[i]=(Integer.parseInt(arr11[i]+"")+Integer.parseInt(arr22[i]+""));
                a++;
            }
            if(a==arr22.length){
                for(;a<arr11.length;a++){
                    he[a]=(Integer.parseInt(arr11[a]+""));
                }
            }
        }else{
            for(int i=0;i<arr22.length;i++){
                he[i]=(Integer.parseInt(arr11[i]+"")+Integer.parseInt(arr22[i]+""));
            }
        }
        retv=carry(he);
        return retv;
    }

    /**
     * 将数组前后位置互换，方便计算
     * @param chars
     * @return
     */
    public static char[] pchange(char[] chars){
        if(chars==null || chars.length==0){
            return null;
        }
        char[] arr=new char[chars.length];
        int j=0;
        for(int i=chars.length-1;i>=0;i--){
            arr[j]=chars[i];
            j++;
        }
        return arr;
    }

    /**
     * 考虑进位
     * @param intArr
     * @return
     */
    public static String carry(int[] intArr){
        StringBuffer retv=new StringBuffer("");
        if(intArr!=null && intArr.length>0){
            for(int i=0;i<intArr.length-1;i++){
                if(intArr[i]>9){
                    intArr[i+1] += intArr[i]/10;
                    intArr[i] =intArr[i]%10;
                }
            }
            int k=0;
            for(int i=intArr.length-1;i>=0;i--){
                if(intArr[i]==0 && k==0){
                }else{
                    retv.append(intArr[i]);
                    k=1;
                }
            }
        }

        return retv.toString();
    }
}
