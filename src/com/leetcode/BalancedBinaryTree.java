package com.leetcode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}
	
	private int height(TreeNode root){
		if(root == null)
			return 0;
		int lh = height(root.left);
		if(lh == -1)
			return -1;
		
		int rh = height(root.right);
		if(rh == -1)
			return -1;
		
		if(lh-rh < -1 || lh-rh > 1)
			return -1;
		
		return Math.max(lh, rh)+1;
	}
}
