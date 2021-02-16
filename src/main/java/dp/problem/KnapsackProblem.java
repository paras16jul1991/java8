package dp.problem;

public class KnapsackProblem {

	static int count = 0;
	static int arr[][];

	public static void main(String args[]) {

		int[] wt = new int[] { 2, 5, 6, 8 };
		int[] value = new int[] { 4, 10, 6, 8 };
		int n = 4;
		int m = 20;

		arr = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++) {

				if (i == 0 || j == 0) {
					arr[i][j] = 0;
				} else if (wt[i - 1] <= j) {
					arr[i][j] = Math.max(value[i - 1] + arr[i - 1][j - wt[i - 1]], arr[i - 1][j]);
				} else {
					arr[i][j] = arr[i - 1][j];
				}
			}

		System.out.println(arr[n][m]);
	}
}
