package com.leetcode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		char[] chars = word.toCharArray();
		if (board == null || board.length == 0)
			return false;
		int row = board.length;
		int column = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (existChar(i, j, 0, board, chars)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean existChar(int row, int column, int index, char[][] board,
			char[] chars) {
		if (index >= chars.length)
			return true;
		if (row < 0 || row >= board.length || column < 0
				|| column >= board[0].length)
			return false;
		if (board[row][column] != chars[index])
			return false;

		char temp = board[row][column];
		board[row][column] = '*';
		boolean result = existChar(row - 1, column, index + 1, board, chars)
				|| existChar(row + 1, column, index + 1, board, chars)
				|| existChar(row, column - 1, index + 1, board, chars)
				|| existChar(row, column + 1, index + 1, board, chars);
		board[row][column] = temp;
		return result;
	}

}
