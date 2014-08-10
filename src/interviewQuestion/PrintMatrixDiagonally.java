package interviewQuestion;

public class PrintMatrixDiagonally {
	public void print(int[][] arrA) {
		int rows = arrA.length - 1;
		int cols = arrA[1].length - 1;
		int Totalcount = rows * cols;
		int count = 0;
		int row_counter = 0;
		while (row_counter <= rows) {
			int y = Math.min(row_counter, cols);
			int x = row_counter;
			for (int i = 0; i <= y; i++) {
				System.out.print(" " + arrA[x--][i]);
			}
			System.out.println("");
			row_counter++;
		}
		row_counter--;
		int col_counter = 0;
		while (col_counter <= cols) {
			int x = col_counter;
			int y = Math.min(col_counter, rows);
			for (int i = y; i <=0; i--) {
				System.out.print(" " + arrA[i][x++]);
			}
			col_counter++;
			System.out.println("");
		}
	}

	public static void main(String args[]) {
		int arrA[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } };
		PrintMatrixDiagonally p = new PrintMatrixDiagonally();
		p.print(arrA);
	}
}
