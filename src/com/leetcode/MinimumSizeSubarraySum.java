package com.leetcode;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int first = 0, second = 0, minLength = Integer.MAX_VALUE, sum = 0;
		int length = nums.length;
		while(first < length){
			while(first < length && sum < s)
				sum += nums[first++];
			if(sum < s)
				break;
			while(second < first && sum >= s)
				sum -= nums[second++];
			
			minLength = Math.min(first-second+1, minLength);
		}
		
		return minLength==Integer.MAX_VALUE?0:minLength;
	}
}
