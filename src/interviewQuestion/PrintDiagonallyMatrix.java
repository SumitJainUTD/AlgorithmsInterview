package interviewQuestion;

public class PrintDiagonallyMatrix {
		
	public void print(int [] []arrA){
		int lines = arrA[0].length+arrA[1].length-1;
		int N = arrA[0].length;
		int i = 0;
		int j =0;
		for(int counter = 0;counter<lines;counter++){
			if(counter<N){
				i=counter;
				j=0;
			}else{
				i=N-1;
				j=(counter+1)%N;
			}
			while(i>=0 && j<N){
				System.out.print(" " + arrA[i][j]);
				i--;
				j++;;
			}
			System.out.println("");
		}
	}
	public static void main(String args[]) {
		int arrA[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		PrintDiagonallyMatrix p = new PrintDiagonallyMatrix();
		p.print(arrA);
	}
	
}
