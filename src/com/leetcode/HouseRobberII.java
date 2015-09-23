package com.leetcode;

public class HouseRobberII {
	public int rob(int[] nums) {
		int length = nums.length;
		if(nums == null || nums.length == 0){
		    return 0;
		}
		if(nums.length == 1){
		    return nums[0];
		}

		return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length - 1));
	}

	private int rob(int[] nums, int start, int end) {
	    if(start == end){
	        return nums[start];
	    }
		int length = end-start+1;
		int[] res = new int[length];
		res[0] = nums[start];

		for (int i = 1; i < length; i++) {
			if (i == 1)
				res[i] = Math.max(nums[start+0], nums[start+1]);
			else
				res[i] = Math.max(res[i - 1], res[i - 2] + nums[start+i]);
		}

		return res[length - 1];
	}
}
