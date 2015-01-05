package newInterviewQuestions;

public class RearragePostiveNegativeAlternatively {
	public void rerrange(int[] arrA) {
		int pivot = 0;
		int left = 0;
		int right = arrA.length - 1;
		while (right > left) {
			while (arrA[left] < 0 && left < right)
				left++;
			while (arrA[right] > 0 && left < right)
				right--;
			if (left < right) {

				int temp = arrA[left];
				arrA[left] = arrA[right];
				arrA[right] = temp;
				left++;
				right--;
			}
		}
		// At the point all the negative elements on the left half and
		// positive elements on the right half of the array
		// swap the every alternate element in the left half (negative
		// elements) with the elements in the right (positive elements)
		left = 1;
		int high = 0;
		while (arrA[high] < 0)
			high++;
		right = high;
		while (arrA[left] < 0 && right < arrA.length) {
			int temp = arrA[left];
			arrA[left] = arrA[right];
			arrA[right] = temp;
			left = left + 2;
			right++;
		}
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + arrA[i]);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] arrA = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
		RearragePostiveNegativeAlternatively i = new RearragePostiveNegativeAlternatively();
		i.rerrange(arrA);
	}
}