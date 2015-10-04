package com.leetcode;
/**
 * 1.从数组的后向前，找到一个最大极值点
 * 2.将极值点左边的数A和极值点右边最后一个大于A的数交换值
 * 3.将极值点右边所有的数重新排列
 * @author maple
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1)
        	return;
        if(len == 2 || nums[len-1] > nums[len-2]){
        	exchange(len-1, len-2, nums);
        }else{
        	int peak = 0;
        	for(int i = len-2 ; i> 0 ; i--){
        		if(nums[i] >= nums[i+1] && nums[i] > nums[i-1]){
        		    peak = i;
        		    break;
        		}
        	}
        	if(peak != 0){
        	    int target = nums[peak-1];
        	    int changeIndex = 0;
        	    for(int i = peak ; i < len ; i++){
        	        if(nums[i] > target){
        	            changeIndex = i;
        	        }else{
        	            break;
        	        }
        	    }
        	    exchange(peak-1, changeIndex, nums);
        	}
        	int left = peak;
        	int right = len-1;
        	while(left < right){
        		exchange(left,right,nums);
        		left++;
        		right--;
        	}
        }
    }

	private void exchange(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
