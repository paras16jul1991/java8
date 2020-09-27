package com.list;

public class FindMiddleElementInList2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		initNode(head);
		printNode(head);

		System.out.println("-------");

		System.out.println(getMiddle(head));
	}

	static int getMiddle(ListNode head) {

		ListNode crr1 = head;
		ListNode crr2 = head;

		while (crr2.next != null && crr2.next.next != null) {

			crr2 = crr2.next.next;
			crr1 = crr1.next;
		}

		return crr1.data;

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
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next = new ListNode(7);

	}

}
