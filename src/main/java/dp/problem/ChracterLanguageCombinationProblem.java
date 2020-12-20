package dp.problem;

import java.util.HashMap;
import java.util.Scanner;

public class ChracterLanguageCombinationProblem {
	static int count = 0;

	static HashMap<String, Integer> map = new HashMap<>();

	static int solve(String n) {
		count++;

		if (n.length() <= 1) {
			return 1;
		} else if (map.get(n) != null) {
			return map.get(n);
		}
		int total = 1 * solve(n.substring(1));
		if (n.length() >= 2) {
			int second = Integer.valueOf(n.substring(0, 2));
			if (second <= 26) {
				total = total + 1 * solve(n.substring(2));
			}
		}
		map.put(n, total);
		return total;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext())
			System.out.println(solve(scanner.next()) + " " + count);

	}
}
