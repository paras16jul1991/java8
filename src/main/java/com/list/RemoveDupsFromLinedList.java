package com.list;

public class RemoveDupsFromLinedList {

	private static void initNode(ListNode head) {
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
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
		removeDups(head);
	}

	private static void removeDups(ListNode head) {
		ListNode top = head;

		while (top != null) {
			ListNode top2 = top;
			while (top2.next != null) {
				if (top.data == top2.next.data) {
					top2.next = top2.next.next;
				} else {
					top2 = top2.next;
				}
			}
			top = top.next;
		}
		printNode(head);
	}
}
