package com.leetcode;

/**
 * Thanks for sharing. I think the key here is as you mentioned,
 * "including nums with same value.". factor2 and factor3 may both have value =
 * 6, but we bump both "6"s together, thus the duplicated 6 won't cause any
 * problem. I initially put it as "else if (factor3==min)", that fell to the
 * trap.
 * 
 * @author maple 
 */
public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int[] res = new int[n];
		int index2 = 0, index3 = 0, index5 = 0;
		int factor2 = 2, factor3 = 3, factor5 = 5;
		res[0] = 1;

		// 三个指针不断的前进
		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(factor2, factor3), factor5);
			res[i] = min;
			if (factor2 == min)
				factor2 = 2 * res[++index2];
			if (factor3 == min)
				factor3 = 3 * res[++index3];
			if (factor5 == min)
				factor5 = 5 * res[++index5];
		}

		return res[n - 1];
	}
}
