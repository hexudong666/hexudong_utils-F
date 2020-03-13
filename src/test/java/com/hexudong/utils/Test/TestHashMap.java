package com.hexudong.utils.Test;

import java.util.HashMap;

public class TestHashMap {

public static void main(String[] args) {
		
		//统计一个字符串中每个字符出现的次数
		String str = "* Because TreeNodes are about twice the size of regular nodes, we\r\n" + 
				"     * use them only when bins contain enough nodes to warrant use\r\n" + 
				"     * (see TREEIFY_THRESHOLD). And when they become too small (due to\r\n" + 
				"     * removal or resizing) they are converted back to plain bins.  In\r\n" + 
				"     * usages with well-distributed user hashCodes, tree bins are\r\n" + 
				"     * rarely used.  Ideally, under random hashCodes, the frequency of\r\n" + 
				"     * nodes in bins follows a Poisson distribution\r\n" + 
				"     * (http://en.wikipedia.org/wiki/Poisson_distribution) with a\r\n" + 
				"     * parameter of about 0.5 on average for the default resizing\r\n" + 
				"     * threshold of 0.75, although with a large variance because of\r\n" + 
				"     * resizing granularity. Ignoring variance, the expected\r\n" + 
				"     * occurrences of list size k are (exp(-0.5) * pow(0.5, k) /\r\n" + 
				"     * factorial(k)). The first values are";
		//1.字符串转数组
		char [] arr = str.toCharArray();
		//2.创建map
		HashMap<Character,Integer> hm = new HashMap<>();
		//3.遍历数组key-value
		for (char c : arr) {
			//4.每取出一个元素，判断key是否存在
			if(!hm.containsKey(c)){
				//5.若不存在，存入key，value=1
				hm.put(c, 1);
			}else{
				//6.若存在，value+1
				hm.put(c, hm.get(c)+1);
			}
		}
		System.out.println(hm);
	}
}
