package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode current = stack.pop();
			if(current == null)
				break;
			res.add(0, current.val);
			
			if(current.left != null)
				stack.push(current.left);
			if(current.right != null)
				stack.push(current.right);
		}
		
		return res;
	}
}
