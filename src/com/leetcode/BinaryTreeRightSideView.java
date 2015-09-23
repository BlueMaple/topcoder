package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 
 * ��Ȼһ��͹��ˡ������ٶ�ò�ƻ�����
 */

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		
		if(root != null){
			result.add(root.val);
			List<TreeNode> level = new ArrayList<TreeNode>();
			level.add(root.right);
			level.add(root.left);
			addVisibleNode(result, level);
		}
		
		return result;
	}

	private void addVisibleNode(List<Integer> result, List<TreeNode> level) {
		int size = level.size();
		if(size == 0)
			return;
		boolean added = false;
		
		List<TreeNode> l = new ArrayList<TreeNode>();
		for(int i = 0 ; i < size ; i++){
			if(level.get(i) != null){
				if(!added){
					result.add(level.get(i).val);
					added = true;
				}
				l.add(level.get(i).right);
				l.add(level.get(i).left);
			}
		}
		level = null;
		addVisibleNode(result , l);
	}
}