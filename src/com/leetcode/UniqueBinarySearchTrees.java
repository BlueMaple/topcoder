package com.leetcode;

/**
 * Catalan number!!!
 * Its application: http://blog.csdn.net/luxiaoxun/article/details/8034950
 * @author maple
 *
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] res = new int[n+1];
		
		res[0] = 1;
		res[1] = 1;
		if(n < 2){
			return res[n];
		}
		
		for(int i = 2 ; i <= n ; i++){
			for(int k = 1 ; k <= i ;k++)
				res[i] += res[k-1]*res[i-k];
		}
		return res[n];
	}
}
