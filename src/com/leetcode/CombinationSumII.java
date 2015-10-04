package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1])
				continue;
			List<Integer> curr = new ArrayList<Integer>();
			curr.add(candidates[i]);
			add(i + 1, candidates, candidates[i], target, curr, res);
		}
		return res;
	}

	//must first judge whether currSum == target
	private void add(int index, int[] candidates, int currSum, int target,
			List<Integer> value, List<List<Integer>> res) {
		if (currSum == target) {
			List<Integer> curr = new ArrayList<Integer>(value);
			res.add(curr);
			return;
		}
		if (index >= candidates.length || currSum > target)
			return;
		if (currSum < target) {
			List<Integer> curr = new ArrayList<Integer>(value);
			int count = 1;
			while (index + count < candidates.length
					&& candidates[index + count] == candidates[index]) {
				count++;
			}
			for(int i = 1 ; i <= count ; i++){
				curr.add(candidates[index]);
				add(index + count, candidates, currSum + i*candidates[index], target,
						curr, res);
			}
			
			add(index + count, candidates, currSum, target, value, res);
		}
	}
}
