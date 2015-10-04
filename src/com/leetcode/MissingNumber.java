package com.leetcode;
/**
 * This nums are not sorted!!
 * XOR and sum can solve this problem
 * @author maple
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
        	res ^= i;
        	res ^= nums[i];
        }
        
        return res;
    }
}
