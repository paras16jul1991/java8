package com.list;

import java.util.stream.Stream;

public class CustomSinglyLinkedList {

	private ListNode root;

	public static void main(String[] args) {
		CustomSinglyLinkedList list = new CustomSinglyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		list.remove(0);

		list.print();
	}

	private void print() {
		// this.stream().forEach(x -> System.out.print(x.data));

		while (root != null) {
			System.out.print(root.data + "  ");
			root = root.next;
		}

	}

	private Stream<ListNode> stream() {
		Stream<ListNode> of = Stream.of(root);
		return of;

	}

	private void remove(int index) {

		ListNode curr = root;
		int count = 0;
		if (index == 0) {
			root = root.next;
		}
		while (curr.next != null) {
			if (index - 1 == count) {
				curr.next = curr.next.next;
			} else
				curr = curr.next;
			count++;
		}

	}

	private void add(int i) {
		if (root == null) {
			root = new ListNode(i);
		} else {

			ListNode curr = root;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new ListNode(i);
		}

	}

}
