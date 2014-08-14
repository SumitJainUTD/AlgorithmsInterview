package DynamicProgramming;

public class RodCuttingProblem {
	public void rodCut(int [] arrPrice){
		int rodLen = arrPrice.length;
		int [] RCP = new int [rodLen+1];
		int [] result =new int [rodLen+1];
		//Base Case:
		RCP[0]=0;  //Rod of 0 length with have price 0
		result[0]=0; 
		//Recurrence Relation
		// RCP[i] = Max of (arrPrice[j] + RCP[i-j-1]) where j=1 to i
		//Also store the first optimal cut into result[]
		for(int i=1;i<rodLen+1;i++){
			int maxP = -1000000;
			for(int j=0;j<i;j++){
				if(maxP<arrPrice[j]+RCP[i-j-1]){
					maxP = arrPrice[j]+RCP[i-j-1];
					result[i]=j+1;
				}
			}
			RCP[i]=maxP;
		}
		System.out.print("Optimal Solution:");
			int n = rodLen;
			while(n>0){
				System.out.print("  " + result[n]);
				n=n-result[n];
			}
			System.out.println("");
			System.out.println("Optimal Price :" + RCP[rodLen]);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] arrPrice = { 1,5,8,9,10,17,17,20};
		RodCuttingProblem i = new RodCuttingProblem();
		i.rodCut(arrPrice);
	}
}