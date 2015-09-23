package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length ; i++){
        	int target = -nums[i];
        	int front = i+1;
        	int back = nums.length-1;
        	while(front < back){
        		int sum = nums[front]+nums[back];
        		//Finding answer which starts from number nums[i]
        		if(sum < target){
        			front++;
        		}
        		else if(sum > target){
        			back--;
        		}
        		else{
        			ArrayList<Integer> answer = new ArrayList<Integer>();
        			answer.add(nums[i]);
        			answer.add(nums[front]);
        			answer.add(nums[back]);
        			res.add(answer);
        			
        			//Processing duplicates of Number 2
        			//Rolling the front pointer to the next different number forwards
        			while(front < back && nums[front] == answer.get(1))
        				front++;
        			//Processing duplicates of Number 3
        			//Rolling the back pointer to the next different number backwards
        			while(front < back && nums[back] == answer.get(2))
        				back--;
        		}
        		//Processing duplicates of Number 1
        		while(i+1 < nums.length && nums[i+1]==nums[i])
        			i++;
        	}
        }
        
        return res;
    }
}
