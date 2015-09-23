package com.algorithms;

public class HeapSort {
	public void heapSort(int[] s){
		sort(s, s.length);
	}

	private void sort(int[] s, int size) {
		for(int i = size ; i > 0 ; i--){
			findMaxInHeap(s, i);
			
			int temp = s[0];
			s[0] = s[i-1];
			s[i-1] = temp;
		}
	}

	private void findMaxInHeap(int[] s, int size) {
		for(int i = size-1 ; i > 0 ; i--){
			int child = i;
			int parent = i/2;
			
			if(child%2 == 0 && s[i-1] > s[i])
				child--;
			
			if(s[child] > s[parent]){
				int temp = s[child];
				s[child] = s[parent];
				s[parent] = temp;
			}
		}
		
	}
}
