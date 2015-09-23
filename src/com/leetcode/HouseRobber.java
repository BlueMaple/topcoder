package com.leetcode;

public class HouseRobber {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int length = nums.length;
        int[] res = new int[length];
        res[0] = nums[0];
        
        for(int i = 1 ; i < length ; i++){
        	if(i == 1)
        		res[i] = Math.max(nums[0], nums[1]);
        	else
        		res[i] = Math.max(res[i-1], res[i-2]+nums[i]);
        }
        
        return res[length-1];
    }
}
