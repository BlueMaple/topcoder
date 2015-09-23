package com.sq.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.algorithms.*;
import com.leetcode.*;

public class MainTest {
	public static void main(String[] args) {
		ValidPalindrome test = new ValidPalindrome();
		System.out.println(test.isPalindrome(".,"));
		
//		String[] test = new String[] { "00010111", "01100101", "10111101",
//				"00010000", "00100010", "11100111", "10011001", "01001100",
//				"10010000" };
//		char[][] testChar = new char[test.length][8];
//		for(int i = 0 ; i < test.length ; i++){
//			String s = test[i];
//			for(int j = 0 ; j < s.length() ; j++){
//				testChar[i][j] = s.charAt(j);
//				System.out.print(s.charAt(j)+" ");
//			}
//			System.out.println();
//		}
		
		
		// PerfectSquares test = new PerfectSquares();
		// System.out.println(test.numSquares(12));

		// HeapSort sort = new HeapSort();
		// int[] test = new int[]{21,7,13,5,7,1,2,3};
		// sort.heapSort(test);
		// for (int l = 0; l < test.length; l++) {
		// System.out.print(test[l]+", ");
		// }

		// UniquePathsII test = new UniquePathsII();
		// System.out.println(test.uniquePathsWithObstacles(new int[][] {
		// { 0, 0, 0 }, {0,1,0},{0,0,0} }));
		// MaximumSubarray test = new MaximumSubarray();
		// System.out.println(test.maxSubArray(new
		// int[]{-2,1,-3,4,-1,2,1,-5,4}));

		// BuyAndSellStockIV test = new BuyAndSellStockIV();
		// System.out.println(test.maxProfit(4,new int[]{3,5,4,2,11}));

		// BitwiseAND test = new BitwiseAND();
		// System.out.println(test.rangeBitwiseAnd_better(21, 23));
		// int a = 8;
		// System.out.println(a<<=1);

		// String str1 = "ABCDEDD";
		// String str2 = "AEFeAAD";
		// int m = str1.length();
		// int n = str2.length();
		// int[][] c = new int[m+1][n+1];
		// System.out.println("lcs长度为"+lcs_len(str1,str2,c));
		// System.out.println("lcs序列为");
		// print_lcs(str1,str2,c);

	}

	public static int lcs_len(String str1, String str2, int[][] c) {
		if (str1 == null || str2 == null) {
			return -1;
		}

		int m = str1.length();
		int n = str2.length();
		for (int i = 1; i <= m; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
				} else
					c[i][j] = c[i][j - 1];
			}
		}
		return c[m][n];
	}

	public static void print_lcs(String str1, String str2, int[][] c) {
		int k = 0;
		int i = str1.length();
		int j = str2.length();
		char[] temp = new char[c[i][j]];
		while (c[i][j] > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				temp[k] = str1.charAt(i - 1);
				k++;
				i--;
				j--;
			} else if (c[i][j] == c[i - 1][j])
				i--;
			else
				j--;
		}
		for (int l = temp.length - 1; l >= 0; l--) {
			System.out.print(temp[l]);
		}

	}
}