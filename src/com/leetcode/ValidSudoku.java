package com.leetcode;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> columnSet = new HashSet<Integer>();
        HashSet<Integer> blockSet = new HashSet<Integer>();
        
        for(int i = 0 ; i < 9 ; i++){
        	char[] list = board[i];
        	for(int j = 0 ; j < 9 ; j++){
        		if(list[j] != '.'){
        			int row = i*10+list[j]-'0';
        			int column = j*10+list[j]-'0';
        			int block = ((i/3)*3+j/3)*10+list[j]-'0';
        			if(!validate(row, rowSet) || 
        			   !validate(column, columnSet) ||
        			   !validate(block, blockSet))
        				return false;
        		}
        	}
        }
        return true;
    }

	private boolean validate(int key, HashSet<Integer> set) {
		if(set.contains(key)){
			return false;
		}
		else{
			set.add(key);
			return true;
		}
	}
}
