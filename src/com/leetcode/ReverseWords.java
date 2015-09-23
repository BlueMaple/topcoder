package com.leetcode;

public class ReverseWords {
	public String reverseWords(String s){
		int leftIndex = -1;
		int rightIndex = -1;
		
		int charSize = s.length();
		for(int i = 0 ; i < charSize ; i++){
			char c = s.charAt(i);
			if(c == ' ' && leftIndex == -1){
				continue;
			}
			else if(c == ' ' && leftIndex != -1){
				s = reverse(s, leftIndex, rightIndex);
				leftIndex = -1;
				rightIndex = -1;
				continue;
			}
			else if(c != ' ' && leftIndex == -1){
				leftIndex = i;
				rightIndex = i;
			}
			else if(c != ' ' && leftIndex != -1){
				rightIndex = i;
				if(i == charSize-1)
					s = reverse(s, leftIndex, rightIndex);
			}
		}
		
		s = reverse(s, 0 , charSize-1);
		return s;
	}

	private String reverse(String s, int l, int r) {
		String rev = "";
		for(int i = r ; i >= l ; i--){
			char temp = s.charAt(i);
			rev += temp;
		}
		
		s = s.replaceFirst(s.substring(l, r+1), rev);
		return s;
	}

}
