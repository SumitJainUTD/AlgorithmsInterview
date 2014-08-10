package DynamicProgramming;

public class KnapSack {
	public void solve(int [] weights, int [] values, int kpSize){
		int maxWeight = weights[weights.length-1];
		int [][]kp = new int [weights.length+1][maxWeight+1];		
		for(int i=0;i<=weights.length;i++){
			kp[i][0]=0;
		}
		for(int i=0;i<=maxWeight;i++){
			kp[0][i]=0;
		}		
		for(int i =0;i<weights.length;i++){
			for(int j=1;j<maxWeight;j++){
				if(j<weights[i]){
					kp[i+1][j] = kp[i][j];  //weight array values are starting from 0 index s0 here actuall i = i+1
				}
				else{
					kp[i+1][j] = Math.max(values[i]+kp[i][j-weights[i]],kp[i][j]); //weight array values are starting from 0 index s0 here actuall i = i+1
				}
			}
		}
//		for(int i =0;i<weights.length;i++){
//			for(int j=0;j<maxWeight;j++){
//				System.out.print(" " + kp[i][j]);
//			}
//			System.out.println("");
//		}		
		//find the actual solutions
		int maxval = kp[weights.length-1][maxWeight-1];
		int changeCol=0;
		for(int i = maxWeight-1;i>=0;i--){
			if(kp[weights.length-1][i]!=maxval){
				changeCol = i+1;
				break;
			}
		}
		System.out.println("Knapsack size is " + maxval);
		System.out.print("Actuals weights are :");
		String s = "";
		int temp = maxval;
		for(int i = weights.length-1;i>=0;i--){
			if(temp!=kp[i][changeCol]){
				System.out.print(weights[i] + " , " );
			}
		}		
	}
	public static void main(String args[]){
		int w [] = {2,3,4,5,6};
		int v [] = {3,5,4,6,7};
		KnapSack k = new KnapSack();
		k.solve(w, v, 6);
	}
}
