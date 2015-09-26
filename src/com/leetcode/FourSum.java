package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 不好。。。。回忆3Sum的做法，应该同样是3Sum，但是效率却要高一点。
 * 理论上还有n*n*logN的做法，没有研究。。。
 * @author maple
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	int length = nums.length;
    	for(int i = 0 ; i <= length-4 ; i++){
    		for(int j = i+1 ; j <= length-3 ; j++){
    			findOtherTwo(i, j, nums, target, res);
    		}
    	}
        return res;
    }

	private void findOtherTwo(int i, int j, int[] nums, int target,
			List<List<Integer>> res) {
		int twoSum = target - (nums[i]+nums[j]);
		Set<Integer> set = new HashSet<Integer>();
		for(int index = j+1 ; index < nums.length ; index++){
			if(set.contains(nums[index])){
				List<Integer> solution = new ArrayList<Integer>();
				solution.add(nums[i]);
				solution.add(nums[j]);
				solution.add(twoSum-nums[index]);
				solution.add(nums[index]);
				res.add(solution);
				
				set.remove(nums[index]);
			}else{
				set.add(twoSum - nums[index]);
			}
		}
	}
}
