package newInterviewQuestions;

public class SubArrayWithGivenSum {

	public void findSubArray(int [] arrA, int Sum){
		int currSum =0;
		int start = 0;
		//idea is to keep adding all the elements to the currSum
		//keep checking if the currSum<Sum
		//if currSum gets greater than the Sum then start reducing the currSum from the beginning of the array using "start"
		//if any time currSum=Sum, Stop and return
		for(int i=0;i<=arrA.length;i++){
			
			while(currSum>Sum){
			//	System.out.println(currSum + " reducing");
				currSum = currSum - arrA[start++];
			//	System.out.println(currSum + " reduced");
			}
			if(currSum==Sum){
				System.out.println(Sum + " is found between indexes " + start +" and " + (i-1));
				return;
			}
			if(i<arrA.length)
			currSum = currSum + arrA[i];
			//System.out.println(currSum);
		}
		
		//if we have reached that means that we have not found the subarray with summation equals to Sum
		System.out.println("No subarray is found with sum equals to " + Sum);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] arrA = {15, 2, 4, 8, 9, 5, 10, 23};
		int Sum = 33;
		SubArrayWithGivenSum i = new SubArrayWithGivenSum();
		i.findSubArray(arrA,Sum);
	}
}