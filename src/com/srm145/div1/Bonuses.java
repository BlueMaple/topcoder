package com.srm145.div1;

public class Bonuses {
	public int[] getDivision(int[] points){
		int[] temp = new int[points.length];
		boolean[] selected = new boolean[points.length];
		double sum = 0;
		for(int i = 0 ; i < points.length ; i++){
			temp[i] = points[i];
			sum += points[i];
			selected[i] = false;
		}
		mergeSort(temp , 0 , temp.length-1);
		
		int[] result = new int[points.length];
		int realSum = 0;
		for(int i = 0 ; i < points.length ; i++){
			result[i] = (int)((points[i]/sum)*100);
			realSum += result[i];
		}
		
		int K = 100-realSum;
		for(int index = 0 ; index < K ; index++){
			int max = temp[index];
			for(int i = 0 ; i < points.length ; i++){
				if(points[i] == max && !selected[i]){
					result[i]++;
					selected[i] = true;
					break;
				}
			}
		}
		
		return result;
	}

	private void mergeSort(int[] temp , int l, int r) {
		int middle = (l+r)/2;
		if(l < r){
			mergeSort(temp  , l , middle);
			mergeSort(temp , middle+1 , r);
			merge(temp , l , middle , r);
		}
	}

	private void merge(int[] temp,  int l, int m, int r) {
		int nl = m-l+1;
		int nr = r-m;
		int[] L = new int[nl];
		int[] R = new int[nr];
		for(int i = 0 ; i < nl ; i++)
			L[i] = temp[l+i];
		for(int i = 0 ; i < nr ; i++)
			R[i] = temp[m+1+i];
		
		int p = 0 , q = 0;
		for(int index = l ; index <= r ; index++){
			if(p < nl && q < nr)
				temp[index] = L[p]>R[q]?L[p++]:R[q++];
			else{
				if(p < nl)
					temp[index] = L[p++];
				else
					temp[index] = R[q++];
			}
		}
	}

}
