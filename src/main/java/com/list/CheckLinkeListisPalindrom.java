package com.list;

public class CheckLinkeListisPalindrom {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(1);
		System.out.println(node.toString());
		boolean b = check(node);
		System.out.println(b);
	}

	private static boolean check(ListNode node) {
		ListNode temp = getReverse(node);
		System.out.println(temp);

		while (node != null) {
			if (temp.data != node.data) {
				return false;
			}
			node = node.next;
		}
		return true;
	}

	private static ListNode getReverse(ListNode node) {
		ListNode init = new ListNode(node.data);
		init.next = null;
		ListNode n = node.next;
		while (n != null) {
			ListNode temp = init;
			init = new ListNode(n.data);
			init.next = temp;
			n = n.next;
		}

		return init;
	}
}
