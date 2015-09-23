package com.leetcode;

public class JumpGameII {
	public int jump(int[] nums) {
		int length = nums.length;

		int[] map = new int[length];
		if(nums[0] == 0)
			return 0;
		//×ó¿ªÓÒ±Õ
		int p1 = 0, p2 = 0;
		for(int i = 0 ; i < length-1 ; i++){
			p2 = nums[i] + i;
			if(p2 > p1){
				changePointValue(map[i], p1, p2, map);
				p1 = p2;
			}
			
			for(int k = 0 ; k < map.length ; k++)
				System.out.print(map[k]+", ");
			System.out.println();

			if(map[length-1] != 0)
				return map[length-1];
			
		}

		return 0;
	}

	private void changePointValue(int numb, int p1, int p2, int[] map) {
		for(int i = p1+1 ; i <= p2 && i < map.length ; i++)
			map[i] = numb+1;
	}
}
