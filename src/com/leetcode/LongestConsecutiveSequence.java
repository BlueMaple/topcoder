package com.leetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>();
		for (int n : nums) {
			if (!factors.containsKey(n)) {
				int left = factors.containsKey(n - 1) ? factors.get(n - 1) : 0;
				int right = factors.containsKey(n + 1) ? factors.get(n + 1) : 0;

				int sum = left + right + 1;
				factors.put(n, sum);
				//keep track of the max length
				res = Math.max(res, sum);

				//extend the boundary value
				factors.put(n - left, sum);
				factors.put(n + right, sum);
			}
		}
		return res;
	}
}
