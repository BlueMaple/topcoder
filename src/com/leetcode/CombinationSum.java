package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * HAHAHA
 * @author maple
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for(int i = 0 ; i < candidates.length ; i++){
			List<Integer> curr = new ArrayList<Integer>();
			curr.add(candidates[i]);
			add(i, candidates, candidates[i], target, curr, res);
		}

		return res;
	}

	private void add(int index, int[] candidates, int currSum, int target,
			List<Integer> comb, List<List<Integer>> res) {
		if(index >= candidates.length || currSum > target){
			return;
		}
		if(currSum < target){
			List<Integer> curr = new ArrayList<Integer>(comb);
			curr.add(candidates[index]);
			add(index, candidates, currSum+candidates[index], target, curr, res);
			add(index+1, candidates, currSum, target, comb, res);
		}else if(currSum == target){
			List<Integer> curr = new ArrayList<Integer>(comb);
			res.add(curr);
		}
	}
}
