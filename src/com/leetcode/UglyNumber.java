package com.leetcode;

public class UglyNumber {
	public boolean isUgly(int num) {
		int[] target = new int[] { 2, 3, 5 };
		for (int index = 0; index < target.length && num > 0; index++) {
			int i = target[index];
			while (num % i == 0) {
				num /= num / i;
			}
		}

		return num == 1;
	}
}
