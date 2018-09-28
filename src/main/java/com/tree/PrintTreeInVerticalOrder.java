package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PrintTreeInVerticalOrder {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		printVerticalOrder(root);
	}

	private static void printVerticalOrder(Node root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		printVertical(root, 0, map);
		map.entrySet().stream().forEach(x -> System.out.println(x));
	}

	private static void printVertical(Node root, int i, TreeMap<Integer, List<Integer>> map) {
		if (root != null) {
			List<Integer> list = map.get(i);
			if (list == null)
				list = new ArrayList<Integer>();
			list.add(root.data);
			map.put(i, list);
			printVertical(root.left, i - 1, map);
			printVertical(root.right, i + 1, map);
		}
	}
}
