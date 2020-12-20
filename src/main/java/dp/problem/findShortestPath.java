package dp.problem;

public class findShortestPath {
	static int count = 0;

	static int tc[][] = new int[9][9];

	public static void main(String args[]) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 0, 0, 2, 2) + "  count " + count);

	}

	private static int minCost(int[][] cost, int starti, int startj, int finali, int finalj) {
		count++;
		if (starti > 2 || startj > 2) {
			return 99;
		}
		if (tc[starti][startj] != 0) {
			return tc[starti][startj];
		}

		if (starti == finali && startj == finalj) {
			return cost[starti][startj];
		}
		int mincost = cost[starti][startj] + min(minCost(cost, starti, startj + 1, finali, finalj),
				minCost(cost, starti + 1, startj + 1, finali, finalj),
				minCost(cost, starti + 1, startj, finali, finalj));

		tc[starti][startj] = mincost;

		return mincost;
	}

	private static int min(int minCost, int minCost2, int minCost3) {
		if (minCost < minCost2 && minCost < minCost3)
			return minCost;
		else if (minCost2 < minCost && minCost2 < minCost3)
			return minCost2;
		else if (minCost3 < minCost2 && minCost3 < minCost)
			return minCost3;
		return 0;
	}
}
