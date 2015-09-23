package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		addPath(res, "", root);
		
		return res;
	}

	private void addPath(List<String> res, String path, TreeNode node) {
		if(node != null){
			if(node.left != null || node.right != null){
				path += node.val+"->";
				addPath(res, path, node.left);
				addPath(res, path, node.right);
			}
			else{
				path += node.val;
				res.add(path);
			}
		}
		
	}
}
