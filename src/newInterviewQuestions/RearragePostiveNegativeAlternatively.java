package newInterviewQuestions;

public class RearragePostiveNegativeAlternatively {
	//idea is to implement the quick sort techinqe here
	//take 0 as a pivot element and do the one round of iteration of quick sort
	//this will place all the negative elements  on the left half and
	//positive elements on the right half of the array
	public void rerrange(int [] arrA){
		int pivot =0;
		int left =0;
		int right = arrA.length-1;
		while(right>left ){
			while(arrA[left]<0 && left<right) left++;
			while(arrA[right]>0 && left<right) right--;
			
			if(left<right){
				
				int temp = arrA[left];
				arrA[left]=arrA[right];
				arrA[right]=temp;
				left++;
				right--;
				
			}
		}
		// for(int i=0;i<arrA.length;i++){
		// 	System.out.print("  " + arrA[i]);
		// }
		// 	System.out.println("");
		left =1;
		int high =0;
		while(arrA[high]<0)high++;
		//System.out.print("  " + arrA[high]);
		right = high;
		while( arrA[left]<0 && right<arrA.length){
			int temp = arrA[left];
			arrA[left] =arrA[right];
			arrA[right]=temp;
			left = left+2;
			right++;
		}
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + arrA[i]);
				
		}
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] arrA = {1,2,-3,-4,-5,6,-7,-8,9,10,-11,-12,-13,14};
		RearragePostiveNegativeAlternatively i = new RearragePostiveNegativeAlternatively();
		i.rerrange(arrA);
	}
}