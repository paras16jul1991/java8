package com.list;

public class testReverseLinkedList {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		System.out.println(node.toString());

		System.out.println(reverse(node));
	}

	private static ListNode reverse(ListNode node) {

		ListNode newNode = null;
		ListNode temp = null;
		ListNode curr = node;
		while (curr != null) {
			temp = curr;
			curr = curr.next;
			temp.next = newNode;
			newNode = temp;
		}
		node = newNode;

		return node;
	}
}
