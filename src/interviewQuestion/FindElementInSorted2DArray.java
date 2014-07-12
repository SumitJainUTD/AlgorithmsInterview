package interviewQuestion;
//Here objective is find an element in two dimentional array
//all rows and columns of an array are sorted in ascending order respectively
public class FindElementInSorted2DArray {
	int [][] arrA;
	int number;
	
	public Boolean findElement(){
		//start from the left top corner, say ele;
		//if ele>number -> move left
		//if ele<number -> move right
		//if you cant move further to find the number , return false
		int row = 0;
		int col = arrA[1].length-1;
		boolean numberFound = false;
		while(numberFound==false){
			int ele = arrA[row][col];
			if(ele==number)return true;
			else if(ele>number)col--;
			else if (ele>number)row++;
			if(row>arrA[0].length-1||col<0)return false;
		}
		return false;
		
	}

}
