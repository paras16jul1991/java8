package com.tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomBST {

	TreeNode root;

	void insert(int i) {
		root = insertNode(root, i);
	}

	private TreeNode insertNode(TreeNode node, int i) {
		if (node == null) {
			node = new TreeNode(i);
			return node;
		} else {
			if (i < node.data) {
				node.left = insertNode(node.left, i);
			} else {
				node.right = insertNode(node.right, i);
			}
		}
		return node;
	}

	TreeNode remove(TreeNode node, int value) {
		if (node != null) {
			if (node.data == value) {
				if (node.left == null && node.right == null) {
					return null;
				} else {
					node = node.left;
				}

			} else {
				if (value < node.data) {
					node.left = remove(node.left, value);
				} else if (value > node.data) {
					node.right = remove(node.right, value);
				}
			}
		}
		return node;
	}

	void removeNode(int value) {
		root = remove(root, value);
	}

	void bstPrint() {

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.data + " ");

			if (node.left != null)
				q.add(node.left);

			if (node.right != null)
				q.add(node.right);
		}
	}

	int countLeafNode(TreeNode node) {

		int count = 0;

		if (node == null) {
			return count;
		} else if (node.left == null && node.right == null) {
			count++;
			return count;
		} else {
			count = count + countLeafNode(node.left);
			count = count + countLeafNode(node.right);
			return count;
		}

	}

	int getHeight(TreeNode node) {
		int height = 1;
		if (node == null) {
			return 0;
		}

		int leftheight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return height + (leftheight > rightHeight ? leftheight : rightHeight);
	}

	public static void main(String[] args) {
		CustomBST bst = new CustomBST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(1);
		bst.insert(3);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.bstPrint();
		System.out.println(" leaf Count " + bst.countLeafNode(bst.root));
		System.out.println(" Tree Height " + bst.getHeight(bst.root));
		System.out.println("Sum of All Nodes " + bst.sumofnodes(bst.root));
		System.out.println("Sum of All Right Nodes " + bst.sumofRightTree(bst.root));
		System.out.println("Diameter of Tree " + bst.diameter(bst.root));
		bst.printRootToLeafpath(bst.root);
		// Construct
		// int pre[] = { 4, 2, 1, 3, 6, 5, 14, 12, 10, 8, 7, 9, 11, 13, 16, 15,
		// 17, 19, 18 };
		// int in[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
		// 17, 18, 19 };
		// TreeNode constructTree = bst.ConstructTree(pre, in, 0, in.length -
		// 1);
		// bst.root = constructTree;
		// bst.bstPrint();
		// System.out.println(" leaf Count " + bst.countLeafNode(bst.root));
		// System.out.println("Diameter of Tree " + bst.diameter(bst.root));

	}

	TreeNode ConstructTree(int pre[], int in[], int pstart, int end) {
		TreeNode top;
		if (pstart > end)
			return null;

		if (pstart == end)
			return top = new TreeNode(in[pstart]);

		int index = 0;
		int temp = pre[pstart];
		for (int j = pstart; j <= end; j++) {
			if (in[j] == temp) {
				index = j;
				break;
			}

		}
		top = new TreeNode(pre[pstart]);
		top.left = ConstructTree(pre, in, pstart + 1, index - 1);
		top.right = ConstructTree(pre, in, index + 1, end);
		return top;

	}

	int sumofnodes(TreeNode node) {
		int sum = 0;

		if (node == null) {
			return 0;
		}
		sum = node.data;
		if (node.left != null) {
			sum = sum + sumofnodes(node.left);
		}
		if (node.right != null) {
			sum = sum + sumofnodes(node.right);
		}
		return sum;
	}

	int sumofRightTree(TreeNode node) {
		int sum = 0;
		if (node == null) {
			return 0;
		}
		sum = node.data;

		if (node.right != null) {
			sum = sum + sumofnodes(node.right);
		}

		return sum;
	}

	void pathToLongestLeaf(TreeNode node, LinkedList<TreeNode> queue) {
		if (node == null) {
			return;
		}
		if (node.left != null || node.right != null) {
			// queue.add(node);
		}
		queue.add(node.left);
		while (!queue.isEmpty()) {
			TreeNode n = queue.poll();

		}

	}

	int diameter(TreeNode node) {
		int diameter = 0;
		if (node == null) {
			return 0;
		}
		diameter = 1 + getHeight(node.left) + getHeight(node.right);
		int ldiameter = diameter(node.left);
		int rdiameter = diameter(node.right);

		return Math.max(diameter, Math.max(ldiameter, rdiameter));
	}

	void printRootToLeafpath(TreeNode node) {
		int ar[] = new int[100];
		printpath(node, ar, 0);
	}

	void printpath(TreeNode node, int[] ar, int length) {
		if (node == null) {
			return;
		}
		ar[length] = node.data;
		length++;
		if (node.left == null && node.right == null) {
			printArray(ar);
		} else {
			printpath(node.left, ar, length);
			printpath(node.right, ar, length);
		}
	}

	private void printArray(int[] ar) {
		System.out.println("");
		Arrays.stream(ar).forEach(x -> System.out.print(x));
	}

}
