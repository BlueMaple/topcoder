package com.leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
    	digits[len-1] += 1;
    	
    	for(int i = len-1 ; i >= 1 ; i++){
    		if(digits[i] > 9){
    			digits[i] = digits[i]-10;
    			digits[i-1] += 1;
    		}
    	}
    	
    	if(digits[0] > 9){
    		digits[0] -= 10;
    		int[] res = new int[len+1];
    		res[0] = 1;
    		for(int i = 1 ; i < len+1 ; i++)
    			res[i] = digits[i-1];
    		return res;
    	}
    	else{
    		return digits;
    	}
    }
}
