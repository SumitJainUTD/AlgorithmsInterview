package interviewQuestion;
//Here objective is find an element in two dimensional array
//all rows and columns of an array are sorted in ascending order respectively
public class FindElementInSorted2DArray {
		
	public Boolean findElement(int [][] arrA, int number){
		//start from the left top corner, say ele;
		//if ele>number -> move left
		//if ele<number -> move right
		//if you cant move further to find the number , return false
		int row = 0;
		int col = arrA[1].length-1;
		boolean numberFound = false;
		System.out.print("The Movement : " );
		while(numberFound==false){
			int ele = arrA[row][col];
			System.out.print(ele + "->" );
			if(ele==number){				
				return true;
			}
			else if(ele>number)col--;
			else if (ele<number)row++;
			if(row>arrA[0].length-1||col<0)return false;
		}
		return false;		
	}
	
	public static void main(String args[]){
		int [][] a = {{1,2,3,4},{6,7,8,9},{13,14,15,16},{17,18,19,20},{22,23,24,26}};
		int number1 = 15;
		int number2 = 5;
		int number3 = 19;
		int number4 = 25;
		FindElementInSorted2DArray f = new FindElementInSorted2DArray();
		System.out.println("The "+ number1 + " present in 2D array a ??? :" + f.findElement(a, number1));
		System.out.println("The "+ number2 + " present in 2D array a ??? :" + f.findElement(a, number2));
		System.out.println("The "+ number3 + " present in 2D array a ??? :" + f.findElement(a, number3));
		System.out.println("The "+ number4 + " present in 2D array a ??? :" + f.findElement(a, number4));
	}
}
