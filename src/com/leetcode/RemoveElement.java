package com.leetcode;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int length = nums.length;
		int start = 0;
		int end = length - 1;
		if (length == 1) {
			return nums[0] == val ? 0 : 1;
		}

		while (start < end) {
			if (nums[start] == val && nums[end] != val) {
				nums[start] = nums[end];
				nums[end] = val;
			} else {
				while (start < length && nums[start] != val) {
					start++;
				}
				while (end >= 0 && nums[end] == val) {
					end--;
				}
			}
		}
		return start;
	}
}
