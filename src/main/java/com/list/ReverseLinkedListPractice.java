package com.list;

public class ReverseLinkedListPractice {

	static ListNode reverse(ListNode head) {

		ListNode rev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = rev;
			rev = curr;
			curr = temp;

		}

		return rev;
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
		printNode(head);
		System.out.print("-------");
		printNode(reverse(head));
	}
}
