package com.leetcode;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null)
			return 0;
		int row = matrix.length;
		if (row == 0)
			return 0;
		int column = matrix[0].length;
		if (row == 1 || column == 1) {
			return hasOne(matrix, row, column);
		}

		int[][] res = new int[row - 1][column - 1];
		int maxValue = hasOne(matrix, row, column);
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				res[i - 1][j - 1] = 
						(matrix[i - 1][j - 1] == '1' &&
						 matrix[i][j - 1] == '1' && 
						 matrix[i - 1][j] == '1' &&
						 matrix[i][j] == '1') ? 1 : 0;
				if (res[i - 1][j - 1] == 1) {
					if (i - 1 > 0 && j - 1 > 0) {
						int min = Math.min(
								Math.min(res[i - 2][j - 2], res[i - 1][j - 2]),
								res[i - 2][j - 1]);
						res[i - 1][j - 1] = min + 1;
					}
					maxValue = Math.max(maxValue, res[i - 1][j - 1] + 1);
				}

			}
		}

		return maxValue * maxValue;
	}

	private int hasOne(char[][] matrix, int row, int column) {
		int res = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == '1') {
					res = 1;
					break;
				}
			}
		}

		return res;
	}
}
