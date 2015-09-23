package com.leetcode;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int targetRow = 0;
		for(int i = 0 ; i < matrix.length ; i++){
			if(matrix[i][0] == target)
				return true;
			if(matrix[i][0] > target){
				targetRow = i-1;
				break;
			}
			if(i == matrix.length-1){
				targetRow = i;
			}
		}
		
		if(targetRow < 0)
			return false;
		
		int column = matrix[targetRow].length;
		System.out.println("row: "+targetRow);
		return findTarget(target, matrix, targetRow, 0, column);
	}

	private boolean findTarget(int target, int[][] matrix, int targetRow, int left, int right) {
		int mid = (left+right)/2;
		System.out.println("mide: "+matrix[targetRow][mid]);
		if(matrix[targetRow][mid] == target)
			return true;
		if(mid == left || mid == right-1)
			return false;
		if(matrix[targetRow][mid] < target)
			return findTarget(target, matrix, targetRow, mid+1, right);
		if(matrix[targetRow][mid] > target)
			return findTarget(target, matrix, targetRow, left, mid);
		
		return false;
	}
}
