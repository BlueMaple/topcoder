package com.srm146.div2;

public class BridgeCrossing {
	public int minTime(int[] times){
		int length = times.length;
		quickSort(times , 0 , length-1);
		
		int result = 0;
		while(length > 0){
			if(length == 1){
				result += times[0];
				break;
			}
			if(length == 2){
				result += times[1];
				break;
			}
			if(length == 3){
				result += times[2]+times[0];
				length--;
			}
			if(2* times[1] > times[0] + times[2]){
				for(int i = length-1 ; i >= 2 ; i--)
					result += times[i]+times[0];
				
				result += times[1];
				break;
			}
			if(length == 4){
				result += times[1]+times[0]+times[3]+times[1];
				length -= 2;
			}
			if(length == 5){
				result += times[1]+times[0]+times[4]+times[1];
				length -= 2;
			}
			if(length == 6){
				result += times[1]+times[0]+times[5]+times[1];
				length -= 2;
			}
		}

		return result;
	}

	private void quickSort(int[] s , int l , int r){
		if(l < r){
			int i = l, j = r, x = s[l];
			while(i < j){
				while(i < j && s[j] > x)
					j--;
				if(i < j)
					s[i++] = s[j];
				while(i < j && s[i] < x)
					i++;
				if(i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quickSort(s, l, i-1);
			quickSort(s, i+1, r);
		}
	}
}

