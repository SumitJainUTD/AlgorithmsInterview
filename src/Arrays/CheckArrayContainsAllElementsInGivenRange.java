package Arrays;

public class CheckArrayContainsAllElementsInGivenRange {

	public Boolean find(int[] arrA, int x, int y) {
		int range = y - x;
		for (int i = 0; i < arrA.length; i++) {
			if (arrA[i] >= x && arrA[i] <= y) {
				int z = arrA[i] - x;
				if (arrA[z] > 0) {
					arrA[z] = arrA[z] * -1;
				}
			}
		}
		// for(int i=0;i<arrA.length;i++){
		// System.out.print("  " + arrA[i]);
		// }
		for (int i = 0; i < range; i++) {
			if (arrA[i] > 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] arrA = { 11, 17, 13, 19, 15, 16, 12, 14 };
		int x = 12;
		int y = 15;
		CheckArrayContainsAllElementsInGivenRange i = new CheckArrayContainsAllElementsInGivenRange();
		System.out.println(i.find(arrA, x, y));
	}
}
