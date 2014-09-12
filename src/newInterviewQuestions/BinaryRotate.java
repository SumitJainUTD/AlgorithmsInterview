package newInterviewQuestions;

public class BinaryRotate {
	
	public int rotateBinary(int number){
		int res = 0;
		while(number>0){
			res=res<<1;
			res = res|(number & 1);
			number=number>>1;
		}
		return res;
	}
	public static void main(String args[]){
		int x =30;
		BinaryRotate b = new BinaryRotate();
		System.out.println("Binary rotation of "+ x + " is : " + b.rotateBinary(x));
	}

}
