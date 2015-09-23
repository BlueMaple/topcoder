package com.leetcode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int row = grid.length;
		int column = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (i == 0 && j == 0)
					continue;
				else if (i == 0) {
					grid[i][j] = grid[i][j - 1] + grid[i][j];
				} else if (j == 0) {
					grid[i][j] = grid[i - 1][j] + grid[i][j];
				} else {
					grid[i][j] = Math.min(
							grid[i][j - 1] + grid[i][j],
							grid[i - 1][j] + grid[i][j]);
				}
			}
		}

		return grid[row - 1][column - 1];
	}
}
