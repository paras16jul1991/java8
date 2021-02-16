package dp.problem;

public class MinimumOperationRequired {

	static int count = 0;
	static int arr[][];

	public static void main(String args[]) {

		String s1 = "geek";
		String s2 = "geekr";
		arr = new int[100][100];

		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++) {
				arr[i][j] = -1;
			}

		System.out.print(minimumOperation(s1, s1.length(), s2, s2.length()) + "  count " + count);

	}

	private static int minimumOperation(String s1, int n, String s2, int m) {
		count++;
		System.out.println("n = " + n + " m= " + m);
		int min = 0;

		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}

		if (arr[n - 1][m - 1] != -1) {
			return arr[n - 1][m - 1];
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return arr[n - 1][m - 1] = minimumOperation(s1, n - 1, s2, m - 1);
		}

		min = Math.min(Math.min(minimumOperation(s1, n, s2, m - 1), minimumOperation(s1, n - 1, s2, m - 1)),
				minimumOperation(s1, n - 1, s2, m));

		System.out.println("Minimum  = " + min);
		return arr[n - 1][m - 1] = 1 + min;
	}
}
