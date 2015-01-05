package newInterviewQuestions;

public class MinimumSubArraySum {

	public void minSubArray(int[] arrA, int x) {
		int start = 0;
		int ansEnd = 0;
		int ansStart = 0;
		int currSum = 0;
		int minLen = arrA.length;
		for (int i = 0; i <= arrA.length; i++) {
			while (currSum > x) {
				currSum = currSum - arrA[start];
				if (i - start < minLen) {
					minLen = (i - start);
					ansEnd = i;
					ansStart = start;
				}
				start++;
			}
			if (i < arrA.length) {
				currSum = currSum + arrA[i];
			}
		}
		System.out.println("Minimum length of subarray to get " + x + " is : "
				+ minLen);
		System.out.print("SubArray is:");
		for (int i = ansStart; i < ansEnd; i++) {
			System.out.print("   " + arrA[i]);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] arrA = { 1, 10, 3, 40, 18 };
		MinimumSubArraySum i = new MinimumSubArraySum();
		i.minSubArray(arrA, 50);
	}
}