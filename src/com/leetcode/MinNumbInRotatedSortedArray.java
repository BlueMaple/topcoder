package com.leetcode;

public class MinNumbInRotatedSortedArray {
	public int findMin(int[] nums){
		int length = nums.length;
		if(length == 1)
			return nums[0];
		else{
			int direction = (nums[0] > nums[length-1])?1:-1;
			return findMinPart(nums, 0, length-1, direction);
		}
	}

	private int findMinPart(int[] nums, int left, int right, int dir){		
		int k = (left+right)/2;
		if(k == left || k == right)
			return (nums[left] < nums[right])?nums[left]:nums[right];
		if(dir > 0){
			if(nums[k] > nums[left]){
				return findMinPart(nums, k, right, dir);
			}
			else{
				return findMinPart(nums, left, k, dir);
			}
		}
		else{
			if(nums[k] > nums[left]){
				return findMinPart(nums, left, k, dir);
			}
			else{
				return findMinPart(nums, k, right, dir);
			}
		}
	}
}
