package com.srm146.div1;

public class RectangularGrid {
	public long countRectangles(int width, int height){
		int max = (width > height)?width:height;
		int min = (width < height)?width:height;
		
		long allRect = getSum(width)*getSum(height);
		System.out.println("all"+allRect);
		return (allRect - getSqr(max , min));
	}

	private long getSum(int index) {
		long result = 0;
		for(int i = index ; i > 0 ; i--){
			result += i;
		}
		return result;
	}
	
	private long getSqr(int max , int min){
		long result = 0;
		while(min > 0){
			result += max*min;
			max--;
			min--;
		}
		
		return result;
	}

}
