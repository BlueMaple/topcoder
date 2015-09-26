package com.leetcode;

public class SortColors {
	public void sortColors(int[] nums){
		int zero = 0;
		int two = nums.length-1;
		
		int k = 0;
		while(k <= two){//HERE equals is very important(e.g., input is [1,0])
			if(nums[k] == 0){
				swap(k++,zero++,nums);//k also need ++ because front 
									  //values are already judged
			}
			else if(nums[k] == 2){
				swap(k,two--,nums);//k need not ++ HERE
			}
			else{
				k++;
			}
		}
	}

	private void swap(int s1, int s2, int[] nums) {
		int temp = nums[s1];
		nums[s1] = nums[s2];
		nums[s2] = temp;
	}
}
