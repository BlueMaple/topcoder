package com.leetcode;

/**
 * classic reverse:
 * 
 * rotate(nums, 0, length-k-1)
 * rotate(nums, length-1, length)
 * rotate(nums, 0 , length)
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		if (length == 0)
			return;
		k = k % length;
		if (k == 0)
			return;
		int common = maxDivisor(length, k);
		for (int i = 0; i < common; i++)
			move(nums, k, i, length / common);
	}

	private void move(int[] nums, int k, int index, int targetLength) {
		int numb = 0;
		int current = nums[index];
		while (numb < targetLength) {
			int targetIndex = (index + k) % nums.length;
			int target = nums[targetIndex];
			nums[targetIndex] = current;
			current = target;
			index = targetIndex;
			numb++;
		}
	}

	private int maxDivisor(int n, int m) {
		while (n % m != 0) {
			int temp = n % m;
			n = m;
			m = temp;
		}
		return m;
	}
}
