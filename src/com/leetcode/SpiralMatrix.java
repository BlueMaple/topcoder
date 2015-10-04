package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
        	return res;
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row*column;
        int index = 0;
        int sr = 0, er = row-1, sc = 0, ec = column-1;
        while(index < total){
        	int i = sc;
        	while(i <= ec && index < total){
        		res.add(matrix[sr][i++]);
        		index++;
        	}
        	i = ++sr;
        	while(i <= er && index < total){
        		res.add(matrix[i++][ec]);
        		index++;
        	}
        	i = --ec;
        	while(i >= sc && index < total){
        		res.add(matrix[er][i--]);
        		index++;
        	}
        	i = --er;
        	while(i >= sr && index < total){
        		res.add(matrix[i--][sc]);
        		index++;
        	}
        	sc++;
        }
        return res;
    }
}
