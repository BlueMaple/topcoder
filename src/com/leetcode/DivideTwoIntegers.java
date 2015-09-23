package com.leetcode;
/*
 * Take care of BOUNDARY value!!!!!
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int dnd , dor;
		boolean dndN = false, dorN = false;
		
		//several special condictions should be careful.
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		if(dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
		
		if(dividend > 0){
			dnd = -dividend;
			dndN = false;
		}
		else{
			dnd = dividend;
			dndN = true;
		}
		
		if(divisor > 0){
			dor = -divisor;
			dorN = false;
		}
		else{
			dor = divisor;
			dorN = true;
		}
		
		int ans = negativeDiv(dnd, dor);
		if(dndN != dorN)
			ans = -ans;
		return ans;
	}
	
	/**
	 * consider the case that dnd = Integer.MIN_VALUE, can't use "Positive"
	 * it is important to understand the calculation and association of >> and <<.
	 * Recursion, shifting and 2^x
	 * @param dnd
	 * @param dor
	 * @return Positive Result
	 */
	private int negativeDiv(int dnd , int dor){
		if(dnd == 0 || dnd > dor)
			return 0;
		int cof = 1;
		int prd = dor; // prd = cof*dor
		
		while((prd<<1) > dnd && prd > -1071741824){
			System.out.println(prd+"**"+cof+"**"+dnd+"**"+dor);
			cof = cof<<1;
			prd = prd<<1;
		}
		
		return cof + negativeDiv(dnd-prd , dor);
	}
		
}
