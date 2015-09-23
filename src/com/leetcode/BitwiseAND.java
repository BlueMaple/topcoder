package com.leetcode;

public class BitwiseAND {
	public int rangeBitwiseAnd(int m, int n) {
		if ((double) m * 2 <= n)
			return 0;
		if (m == n)
			return m;

		int power = 0;
		double value = Math.pow(2, power);
		while (value <= m && value < n) {
			value = (int) Math.pow(2, ++power);
		}

		int result = 0;
		for (int i = power; i >= 0; i--) {
			System.out.println(m + "-" + n + "-" + i);
			double v = Math.pow(2, i);
			if (m == 0 || n == 0)
				break;
			if (m >= v && n > v) {
				result += v;
				m = m - (int) v;
				n = n - (int) v;
			} else if (m < v && v <= n) {
				break;
			} else if (n < v) {
				continue;
			}
		}

		return result;
	}

	public int rangeBitwiseAnd_better(int m, int n) {
		if (m == 0) {
			return 0;
		}
		int moveFactor = 1;
		while (m != n) {
			System.out.println(m + "-" + n + "-" + moveFactor);
			m >>= 1;
			n >>= 1;
			moveFactor <<= 1;
		}
		return m * moveFactor;
	}
}
