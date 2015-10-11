package com.leetcode;

/**
 * Is it possible that the nums is not rotated?
 * 
 * @author maple
 * 
 */
public class SearchInRotatedSortedArray {
	public int search_better(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[right])
				left = mid + 1;
			else
				right = mid;
		}
		int rot = left;
		left = 0;
		right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int realMid = (mid + rot) % nums.length;
			if (nums[realMid] == target)
				return realMid;
			if (nums[realMid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}

	public int search(int[] nums, int target) {
		int len = nums.length;
		if (nums[0] > nums[len - 1]) {
			int rotated = findR(0, len - 1, nums);
			if (nums[0] <= target) {
				return findT(0, rotated, nums, target);
			} else {
				return findT(rotated + 1, len - 1, nums, target);
			}
		} else {
			return findT(0, len - 1, nums, target);
		}
	}

	private int findT(int left, int right, int[] nums, int target) {
		if (left < 0 || right > nums.length - 1 || right < left)
			return -1;
		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (nums[mid] < target) {
			return findT(mid + 1, right, nums, target);
		}
		if (nums[mid] > target) {
			return findT(left, mid - 1, nums, target);
		}

		return -1;
	}

	private int findR(int left, int right, int[] nums) {
		int mid = (left + right) / 2;
		if (nums[mid] > nums[mid + 1])
			return mid;
		else {
			if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
				return findR(left, mid - 1, nums);
			} else {
				return findR(mid + 1, right, nums);
			}
		}
	}
}
