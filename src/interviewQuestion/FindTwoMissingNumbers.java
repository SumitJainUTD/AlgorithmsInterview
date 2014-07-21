package interviewQuestion;
//find the two missing numbers from the sequence of consecutive number
//Approach is very simple, Add all the given numbers say S
//Calculate sum of N numbers by formula n(n+1)/2 , say N
//Find sum of two missing numbers a+b = N-S
//Now take the product of all given numbers say P
//now take the product of N numbers , say Np;
//find the product of two missing numbers ab = Np-P
//now we have a+b and ab , we can easily calculate a and b
public class FindTwoMissingNumbers {
	int Sum;
	int SumN;
	int P=1;
	int Np=1;
	int a,b;
	public int []  missingNumbers(int [] arrA, int range){
		SumN = range*(range+1)/2;
		for(int i=0;i<arrA.length;i++){
			Sum +=arrA[i];
		}
		int s= SumN-Sum;
		for(int i=0;i<arrA.length;i++){
			P *=arrA[i];
		}
		for(int i=1;i<=range;i++){
			Np *=i;
		}
		int product = Np/P;
//		System.out.println(product);
		int diffSqr = (int)Math.sqrt(s*s-4*product); // (a-b)^2 = (a+b)^2-4ab
		a = (s+diffSqr)/2;
		b= s-a;
		int [] result = {a,b};
		return result;
	}
	public static void main(String args[]){
		int [] arrA = {10,2,3,5,7,8,9,1};
		FindTwoMissingNumbers f = new FindTwoMissingNumbers();
		int [] results = f.missingNumbers(arrA, 10);
		System.out.println("Missing numbers are :" + results[0] + " and " + results[1]);
	}
}
