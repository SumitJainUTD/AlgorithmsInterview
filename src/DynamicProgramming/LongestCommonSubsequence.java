package DynamicProgramming;

public class LongestCommonSubsequence {
	public void findLCS(String A, String B){
		char [] arrA = A.toCharArray();
		char [] arrB = B.toCharArray();
		String [][] result = new String [arrA.length+1][arrB.length+1];;
		int [][] LCS = new int [arrA.length+1][arrB.length+1];
		for(int i=0;i<arrA.length+1;i++){
			LCS[i][0]=0;
		}
		for(int i=0;i<arrB.length+1;i++){
			LCS[0][i]=0;
		}
		for(int i =1;i<arrA.length+1;i++){
			for(int j =1;j<arrB.length+1;j++){
				if(arrA[i-1]==arrB[j-1]){				
					LCS[i][j]=LCS[i-1][j-1]+1;
					result[i][j]="d";
		//			System.out.print(arrA[i-1]);
				}else{
					if(LCS[i-1][j]>=LCS[i][j-1]){
						LCS[i][j] =LCS[i-1][j];
						result[i][j]= "u";
					}
					else{
						LCS[i][j] =LCS[i][j-1];
						result[i][j]= "l";
					}
					LCS[i][j]= Math.max(LCS[i-1][j],LCS[i][j-1]);
				}
			}
		}		
		int prtX = arrA.length;
		int prtY = arrB.length;
		while(prtX>0 && prtY>0){
			if(result[prtX][prtY]=="d"){
				System.out.print(arrA[prtX-1]);
				prtX--;
				prtY--;
			}else if(result[prtX][prtY]=="l"){
				prtY--;
			}else if(result[prtX][prtY]=="u"){
				prtX--;
			}			
		}
		System.out.println("");
		System.out.println(LCS[arrA.length][arrB.length]);
	}
	
	public static void main(String args[]){
		String A = "ABCBDAB";
		String B = "BDCABA";
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		l.findLCS(A, B);
	}
}
