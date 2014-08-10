package DynamicProgramming;
// here the objective is to find the minimum number of coins required
//to make change of any amount
//Example : Amount 5, coins avaailable
//there are many possiblilties like {1,1,1,1,1},{2,2,1}, {3,2}
//OUr answer is {3,2} = 2 coins

public class MininumCoinChange {
	public int CCDyna(int [] coins, int amount){
		int [] CC = new int [coins.length];
		int [] MinAmt  = new int [amount+1];
		MinAmt[0]=0;
		
		for(int amt=1;amt<=amount;amt++){
			for(int i=0;i<CC.length;i++){
				CC[i]=-1;
			}
			for(int i=0;i<CC.length;i++){
				if(coins[i]<=amt){
					if(MinAmt[amt-coins[i]]<0){
						CC[i] =-1;
					}else{
						CC[i] = MinAmt[amt-coins[i]] + 1;
					}					
				}
			}
//			
//			 for(int i=0;i<CC.length;i++){
//			 	System.out.print("  " + CC[i] );
//			 }
//			 System.out.print("                              ");
			MinAmt[amt] = -1;
			int coinindex =-1;
			for(int i=0;i<CC.length;i++){
				if(CC[i]>=0){
					if(MinAmt[amt] == -1 || MinAmt[amt]>CC[i]){
						MinAmt[amt] = CC[i];
					}
				}
			}
//			 for(int i=0;i<CC.length;i++){
//			 		System.out.print(" CC " + CC[i] );
//			 	}
//				System.out.println("");

//				 for(int a=1;a<=amount;a++){
//				 		System.out.print("  " + MinAmt[a] );
//				 	}
//				 System.out.println("");
		}
		
		
		return MinAmt[amount];
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] coins= {1,2,3,4,5,6,7,8,9,10,11,12,13,15};
		int amount = 46;
		MininumCoinChange i = new MininumCoinChange();
		System.out.println("Minimum no of coins are required to make amount " + amount + " is : " + i.CCDyna(coins,amount) );
	}
}