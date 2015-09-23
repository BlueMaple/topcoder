package com.leetcode;

/**
 * '*' can match empty sequence
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*')
				count++;
		}
		//thie is no * but m != n
		if (count == 0 && m != n)
			return false;
		//n is bigger than m not counting *
		else if (n - count > m)
			return false;

		boolean[] match = new boolean[m + 1];
		match[0] = true;

		for (int i = 0; i < n; i++) {
			//当检测到*时，需要修改所有的标示位，每个位都需要
			//参考前一个位的值进行比对。
			//由于*可以代表任意的字符串，所以如果*之前的位都匹配，
			//那么之后的也都修改成匹配的；否则都不匹配
			if (p.charAt(i) == '*') {
				for (int j = 0; j < m; j++) {
					match[j + 1] = match[j] || match[j + 1];
				}
			} else {
				//非*字符则从后向前和s匹配，每次匹配都需要判断字符是否是?
				//状态转换方程：dp(i+1) = dp(i)&&(p[i+1] equals s[i+1])
				for (int j = m - 1; j >= 0; j--) {
					match[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s
							.charAt(j)) && match[j];
				}
				match[0] = false;
			}
		}
		return match[m];
	}
}
