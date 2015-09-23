package com.leetcode;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() <= 0)
			return 0;
		int level = triangle.size();
		int[] pre = new int[triangle.get(triangle.size()-1).size()];
		for(int i = level-1 ; i >= 1 ; i--){
			List<Integer> current = triangle.get(i);
			int currentLength = current.size();
			for(int j = 0 ; j < currentLength-1 ; j++){
				//triangle.get(i).set(j, sum);
				pre[j] = Math.min(
						current.get(j)+pre[j], 
						current.get(j+1)+pre[j+1]);
			}
		}
		return pre[0]+triangle.get(0).get(0); 
	}
}
