////https://leetcode.com/problems/132-pattern/
class Solution {
	public boolean find132pattern(int[] nums) {

		int[] minimum = new int[nums.length];
		minimum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			minimum[i] = Math.min(nums[i], minimum[i - 1]);
		}

		Stack<Integer> stack = new Stack<>();

		for (int j = nums.length - 1; j >= 0; j--) {

			if (nums[j] > minimum[j]) {

				while (!stack.isEmpty() && stack.peek() <= minimum[j]) {
					stack.pop();
				}

				if (!stack.isEmpty() && stack.peek() < nums[j])
					return true;

				stack.push(nums[j]);

			}

		}

		return false;
	}
}