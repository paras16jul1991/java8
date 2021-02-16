package com.collection;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

	Queue<String> q1 = new LinkedList<String>();

	Queue<String> q2 = new LinkedList<String>();

	void push(String str) {
		q1.add(str);
	}

	String Pop() {
		// String poll = q1.poll();
		// return poll;
		String pop = null;

		int count = q1.size();

		while (count >= 1) {
			if (count == 1)
				pop = q1.poll();
			q2.add(q1.poll());
			count = q1.size();
		}

		while (!q2.isEmpty()) {
			q1.add(q2.poll());
		}

		return pop;
	}

	public static void main(String[] args) {

		StackUsingQueues sq = new StackUsingQueues();
		sq.push("1");
		sq.push("2");
		sq.push("3");
		sq.push("4");
		sq.push("5");
		sq.Pop();

		System.out.print(sq.q1);
	}
}
