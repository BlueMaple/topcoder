package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n > k*9 || n < k)
			return res;
		
		List<Integer> curr = new ArrayList<Integer>();
		for(int i = 0 ; i < k ; i++)
			curr.add(1);
		res.add(curr);
		for(int i = k+1 ; i <= n ; i++){
			add(i, res);
		}
		
		return res;
	}

	private void add(int target, List<List<Integer>> res) {
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		List<Integer> pre = null;
		for(List<Integer> list : res){
			
		}
	}
}
