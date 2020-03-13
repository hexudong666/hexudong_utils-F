package com.hexudong.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
    * @ClassName: NumberUtil
    * @Description: TODO数字计算工具
    * @author 李倩
    * @date 2020年3月1日
    *
 */
public class NumberUtil {

    /** 
    * 判断String是否是整数 
    */  
    public static boolean isInteger(String s){  
        if((s != null)&&(s!=""))  
         return s.matches("^[0-9]*$");  
        else  
         return false;  
    }  
    /** 
    * 判断字符串是否是浮点数 
    */  
    public static  boolean isDouble(String value) {  
        try {  
           Double.parseDouble(value);  
           if (value.contains("."))  
               return true;  
           return false;  
        } catch (NumberFormatException e) {  
           return false;  
        }  
    }  
    /** 
    * 判断字符串是否是数字 
    */  
    public static boolean isNumber(String value) {  
        return isInteger(value) || isDouble(value);  
    }  
        //排序方法  
    public static void sort(int[] array) {// 小到大的排序  
        int temp = 0;  
        for (int i = 0; i < array.length; i++) {  
            for (int j = i; j < array.length; j++) {  
                if (array[i] > array[j]) {  
                    temp = array[i];  
                    array[i] = array[j];  
                    array[j] = temp;  
                }  
            }  
        }  
    }  
  
    /** 
     * 是否是质数 
     */  
    public static boolean isPrimes(int n) {  
        for (int i = 2; i <= Math.sqrt(n); i++) {  
            if (n % i == 0) {  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /** 
     * 阶乘 
     * @param n 
     * @return 
     */  
    public static int factorial(int n) {  
        if (n == 1) {  
            return 1;  
        }  
        return n * factorial(n - 1);  
    }  
    /** 
     * 平方根算法 
     * @param x 
     * @return 
     */  
    public static long sqrt(long x) {  
        long y = 0;  
        long b = (~Long.MAX_VALUE) >>> 1;  
        while (b > 0) {  
            if (x >= y + b) {  
                 x -= y + b;  
                 y >>= 1;  
                 y += b;  
            } else {  
                 y >>= 1;  
            }   
            b >>= 2;  
       }   
        return y;  
    }  
      
    private static int math_subnode(int selectNum, int minNum) {  
        if (selectNum == minNum) {  
            return 1;  
        } else {  
            return selectNum * math_subnode(selectNum - 1, minNum);  
        }  
    }  
  
    private static int math_node(int selectNum) {  
        if (selectNum == 0) {  
            return 1;  
        } else {  
            return selectNum * math_node(selectNum - 1);  
        }  
    }  
    /** 
     * 可以用于计算双色球、大乐透注数的方法 
     * selectNum：选中了的小球个数 
     * minNum：至少要选中多少个小球 
     * 比如大乐透35选5可以这样调用processMultiple(7,5); 
     * 就是数学中的：C75=7*6/2*1 
     */  
    public static int processMultiple(int selectNum, int minNum) {  
        int result;  
        result = math_subnode(selectNum, minNum)  
                / math_node(selectNum - minNum);  
        return result;  
    }  
  
/**
* 求m和n的最大公约数
*/     
    public static int gongyue(int m, int n) {     
        while (m % n != 0) {     
            int temp = m % n;     
            m = n;     
            n = temp;     
        }     
        return n;     
    }     
    
    /**   
     * 求两数的最小公倍数   
     */       
    public static int gongbei(int m, int n) {     
        return m * n / gongyue(m, n);     
    }  
      
    /**   
     * 递归求两数的最大公约数   
     */     
    public static int divisor(int m,int n){      
        if(m%n==0){     
           return n;     
       }else{     
           return divisor(n,m%n);     
       }     
    }  
    public static void main(String[] args){  
      NumberUtil util=new NumberUtil();  
      System.out.println(util.sqrt(100));
    }  

}
