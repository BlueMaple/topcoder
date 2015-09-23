package com.leetcode;

import java.util.Stack;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode preNode = null;
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			if(preNode != null && root.val <= preNode.val){
				return false;
			}
			preNode = root;
			root = root.right;
		}
		
		return true;
	}
}
