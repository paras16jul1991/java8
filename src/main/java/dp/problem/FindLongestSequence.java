package dp.problem;

public class FindLongestSequence {

	static int count = 0;

	public static int lengthOfLIS(int[] nums) {

		return length(nums, 0, nums[0]);
	}

	static int length(int[] nums, int index, int value) {

		count++;

		int length = 1;

		if (index == nums.length - 1) {
			return 1;
		}

		if (index >= nums.length - 1) {
			return 0;
		}
		System.out.println(" -- " + nums[index]);

		int sublength = length(nums, index + 1, nums[index + 1]);

		while (index < nums.length - 1 && value >= nums[index]) {
			index++;
		}

		if (index == nums.length - 1 && value < nums[index]) {
			length = length + 1;
		} else if (index < nums.length - 1 && value < nums[index])
			length = length + length(nums, index + 1, nums[index + 1]);

		return Math.max(length, sublength);
	}

	public static void main(String args[]) {

		int ar[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

		System.out.println(lengthOfLIS(ar) + "  count " + count);

	}

}