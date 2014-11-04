package Arrays;

public class DescendingOddAscendingEven {

	public static int[] arrA;

	public void solve() {
		separateOddEven(0, arrA.length - 1);
		int i =0;
		while(arrA[i]%2!=0){
			i++;
			if(i==arrA.length-1)break;
		}
		if(i!=arrA.length-1){
			customizedSort(0, i-1);
		}else{
			customizedSort(0, i);
		}		
		customizedSort(i, arrA.length-1);
	}

	public void separateOddEven(int low, int high) {
		int i = low;
		int j = high;
		while (i < j) {
			while (i<high && arrA[i] % 2 != 0) {
				i++;
			}
			while (j>low && arrA[j] % 2 == 0) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
	}

	public void customizedSort(int low, int high) {
		int mid = (low + high) / 2;
		int left = low;
		int right = high;
		int pivot = arrA[mid]; // select middle element as pivot
		while (left <= right) {
			if (arrA[left] % 2 == 0) {
				while (arrA[left] > pivot)
					left++;// find element which is greater than pivot
				while (arrA[right] < pivot)
					right--;
			} else if (arrA[left] % 2 != 0) {
				while (arrA[left] < pivot)
					left++;// find element which is greater than pivot
				while (arrA[right] > pivot)
					right--;
			}

			if (left <= right) {
				int temp = arrA[left];
				arrA[left] = arrA[right];
				arrA[right] = temp;
				left++;
				right--;
			}
		}
		// Recursion on left and right of the pivot
		if (low < right)
			customizedSort(low, right);
		if (left < high)
			customizedSort(left, high);
	}

	public void swap(int i, int j) {

		if (i < j) {
			int temp = arrA[i];
			arrA[i] = arrA[j];
			arrA[j] = temp;
		}

	}

	public void printArray(int[] arrA) {
		for (int i = 0; i < arrA.length; i++) {
			System.out.print(" " + arrA[i]);
		}
	}

	public static void main(String args[]) {
		arrA = new int[] {1,2,3,4,5,6,7,8,9,10};
		DescendingOddAscendingEven d = new DescendingOddAscendingEven();
		System.out.println("Original Array : ");
		d.printArray(arrA);
		System.out.println("\nOutput Array : ");
		d.solve();
		d.printArray(arrA);

	}
}
