package newInterviewQuestions;

//Objective is to find the element in an array 
///which occurs more than n/k times
public class NbyKTimes {

	public void findElement(int[] arrA, int k) {
		Elements[] emts = new Elements[k - 1];
		for (int j = 0; j < emts.length; j++) {
			emts[j] = new Elements(0, 0);
		}
		for (int i = 0; i < arrA.length; i++) {
			int index = found(emts, arrA[i]);
			if (index >= 0) {
				// means element found in Elements array
				// just increase its count
				emts[index].count++;
			} else {
				addtoArray(emts, arrA[i]);
			}
		}//
			// now check if any of the elements in the Elements array appears
			// more than n/k times
		for (int i = 0; i < emts.length; i++) {
			int cnt = 0;
			for (int j = 0; j < arrA.length; j++) {
				if (arrA[j] == emts[i].element) {
					cnt++;
				}
			}
			if (cnt > (arrA.length / k)) {
				System.out.println(emts[i].element + " appears more than n/"
						+ k + " times, Actual count is " + cnt);
			}
		}
	}

	public void addtoArray(Elements[] emts, int x) {
		// check is array is full or not
		for (int j = 0; j < emts.length; j++) {
			if (emts[j].count == 0) {// find the empty place and add it
				emts[j].element = x;
				return;
			}
		}
		// if we have reached here means array is full
		// reduce the counter of every element
		for (int j = 0; j < emts.length; j++) {
			emts[j].count--;
		}
	}

	// This found function will check whether element already exist or not
	// if yes then return its index else return -1
	public int found(Elements[] emts, int x) {
		for (int j = 0; j < emts.length; j++) {
			if (emts[j].element == x) {
				return j;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int[] arrA = { 2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8 };
		NbyKTimes n = new NbyKTimes();
		n.findElement(arrA, 4);
	}
}

class Elements {
	int element;
	int count;

	public Elements(int element, int count) {
		this.element = element;
		this.count = count;
	}
}
