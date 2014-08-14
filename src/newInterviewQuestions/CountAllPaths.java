package newInterviewQuestions;

public class CountAllPaths {
	
	int rowCount;
	int colCount;
	int [][] arrA;
	
	public CountAllPaths(int arrA[][]){
		this.arrA = arrA;
		rowCount=arrA.length;
		colCount = arrA[0].length;
	}
	public int countAllResursion(int currentRow, int currentColumn){
		if(currentRow==rowCount-1){
			return 1;
		}
		if(currentColumn==colCount-1){
			return 1;
		}
		return countAllResursion(currentRow+1,currentColumn) + countAllResursion(currentRow,currentColumn+1)+ countAllResursion(currentRow+1,currentColumn+1);
	}
	public int printAllDynamic(int [][] arrA){
		int [][]resultCount = new int [arrA.length][arrA[0].length];
		for(int i=0;i<arrA.length;i++){
			resultCount[i][0]=1;
		}
		for(int i=0;i<arrA[1].length;i++){
			resultCount[0][i]=1;
		}
		
		for(int i=1;i<arrA.length;i++){
			for(int j=1;j<arrA[1].length;j++){
				resultCount[i][j]= resultCount[i][j-1] + resultCount[i-1][j] + resultCount[i-1][j-1];
			}
		}
		return resultCount[arrA.length-1][arrA[0].length-1];
	}
	
	public static void main(String args[]){
		int [][]a = {{1,2,3},{4,5,6},{7,8,9}};
		CountAllPaths p = new CountAllPaths(a);
		System.out.println("No of Paths By Recursion: " +p.countAllResursion(0, 0));
		System.out.println("No of paths By Dynamic Programming: " +p.printAllDynamic(a));
	}

}

