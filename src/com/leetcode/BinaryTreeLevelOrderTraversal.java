package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
	    List<TreeNode> list = new ArrayList<TreeNode>();
	    addNode(list, root);
	    
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    
	    addLevel(list, res);
	    return res;
    }

	private void addLevel(List<TreeNode> list, List<List<Integer>> res) {
		if(list.size() == 0 || list == null)
			return;
		List<TreeNode> nextList = new ArrayList<TreeNode>();
		List<Integer> value = new ArrayList<Integer>();
		for(int i = 0 ; i < list.size() ; i++){
			value.add(list.get(i).val);
			addNode(nextList, list.get(i).left);
			addNode(nextList, list.get(i).right);
		}
		
		res.add(value);
		
		addLevel(nextList, res);
	}

	private void addNode(List<TreeNode> list, TreeNode node) {
		if(node != null)
			list.add(node);
	}
}
