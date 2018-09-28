package com.list;

class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	SinglyLinkedListNode(int data) {
		this.data = data;
	}

}

public class TestMergeList {

	public static void main(String[] args) {

		SinglyLinkedListNode head1 = new SinglyLinkedListNode(0);
		head1.next = new SinglyLinkedListNode(2);
		head1.next.next = new SinglyLinkedListNode(2);
		head1.next.next.next = new SinglyLinkedListNode(3);
		head1.next.next.next.next = new SinglyLinkedListNode(4);
		head1.next.next.next.next.next = new SinglyLinkedListNode(5);

		SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
		head2.next = new SinglyLinkedListNode(3);
		head2.next.next = new SinglyLinkedListNode(6);
		head2.next.next.next = new SinglyLinkedListNode(9);
		head2.next.next.next.next = new SinglyLinkedListNode(10);

		SinglyLinkedListNode mergeLists = mergeLists(head1, head2);
		while (mergeLists != null) {
			System.out.print(mergeLists.data + " ");
			mergeLists = mergeLists.next;
		}
	}

	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		SinglyLinkedListNode temp;
		SinglyLinkedListNode temp2;
		SinglyLinkedListNode tempo;
		SinglyLinkedListNode tempo2;

		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		if (head1.data < head2.data) {
			temp = head1;
			temp2 = head2;
		} else {
			temp = head2;
			temp2 = head1;
		}
		tempo = new SinglyLinkedListNode(temp.data);
		tempo2 = tempo;
		temp = temp.next;
		while (true) {
			if (temp != null && temp2 == null) {
				tempo.next = new SinglyLinkedListNode(temp.data);
				temp = temp.next;
				tempo = tempo.next;
			}
			if (temp == null && temp2 != null) {
				tempo.next = new SinglyLinkedListNode(temp2.data);
				temp2 = temp2.next;
				tempo = tempo.next;
			}
			if (temp != null && temp2 != null) {
				if (temp.data < temp2.data) {
					tempo.next = new SinglyLinkedListNode(temp.data);
					temp = temp.next;
				} else if (temp2.data < temp.data) {
					tempo.next = new SinglyLinkedListNode(temp2.data);
					temp2 = temp2.next;

				} else if (temp2.data == temp.data) {
					tempo.next = new SinglyLinkedListNode(temp2.data);
					tempo = tempo.next;
					tempo.next = new SinglyLinkedListNode(temp.data);
					temp = temp.next;
					temp2 = temp2.next;

				}
				tempo = tempo.next;
			}
			if (temp == null && temp2 == null) {
				break;
			}

		}
		return tempo2;
	}
}
