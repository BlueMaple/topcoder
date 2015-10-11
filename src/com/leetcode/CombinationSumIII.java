package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		dfs(res, tmp, k, n, 1);
		return res;
	}

	public void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n,
			int pos) {
		if (k == 0) {
			if (n == 0)
				res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = pos; i <= n / k && i < 10; i++) {
			tmp.add(i);
			dfs(res, tmp, k - 1, n - i, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
