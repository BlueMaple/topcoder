package com.algorithms;

public class LCS {
	public String longestCommonSubsequence(char[] x, char[] y) {
		int[][] c = new int[x.length + 1][y.length + 1];
		for (int i = 0; i < x.length + 1; i++)
			c[i][0] = 0;
		for (int j = 0; j < y.length + 1; j++)
			c[0][j] = 0;

		for (int i = 1; i < x.length + 1; i++) {
			for (int j = 1; j < y.length + 1; j++) {
				if (x[i-1] == y[j-1]) {
					c[i][j] = c[i-1][j-1] + 1;
				} else{
					if(c[i-1][j] >= c[i][j-1]){
						c[i][j] = c[i-1][j];
					}
					else
						c[i][j] = c[i][j-1];
				}
			}
		}
		getSubsequence(c,x,new StringBuilder(),x.length,y.length);
		return null;
	}

	public void getSubsequence(int[][] c, char[] x, StringBuilder s,
			int xLength, int yLength) {
		if (xLength == 0 || yLength == 0) {
			return;
		}
		if (c[xLength][yLength] == (c[xLength - 1][yLength - 1] + 1)) {
			getSubsequence(c,x,s,xLength-1,yLength-1);
			System.out.println(x[xLength-1]);
		}
		else if(c[xLength][yLength] == c[xLength-1][yLength]){
			getSubsequence(c,x,s,xLength-1,yLength);
		}
		else{
			getSubsequence(c,x,s,xLength,yLength-1);
		}
	}
}
