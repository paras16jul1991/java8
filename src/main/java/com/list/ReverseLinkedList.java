package com.list;

public class ReverseLinkedList {

	static ListNode reverse(ListNode head) {

		ListNode before = null;
		ListNode temp = head;

		while (temp != null) {
			ListNode node = temp.next;
			temp.next = before;
			before = temp;
			temp = node;
		}
		head = before;
		return head;
	}

	private static void initNode(ListNode head) {
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
	}

	private static void printNode(ListNode head) {
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		initNode(head);
		printNode(reverse(head));
	}
}
