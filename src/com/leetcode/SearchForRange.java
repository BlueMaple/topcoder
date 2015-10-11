package com.leetcode;

public class SearchForRange {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		if(nums == null || nums.length <= 0)
			return res;
		int len = nums.length;
		res[0] = findBorder(0, len-1, nums, target, -1);
		res[1] = findBorder(0, len-1, nums, target, 1);
		return res;
	}

	private int findBorder(int left, int right, int[] nums, int target, int border) {
		int mid = (left+right)/2;
		if(left < 0 || right > nums.length-1 || right < left)
			return -1;
		if(nums[mid] > target){
			return findBorder(left, mid-1, nums, target, border);
		}
		if(nums[mid] < target){
			return findBorder(mid+1, right, nums, target, border);
		}
		if(nums[mid] == target){
			if(mid+border < 0 || mid+border > nums.length-1 || nums[mid+border] != target)
				return mid;
			else{
				if(border > 0){
					return findBorder(mid+1, right, nums, target, border);
				}else{
					return findBorder(left, mid-1, nums, target, border);
				}
			}
		}
		return -1;
	}
}
