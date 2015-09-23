package com.leetcode;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}

		int length = s.length();
		int front = 0;
		int back = length - 1;

		while (front < back) {
			while (front < back && !isAlpha(s.charAt(front))) {
				front++;
			}
			while (front < back && !isAlpha(s.charAt(back))) {
				back--;
			}
			System.out.println(s.charAt(front) + "*" + s.charAt(back));
			if (front < back) {
				if (sameAlpha(s.charAt(front), s.charAt(back))) {
					front++;
					back--;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isAlpha(char a) {
		return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')
				|| (a >= '0' && a <= '9');
	}

	private boolean sameAlpha(char a, char b) {
		if (a == b) {
			return true;
		}
		if (a - b == 'a' - 'A' || a - b == 'A' - 'a') {
			return true;
		}
		return false;
	}

}
