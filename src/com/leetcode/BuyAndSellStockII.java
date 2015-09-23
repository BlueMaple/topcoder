package com.leetcode;

public class BuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int ret = 0;
		for (int p = 1; p < prices.length; ++p)
			ret += Math.max(prices[p] - prices[p - 1], 0);
		return ret;
	}
}
