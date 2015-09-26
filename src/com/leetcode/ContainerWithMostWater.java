package com.leetcode;
/**
 * while里面的if可以优化：一直选择到合适的下标
 * @author maple
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    	int r = height.length-1;
    	int l = 0;
    	int maxArea = 0;
    	while(l < r){
    		maxArea = Math.max(maxArea, (r-l)*(Math.min(height[l], height[r])));
    		if(height[l] < height[r]){
    			l++;
    		}
    		else{
    			r--;
    		}
    	}
    	return maxArea;
    }
}
