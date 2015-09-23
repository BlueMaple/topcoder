package com.leetcode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[] paths = new int[m];
		if (m == 0 && n == 0)
			return 0;
		if (m == 0 || n == 0)
			return 1;

		for (int i = 0; i < m; i++)
			paths[i] = 1;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j < m; j++) {
				paths[j] = paths[j - 1] + paths[j];
			}
		}

		return paths[m - 1];
	}

	//Total permutations = (m+n)! / (m! * n!)
	public int uniquePaths_better(int m, int n) {
		double value = 1;
		for (int i = 1; i <= n - 1; i++) {
			value *= ((double) (m + i - 1) / (double) i);
		}
		return (int) Math.round(value);
	}
}
