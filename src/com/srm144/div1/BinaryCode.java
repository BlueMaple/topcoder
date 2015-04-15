package com.srm144.div1;

public class BinaryCode {
	public String[] decode(String code){
		String[] result = new String[2];		
		result[0] = initFrom(0 , code);
		result[1] = initFrom(1 , code);
		return result;
	}
	
	private String initFrom(int current , String code){
		String r = ""+current;
		for(int i = 0 ; i < code.length() ; i++){
			int value = code.charAt(i)-48;
			int left = (i-1>=0) ? (r.charAt(i-1)-48):0;
			int right = value - left - current;
			
			if(i != code.length()-1){
				if(right == 1 || right == 0){
					current = right;
					r += right;
				}
				else{
					r = "NONE";
					break;
				}
			}
			else{
				if(right != 0){
					r = "NONE";
					break;
				}
			}
		}
		return r;
	}
}
