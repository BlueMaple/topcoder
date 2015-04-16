package com.srm145.div2;

public class ExerciseMachine {
	public int getPercentages(String time){
		String[] split = time.split(":");
		int seconds = 
				Integer.parseInt(split[0])*3600+
				Integer.parseInt(split[1])*60+
				Integer.parseInt(split[2]);
		int maxGcd = gcd(seconds , 100);
		int div = 100/maxGcd;
		if(100%div == 0)
			return (100/div-1);
		else
			return 100/div;
	}
	
	private int gcd (int a , int b){
		int min = (a > b)?b:a;
		int max = (a > b)?a:b;
		
		if(min == 0)
			return max;
		else
			return gcd(min , max-min);
	}
}
