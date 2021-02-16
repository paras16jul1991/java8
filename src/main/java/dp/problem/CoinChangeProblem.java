package dp.problem;

public class CoinChangeProblem {

	static int count = 0;

	static int tc[] = new int[1000];

	public static void main(String args[]) {

		int ar[] = { 2, 5, 3, 6 };
		int n = 0;
		int sum = 10;
		System.out.print(countCombination(ar, n, sum) + "  count " + count);

	}

	private static int countCombination(int[] ar, int n, int sum) {
		count++;
		// System.out.println("n = " + n + " val = " + ar[n] + " sum = " + sum);

		if (n == ar.length) {
			return 0;
		} else if (ar[n] == sum) {
			return 1;
		}
		if (sum - ar[n] < 0) {
			return 0;
		}
		System.out.println("n = " + n + " val = " + ar[n] + " sum = " + sum);

		int countCombination = countCombination(ar, n, sum - ar[n]);

		System.out.println("here  " + countCombination);

		return countCombination + countCombination(ar, n + 1, sum);

	}

}
