package com.leetcode;

//The array is not empty and always exists majority element.
public class MajorityElement {
	public int majorityElement(int[] nums){
		int length = nums.length;
		if(length == 1)
			return nums[0];
		quickSort(nums , 0 , length-1);
		
		int index = length/2;
		if(index > 0 && index < length){
			return nums[index];
		}
		return -1;
	}
	
	//moore voting algorithm to calculate Majority!!!
	public int moore_voting(int[] nums){
		int major = 0;
		int counts = 0;
		int n = nums.length;
		
		for(int i = 0 ; i < n ; i++){
			if(counts == 0){
				major = nums[i];
				counts = 1;
			}else{
				counts += (nums[i] == major)?1:-1;
			}
		}
		return major;
	}

	private void quickSort(int[] s , int l , int r){
		if(l < r){
			int i = l, j = r, x = s[l];
			while(i < j){
				while(i < j && s[j] > x)
					j--;
				if(i < j)
					s[i++] = s[j];
				while(i < j && s[i] < x)
					i++;
				if(i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quickSort(s, l, i-1);
			quickSort(s, i+1, r);
		}
	}

}
