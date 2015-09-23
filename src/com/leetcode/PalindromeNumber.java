package com.leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		return judge(x, x, getBits(x));
	}
	
	private int getBits(int x){
		x = x/10;
		if(x > 0){
			return getBits(x)+1;
		}
		else{
			return 0;
		}
	}

	private boolean judge(int x, int y, int bits) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		if (judge(x / 10, y, bits-1) && (x % 10 == (int)(y/Math.pow(10,bits)) % 10)) {
			y = y / 10;
			return true;
		} else {
			return false;
		}
	}
}
