package dp.problem;

import java.util.Scanner;

class CoinProblem {
	static int count = 0;

	static int arr[] = new int[100];

	static int solve(int n) {
		count++;

		if (n == 0 || n == 1 || n == 2 || n == 3) {

			return n;
		} else if (arr[n] != 0) {
			return arr[n];
		}
		arr[n] = solve(n / 2) + solve(n / 3) + solve(n / 4);
		return arr[n];
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext())
			System.out.println(solve(Integer.valueOf(scanner.next())));

	}
}