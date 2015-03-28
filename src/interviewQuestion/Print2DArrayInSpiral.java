package interviewQuestion;

public class Print2DArrayInSpiral {

	public int arrA[][] = { { 1, 2, 3, 4, 5 }, { 18, 19, 20, 21, 6 },
			{ 17, 28, 29, 22, 7 }, { 16, 27, 30, 23, 8 },
			{ 15, 26, 25, 24, 9 }, { 14, 13, 12, 11, 10 } };

	public int printSpiral(int row_S, int row_E, int col_S, int col_E,
			boolean reverse, boolean rowPrint) {

		if (row_S > row_E && col_S > col_E) {
			return 1;
		}
		if (rowPrint == false) {
			if (reverse == false) {
				for (int i = col_S; i <= col_E; i++) {
					System.out.print(" " + arrA[row_S][i]);
				}
			}
			row_S++;
			rowPrint = true;
			reverse = false;
		}
		if (rowPrint == true) {
			if (reverse == false) {
				for (int i = row_S; i <= row_E; i++) {
					System.out.print(" " + arrA[i][col_E]);
				}
			}
			col_E--;
			rowPrint = false;
			reverse = true;
		}
		if (rowPrint == false) {
			if (reverse == true) {
				for (int i = col_E; i >= col_S; i--) {
					System.out.print(" " + arrA[row_E][i]);
				}
			}
			row_E--;
			rowPrint = true;
			reverse = true;
		}
		if (rowPrint == true) {
			if (reverse == true) {
				for (int i = row_E; i >= row_S; i--) {
					System.out.print(" " + arrA[i][col_S]);
				}
			}
			col_S++;
			rowPrint = false;
			reverse = false;
		}
		printSpiral(row_S, row_E, col_S, col_E, reverse, rowPrint);
		return 0;
	}

	public static void main(String args[]) {
		Print2DArrayInSpiral p = new Print2DArrayInSpiral();
		p.printSpiral(0, 5, 0, 4, false, false);
	}

}
