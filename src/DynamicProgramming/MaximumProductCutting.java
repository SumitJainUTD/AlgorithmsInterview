package DynamicProgramming;
//find the maximum product cutting, where you need to make atleast one cut
//This problem is similar to Rod Cutting problem
//We will solve the smaller problems first
//use the result of smaller problem solutions to get the bigger problem results
//we will check the maximum from 
public class MaximumProductCutting {
	public void maxProductCutting(int n){
		int [] MPC = new int [n+1];
		int [] result = new int [n+1];
		MPC[1]=1;
		for(int i=2;i<n+1;i++){
			int mp = -10000;
			for(int j=1;j<i;j++){
				mp = Math.max(mp,Math.max(j*MPC[i-j],j*(i-j)));
			}
			MPC[i]=mp;
		}
//		for(int i=1;i<n+1;i++){
//			System.out.print("  " + MPC[i]);
//		}
//		System.out.println("  ");
		System.out.println("Dynamic Programming: Maximum product cutting in " + n + "is " +MPC[n]);
	}
	public int trickSol(int n){
		if(n==2||n==3) return n-1;
		int result = 1;
		while(n>4){
			n=n-3;
			result= result*3;
		}
		return (result*n);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		MaximumProductCutting i = new MaximumProductCutting();
		i.maxProductCutting(10);
		System.out.println("Trick Solution: Maximum product cutting for 7 is " + i.trickSol(7));
	}
}