package com.tree;

import java.util.LinkedList;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
	}

}

public class BinaryTreeTest {
	void dfs(Node root) {

		if (root.left != null) {
			dfs(root.left);
		}
		System.out.print(root.data);

		if (root.right != null) {
			dfs(root.right);
		}

	}

	void bfs(Node root) {

		int visited[] = new int[10];
		LinkedList<Node> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			Node node = queue.poll();
			System.out.print(node);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		BinaryTreeTest test = new BinaryTreeTest();
		test.dfs(root);
	}
}
