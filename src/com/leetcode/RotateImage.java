package com.leetcode;

public class RotateImage {
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n > 1){
        	for(int i = 0 ; i < n ; i++){
        		for(int j = i+1 ; j < n ; j++){
        			exchange(i,j,j,i,matrix);
        		}
        	}
        	for(int column = 0 ; column < n/2 ; column++){
        		for(int i = 0 ; i < n ; i++){
        			exchange(i,column,i,n-1-column,matrix);
        		}
        	}
        }
    }

	private void exchange(int ox, int oy, int nx, int ny, int[][] matrix) {
		int temp = matrix[ox][oy];
		matrix[ox][oy] = matrix[nx][ny];
		matrix[nx][ny]= temp;
	}
}
