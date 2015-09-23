package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<List<TreeNode>> factors = new ArrayList<List<TreeNode>>();

		List<TreeNode> oneNode = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(1);
		oneNode.add(root);
		factors.add(oneNode);

		List<TreeNode> twoNodes = new ArrayList<TreeNode>();
		root = new TreeNode(1);
		root.right = new TreeNode(2);
		twoNodes.add(root);
		root = new TreeNode(2);
		root.left = new TreeNode(1);
		twoNodes.add(root);
		factors.add(twoNodes);

		if (n <= 0){
			List<TreeNode> empty = new ArrayList<TreeNode>();
			empty.add(null);
			return empty;
		}
			
		if (n == 1 || n == 2)
			return factors.get(n - 1);

		for (int i = 3; i <= n; i++) {
			List<TreeNode> temp = new ArrayList<TreeNode>();
			for (int j = 1; j <= i; j++) {
				addTargetRootTree(j, i, temp, factors);
			}
			factors.add(temp);
		}

		return factors.get(n-1);
	}

	private void addTargetRootTree(int rootValue, int n, List<TreeNode> list,
			List<List<TreeNode>> factors) {
		int leftNumber = rootValue - 1;
		int rightNumber = n - rootValue;

		List<TreeNode> left = copy(1, leftNumber, factors);
		List<TreeNode> right = copy(rootValue + 1, rightNumber, factors);
		if (left == null && right != null) {
			for (int i = 0; i < right.size(); i++) {
				TreeNode root = new TreeNode(rootValue);
				root.right = right.get(i);
				list.add(root);
			}
		} else if (right == null) {
			for (int i = 0; i < left.size(); i++) {
				TreeNode root = new TreeNode(rootValue);
				root.left = left.get(i);
				list.add(root);
			}
		} else {
			for (int i = 0; i < left.size(); i++) {
				for (int j = 0; j < right.size(); j++) {
					TreeNode root = new TreeNode(rootValue);
					root.left = left.get(i);
					root.right = right.get(j);
					list.add(root);
				}
			}
		}
	}

	private List<TreeNode> copy(int add, int size, List<List<TreeNode>> factors) {
		if(size == 0)
			return null;
		List<TreeNode> source = factors.get(size - 1);
		List<TreeNode> target = new ArrayList<TreeNode>();
		for (int i = 0; i < source.size(); i++) {
			TreeNode newRoot = new TreeNode(source.get(i).val + add - 1);
			copy(newRoot, source.get(i), add - 1);
			target.add(newRoot);
		}
		return target;
	}

	private void copy(TreeNode newRoot, TreeNode oldRoot, int size) {
		if(oldRoot != null){
			if(oldRoot.left != null){
				newRoot.left = new TreeNode(oldRoot.left.val+size);
				copy(newRoot.left, oldRoot.left, size);
			}
			if(oldRoot.right != null){
				newRoot.right = new TreeNode(oldRoot.right.val+size);
				copy(newRoot.right, oldRoot.right, size);
			}
		}
	}

}
