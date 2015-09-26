package com.leetcode;

public class MergeSortedArray {
	public void merge(int[] A, int m, int[] B, int n) {
		int length = m+n;
		int indexA = m-1;
		int indexB = n-1;

		for(int i = length-1 ; i>= 0 ; i--){
			
			if(indexA >= 0 && indexB >= 0){
				A[i] = (A[indexA] > B[indexB])?A[indexA--]:B[indexB--];
			}
			else{
				if(indexA >= 0)
					A[i] = A[indexA--];
				if(indexB >= 0)
					A[i] = B[indexB--];
			}
		}
	}
}
