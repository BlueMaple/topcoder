package com.leetcode;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		if(nums[nums.length-1] > nums[nums.length-2])
			return nums.length-1;
		if(nums[0] > nums[1])
			return 0;

		return findPeak(0, nums.length - 1, nums);
	}

	private int findPeak(int leftIndex, int rightIndex, int[] nums) {
		int middleIndex = (leftIndex+rightIndex)/2;
		System.out.println("middle: "+nums[middleIndex]);
		
		int left = ((middleIndex-1) >= 0)?nums[middleIndex-1]:Integer.MIN_VALUE;
		int right = ((middleIndex+1) < nums.length)?nums[middleIndex+1]:Integer.MIN_VALUE;
		
		if(left < nums[middleIndex] && nums[middleIndex] > right){
			return middleIndex;
		}
		
		if(left < nums[middleIndex] && nums[middleIndex] < right){
			return findPeak(middleIndex, rightIndex , nums);
		}
		
		if(left > nums[middleIndex] && nums[middleIndex] > right){
			return findPeak(leftIndex, middleIndex , nums);
		}
		
		return findPeak(middleIndex, rightIndex , nums);
	}
}
