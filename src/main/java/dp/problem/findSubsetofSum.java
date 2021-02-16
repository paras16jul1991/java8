package dp.problem;

public class findSubsetofSum {
	static int count = 0;

	static String tc[] = new String[1000];

	public static void main(String args[]) {

		int ar[] = { 1, 3, 5, 6, 14 };
		int n = 0;
		int sum = 17;
		System.out.print(subset(ar, n, sum) + "  count " + count);

	}

	private static boolean subset(int[] ar, int n, int sum) {
		count++;
		if (n == ar.length - 1 && ar[n] != sum) {
			return false;
		} else if (ar[n] == sum) {
			return true;

		} else if (tc[sum] != null) {
			return Boolean.valueOf(tc[sum]);
		}

		boolean subset = subset(ar, n + 1, sum - ar[n]);
		tc[sum - ar[n]] = String.valueOf(subset);
		if (subset) {
			return true;
		} else {
			boolean subset2 = subset(ar, n + 1, sum);
			tc[sum] = String.valueOf(subset2);
			return Boolean.valueOf(tc[sum]);
		}

	}

}
