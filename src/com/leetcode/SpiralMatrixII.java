package com.leetcode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int k = 1, i = 0;
		while (k <= n * n) {
			int j = i;
			// four steps
			while (j < n - i)
				// 1. horizonal, left to right
				res[i][j++] = k++;
			j = i + 1;
			while (j < n - i)
				// 2. vertical, top to bottom
				res[j++][n - i - 1] = k++;
			j = n - i - 2;
			while (j > i)
				// 3. horizonal, right to left
				res[n - i - 1][j--] = k++;
			j = n - i - 1;
			while (j > i)
				// 4. vertical, bottom to top
				res[j--][i] = k++;
			i++; // next loop
		}
		return res;
	}
}
