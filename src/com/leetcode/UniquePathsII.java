package com.leetcode;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int defValue = 1;
		for(int i = m-2 ; i >= 0 ; i--){
			if(obstacleGrid[i][n-1] == 1)
				defValue = 0;
			obstacleGrid[i][n-1] = defValue;
		}
		defValue = 1;
		for(int i = n-2 ; i >= 0 ; i--){
			if(obstacleGrid[m-1][i] == 1)
				defValue = 0;
			obstacleGrid[m-1][i] = defValue;
		}
		
		for(int i = m-2 ; i >= 0 ; i--){
			for(int j = n-2 ; j>=0 ; j--){
				if(obstacleGrid[i][j] == 1){
					obstacleGrid[i][j] = 0;
				}else{
					obstacleGrid[i][j] = obstacleGrid[i+1][j]+obstacleGrid[i][j+1];
				}
			}
		}
		return obstacleGrid[0][0];
	}
	
	public int uniquePathsWithObstacles_better(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}
}
