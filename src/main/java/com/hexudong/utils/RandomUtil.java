package com.hexudong.utils;



import java.util.Random;

/**
 * @ClassName:  RandomUtil   
 * @Description:随机数工具类   
 * @date:   2020年1月3日 上午9:07:35
 */
public class RandomUtil {
	/**
	 * @Title: random   
	 * 
	 * @Description: 获得指定区间的随机数   
	 * @param: @param min
	 * @param: @param max
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int random(int min,int max) {
		Random random = new Random();
		int nextInt = random.nextInt(max-min+1);
		if(nextInt<min) {
			return random(min,max);
		}
		return nextInt;
	}
	 /**  生成不重复随机数
     * 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组  
     * @param begin 最小数字（包含该数）  
     * @param end 最大数字（不包含该数）  
     * @param size 指定产生随机数的个数  
     */    
    public int[] generateRandomNumber(int begin, int end, int size) {    
        // 加入逻辑判断，确保begin<end并且size不能大于该表示范围    
        if (begin >= end || (end - begin) < size) {    
            return null;    
        }           
        // 种子你可以随意生成，但不能重复    
        int[] seed = new int[end - begin];     
        
        for (int i = begin; i < end; i ++) {    
            seed[i - begin] = i;    
        }    
        int[] ranArr = new int[size];    
        Random ran = new Random();    
        // 数量你可以自己定义。    
        for (int i = 0; i < size; i++) {    
            // 得到一个位置    
            int j = ran.nextInt(seed.length - i);               
            // 得到那个位置的数值    
            ranArr[i] = seed[j];    
            // 将最后一个未用的数字放到这里    
            seed[j] = seed[seed.length - 1 - i];    
        }    
        return ranArr;    
    }  

}
