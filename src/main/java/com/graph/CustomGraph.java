package com.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomGraph {
	int size;
	List<Integer> vertex[];

	CustomGraph(int v) {
		this.size = v;
		vertex = new LinkedList[size];
		for (int i = 0; i < v; i++) {
			vertex[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int fromVertex, int toVertex) {
		vertex[fromVertex].add(toVertex);
	}

	public static void main(String[] args) {
		CustomGraph graph = new CustomGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		graph.bfs(2);

		System.out.println(graph.findPathBetweenTwoVertex(0, 3));
	}

	private void bfs(int i) {

		LinkedList<Integer> qu = new LinkedList<>();
		ArrayList<Integer> visit = new ArrayList<>();
		qu.add(i);

		while (!qu.isEmpty()) {
			int poll = qu.poll();
			visit.add(poll);
			Iterator<Integer> iterator = vertex[poll].iterator();
			while (iterator.hasNext()) {
				Integer next = iterator.next();
				if (!visit.stream().anyMatch(x -> x == next))
					qu.add(next);
			}
			System.out.println(poll);
		}
	}

	private boolean findPathBetweenTwoVertex(int v1, int v2) {

		Queue<Integer> q = new LinkedList<>();
		q.add(v1);
		boolean isVisited[] = new boolean[this.size];

		while (!q.isEmpty()) {

			int pollVal = q.poll();
			isVisited[pollVal] = true;
			Iterator<Integer> iterator = vertex[pollVal].iterator();
			while (iterator.hasNext()) {
				Integer next = iterator.next();
				if (next == v2) {
					return true;
				}
				if (isVisited[next] == false)
					q.add(next);
			}
		}

		return false;
	}

}
