package com.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int result = nums[0]+nums[1]+nums[2];
		String temp = "ss";
		temp.charAt(3);

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int front = i + 1;
			int back = nums.length - 1;

			while (front < back) {
				int sum = nums[i] + nums[front] + nums[back];
				int current = target - sum;
				int previous = target - result;
				if (current == 0) {
					return sum;
				}
				if (Math.abs(current) < Math.abs(previous)) {
					result = sum;
				}
				if (current < 0)
					back--;
				if (current >= 0)
					front++;
			}
		}
		return result;
	}

}
