package com.tree;

class Tree {
	TreeNode root;

	int minimum(TreeNode node) {

		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int min = node.data;
		int left = minimum(node.left);
		int right = minimum(node.right);
		if (left < min)
			min = left;
		if (right < min)
			min = right;

		return min;
	}

	int maxmimum(TreeNode node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int max = node.data;
		int left = maxmimum(node.left);
		int right = maxmimum(node.right);
		if (left > max)
			max = left;
		if (right > max)
			max = right;

		return max;
	}
}

public class TestfindMiniumMaxInTree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println(tree.maxmimum(tree.root));
		System.out.println(tree.minimum(tree.root));

	}
}
