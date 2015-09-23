package com.leetcode;
/**
 * My runtime beats 100% of java submission
 * @author shanqi.sq
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int length = nums.length;
		if (length == 1)
			return true;

		int accessable = 0;
		for(int i = 0 ;i < length-1 ; i++){
			accessable = Math.max(i+nums[i], accessable);
			if(accessable <= i)
				return false;
		}
		
		return true;

	}
}
