package com.tree;

class BinaryTree {
	TreeNode root;

	public void printPreorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	public void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public void printPostorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");
	}
}

public class TreeTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(tree.root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(tree.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder(tree.root);
	}
}
