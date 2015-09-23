package com.leetcode;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		int len = s.length();
		boolean[] breakable = new boolean[len+1];
		breakable[0] = true;
		
		for(int i = 1 ; i <= len ; i++){
			for(int j = 0 ; j < i ; j++){
				if(breakable[j] && wordDict.contains(s.substring(j, i)))
					breakable[i] = true;
			}
		}
		return breakable[len];
	}
}
