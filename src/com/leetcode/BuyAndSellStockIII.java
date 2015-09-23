package com.leetcode;

public class BuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
		int release1 = 0, release2 = 0;
		for (int i : prices) { // Assume we only have 0 money at first
			// The maximum if we've just sold 2nd stock so far.
			release2 = Math.max(release2, hold2 + i);
			// The maximum if we've just buy 2nd stock so far.
			hold2 = Math.max(hold2, release1 - i);
			// The maximum if we've just sold 1nd stock so far.
			release1 = Math.max(release1, hold1 + i);
			// The maximum if we've just buy 1st stock so far.
			hold1 = Math.max(hold1, -i);

			System.out.println(release2 + "*" + hold2 + "*" + release1 + "*"
					+ hold1);
		}
		return release2; // /Since release1 is initiated as 0, so release2 will
							// always higher than release1.
	}

	public int maxProfit_second(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int lenght = prices.length;

		int[] leftProfit = new int[lenght];
		int leftMaxProfit = 0;
		int leftMin = prices[0];
		for (int i = 0; i < lenght; i++) {
			if (prices[i] < leftMin)
				leftMin = prices[i];
			if (prices[i] - leftMin > leftMaxProfit)
				leftMaxProfit = prices[i] - leftMin;
			leftProfit[i] = leftMaxProfit;
		}

		int maxProfit = 0;
		int rightMaxProfit = 0;
		int rightMax = prices[lenght - 1];
		for (int i = lenght - 1; i >= 0; i--) {
			if (prices[i] > rightMax)
				rightMax = prices[i];
			if (rightMax - prices[i] > rightMaxProfit)
				rightMaxProfit = rightMax - prices[i];
			int currentProfit = rightMaxProfit
					+ (i > 0 ? leftProfit[i - 1] : 0);
			if (currentProfit > maxProfit) {
				maxProfit = currentProfit;
			}
		}

		return maxProfit;
	}

}
