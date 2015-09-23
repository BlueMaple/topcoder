package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (current != null) {
			res.add(current.val);
			if(current.right != null){
				stack.push(current.right);
			}
			
			current = current.left;
			if(current == null && !stack.isEmpty())
				current = stack.pop();
		}

		return res;
	}
}
