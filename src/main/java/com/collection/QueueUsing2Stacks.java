package com.collection;
import java.util.Stack;

public class QueueUsing2Stacks {

	Stack<String> s1 = new Stack<>();
	Stack<String> s2 = new Stack<>();

	void enqueue(String item) {
		s1.push(item);
	}

	void dequeue() {
		int count = 0;
		int size = s1.size();
		while (count < size) {

			if (count == size - 1) {
				s1.pop();
			} else
				s2.push(s1.pop());
			count++;
		}

		int s1Size = s2.size();
		int s2count = 0;
		while (s2count < s1Size) {
			s1.push(s2.pop());
			s2count++;
		}

	}

	public static void main(String[] args) {
		QueueUsing2Stacks queueUsing2Stacks = new QueueUsing2Stacks();
		queueUsing2Stacks.enqueue("1");
		queueUsing2Stacks.enqueue("2");
		queueUsing2Stacks.enqueue("3");
		queueUsing2Stacks.enqueue("4");

		queueUsing2Stacks.dequeue();
		queueUsing2Stacks.dequeue();

		queueUsing2Stacks.enqueue("5");
		queueUsing2Stacks.dequeue();

		System.out.println(queueUsing2Stacks.s1);
	}
}
