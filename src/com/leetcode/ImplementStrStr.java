package com.leetcode;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		int hLength = haystack.length();
		int nLength = needle.length();
		if (nLength == 0)
			return 0;

		if (nLength > hLength)
			return -1;

		int hIndex = -1;
		int nIndex = 0;
		for (int i = 0; i < hLength; i++) {
			if (haystack.charAt(i) == needle.charAt(nIndex)) {
				nIndex++;
				if (hIndex == -1) {
					hIndex = i;
				}
				if (nIndex == nLength)
					break;
			} else {
				if (hIndex != -1) {
					i = hIndex;
				}
				hIndex = -1;
				nIndex = 0;
			}
		}
		if (nIndex != nLength) {
			return -1;
		}
		return hIndex;
	}
}
