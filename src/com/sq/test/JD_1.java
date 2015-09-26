package com.sq.test;

public class JD_1 {
	public int find(int n, int m, int k, int[][] matrix) {
		int[] path = new int[m + n - 1];
		if(m+n-1 < k)
			return 0;

		path[0] = matrix[0][0];
		long[] res = new long[1];

		addStep(0, 0, 1, n, m, path, matrix, res, k);
		
		return ((int)(res[0]%(10000000007L)));
	}

	private void addStep(int i, int j, int index, int n, int m, int[] path, int[][] matrix,
			long[] res, int k) {
		if (i < n - 1) {
			path[index] = matrix[i+1][j];
			addStep(i+1,j,index+1,n,m,path,matrix,res,k);
		}
		if(j < m-1){
			path[index] = matrix[i][j+1];
			addStep(i,j+1,index+1,n,m,path,matrix,res,k);
		}
		if(i == n-1 && j == m-1){
			long value = calPaths(path, k);
			res[0] += value;
		}
	}

	private long calPaths(int[] path, int k) {
		int length = path.length;
		if(k == 1){
			return length;
		}
		
		return jc(length)/(jc(k)*jc(length-k));
	}
	
	private long jc(int x){
		long res = 1;
		for(int i = 1 ; i <= x ; i++)
			res *= i;
		
		return res;
	}
}
