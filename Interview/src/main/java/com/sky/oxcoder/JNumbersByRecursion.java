package com.sky.oxcoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 给出一个正整数 n 表示数字的位数，试着用递归的方法找到并输出从1到最大的n位整数
 *
 */

public class JNumbersByRecursion {

	public static void main(String[] args) {
        int n = 3;
		long l1=new Date().getTime();
		for (Integer integer : numbersByRecursion(n)) {
			System.out.println(integer);
		}
System.out.println("耗时："+(new Date().getTime()-l1));
	}

	public static List<Integer> numbersByRecursion(int n) {
		int temp = 1;
		List<Integer> result = new ArrayList<Integer>();
		//No.1
		//开始写代码，请在这里实现算法。
		//给出一个正整数 n 表示数字的位数，试着用递归的方法找到并输出从1到最大的n位整数。
		for(int i = 1;i<=n;i++) {
			//以下使用非递归方式
			/*String s="";
			for(int b=1;b<=i;b++){
				s+="9";
			}
			if (i >= 1) {
				for (int j = 0; j <= Integer.parseInt(s); j++) {
					result.add(j);
				}
			}
			*/
			//使用递归 //参考网友：http://blog.csdn.net/wutingyehe/article/details/51191520
			if(n == 1) {
				result = new ArrayList<Integer>();
				for(int j = 1; j <= 9; j++) {
					result.add(j);
				}
				return result;
			}else {
				List<Integer> list = numbersByRecursion(n-1);
				result = new ArrayList<Integer>(list);
				for(int j = 1; j <= 9; j++) {
					int topdigit = (int)Math.pow(10, n-1) * j;
					result.add(topdigit);
					for(int i1 = 0; i1 < list.size(); i1++) {
						result.add(topdigit + list.get(i1));
					}
				}
				return result;
			}
		}
		//end_code
		return result;
	}
}