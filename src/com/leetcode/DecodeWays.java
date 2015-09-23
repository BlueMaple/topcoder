package com.leetcode;

public class DecodeWays {
	public int numDecodings(String s) {
		if(s == null || s.equals(""))
			return 0;
		
		int[] res = new int[s.length()+1];
		res[0] = 1;
		
		int index = 1;
		int pre = -1;
		while(index <= s.length()){
			int mod = s.charAt(s.length()-index)-'0';
			int temp = (mod == 0)?0:1;
			
			if(pre < 0){
				res[index] = temp;
			}
			else{
				int combination = mod*10+pre;
				if(combination>= 10 && combination<=26){
					res[index] = temp*res[index-1]+temp*res[index-2];
				}
				else{
					res[index] = temp*res[index-1];
				}
			}
			
			System.out.println(mod+"-"+pre+"-"+res[index]);
			pre = mod;
			index++;
		}
		
		return res[s.length()];
	}
}
