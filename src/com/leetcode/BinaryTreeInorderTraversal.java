package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	addNode(res, root);
    	
    	return res;
    }

	private void addNode(List<Integer> res, TreeNode root) {
		if(root != null){
	    	addNode(res, root.left);
	    	res.add(root.val);
	    	addNode(res, root.right);
		}
	}
	
	public List<Integer> inorderTraversal_noRecursion(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;
		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			res.add(current.val);
			current = current.right;
		}
		
		return res;
	}
}
