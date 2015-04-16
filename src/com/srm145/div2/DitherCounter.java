package com.srm145.div2;

public class DitherCounter {
	public int count(String dithered, String[] screen){
		int[] array = new int[26];
		for(int i = 0 ; i < screen.length ; i++){
			String s = screen[i];
			for(int j = 0 ; j < s.length() ; j++){
				char c = s.charAt(j);
				array[c-65]++;
			}
		}
		
		int sum = 0;
		for(int k = 0 ; k < dithered.length() ; k++){
			sum += array[dithered.charAt(k)-65];
		}
		
		return sum;
	}

}
