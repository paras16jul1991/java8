package com.list;

import java.util.StringJoiner;

class ListNode {
	ListNode next;
	int data;

	ListNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(String.valueOf(data));
		ListNode n = this.next;
		while (n != null) {
			builder.append(String.valueOf(n.data));
			n = n.next;
		}
		return builder.toString();
	}
}

public class RevenseList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		initNode(head);
		// printNode(head);
		reverseList(head, 4);

		StringJoiner joiner = new StringJoiner(",");
		joiner.add("Hello");
		joiner.add(null);
		joiner.add("paras");
		System.out.println(joiner.toString());

		String str = String.format("%s test %s", 1, 1);
		System.out.println(str);
	}

	private static void reverseList(ListNode head, int k) {

		printNode(head);
		System.out.println("");
		while (k > 0) {
			head = reverse(head);
			k--;
			printNode(head);
			System.out.println("");
		}

	}

	private static ListNode reverse(ListNode head) {

		ListNode init = head;
		ListNode temp = head;
		head = head.next;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = init;
		init.next = null;
		return head;
	}

	private static void printNode(ListNode head) {
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}

	private static void initNode(ListNode head) {
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
	}
}
