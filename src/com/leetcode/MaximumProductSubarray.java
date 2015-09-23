package com.leetcode;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int length = nums.length;
		int maxpre = nums[0];
		int minpre = nums[0];
		int maxsofar = nums[0];

		int max, min;
		for (int i = 1; i < length; i++) {
			max = Math.max(Math.max(maxpre * nums[i], minpre * nums[i]),
					nums[i]);
			min = Math.min(Math.min(maxpre * nums[i], minpre * nums[i]),
					nums[i]);

			maxsofar = Math.max(maxsofar, max);

			maxpre = max;
			minpre = min;
		}
		return maxsofar;
	}
}
