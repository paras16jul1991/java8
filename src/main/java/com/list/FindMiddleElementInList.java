package com.list;

class Node {
	ListNode next;
	int data;

	Node(int data) {
		this.data = data;
	}
}

public class FindMiddleElementInList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		initNode(head);

		// printNode(head);

		// reverseList(head, 4);

		System.out.println(getMiddle(head));
	}

	static int getMiddle(ListNode head) {
		if (head == null) {
			return -1;
		}

		if (head.next == null) {
			return -1;
		}

		ListNode mid = head;

		while (true) {
			if (head.next != null) {
				mid = mid.next;
				if (head.next.next != null) {
					head = head.next.next;
				} else {
					return mid.data;
				}
			} else {
				mid = mid.next;
				return mid.data;
			}
		}

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
		head.next.next.next.next.next = new ListNode(5);
	}

}
