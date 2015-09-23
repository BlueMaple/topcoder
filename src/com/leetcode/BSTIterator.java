package com.leetcode;

import java.util.ArrayList;
//TODO: need edit!!
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	private ArrayList<TreeNode> nodeArray;
	private int index;

    public BSTIterator(TreeNode root) {
    	nodeArray = new ArrayList<TreeNode>();
        addNode(nodeArray, root);
        index = -1;
    }
    
    private void addNode(ArrayList<TreeNode> list, TreeNode root) {
		if(root != null){
			addNode(list, root.left);
			list.add(root);
			addNode(list, root.right);
		}
	}

	/** @return whether we have a next smallest number */
    public boolean hasNext() {
    	index++;
    	return index < nodeArray.size();
    }

    /** @return the next smallest number */
    public int next() {
        if(index >= 0){
        	return nodeArray.get(index).val;
        }
        return -1;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */