package com.srm146.div2;

public class YahtzeeScore {
	public int maxPoints(int[] toss){
		int[] dices = new int[6];
		for(int i = 0 ; i < toss.length ; i++){
			dices[toss[i]-1] += toss[i];
		}
		
		for(int i = 0 ; i < dices.length ; i++){
			int max = dices[i];
			boolean isMax = true;
			for(int j = 1 ; j < dices.length ; j++){
				if(max < dices[j])
					isMax = false;
			}
			if(isMax)
				return max;
		}
		return -1;
	}

}
