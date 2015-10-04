package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		res.add(temp);
		
		for(int s : nums){
		    int currSize = res.size();
			for(int i = 0 ; i < currSize ; i++){
			    List<Integer> pre = res.get(i);
				List<Integer> curr = new ArrayList<Integer>(pre);
				curr.add(s);
				res.add(curr);
			}
		}
		return res;
	}
}
