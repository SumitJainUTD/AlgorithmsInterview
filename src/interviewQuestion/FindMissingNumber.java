package interviewQuestion;
//find the missing number from the sequence of consecutive number
//Approach is very simple, Add all the given numbers say S
//Calculate sum of N numbers by formula n(n+1)/2 , say N
//Find missing number m = N-S
public class FindMissingNumber {
	int Sum;
	int Sum_N;
	
	public int missingNumber(int [] arrA, int size){
		Sum_N = size*(size+1)/2;		
		for(int i=0;i<arrA.length;i++){
			Sum +=arrA[i];
		}
		return Sum_N-Sum;
	}
	public static void main(String args[]){
		int [] arrA = {1,2,3,4,5,7,8,9,10};
		System.out.println("Missing number is :" + (new FindMissingNumber()).missingNumber(arrA,10));
	}
}
