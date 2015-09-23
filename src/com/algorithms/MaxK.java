package com.algorithms;

public class MaxK {
	public int getMaxK(int[] s , int k){
		int length = s.length;
		
		return findK(s, 0, length-1, k);
	}

	private int findK(int[] s, int l, int r, int k) {
		if(l >= r)
			return s[l];
		int i = l;
		int j = r;
		int x = s[i];
		
		while(i < j){
			while(i < j && s[j] < x){
				j--;
			}
			if(i < j)
				s[i++] = s[j];
			while(i < j && s[i] > x)
				i++;
			if(i < j)
				s[j--] = s[i];
		}
		
		s[i] = x;
		if(i-l+1 == k)
			return x;
		else if(i-l+1 > k)
			return findK(s, l, i, k);
		else
			return findK(s, i+1, r, k-(i-l+1));
	}
}
