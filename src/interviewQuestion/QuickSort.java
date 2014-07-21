package interviewQuestion;

public class QuickSort
{
	private int [] arrA;
	public QuickSort(int [] arrA){
		this.arrA = arrA;
	}
	public void quickS(int low, int high){
		int mid = (low+high)/2;
		int left = low;
		int right = high;
		int pivot = arrA[mid];
	//	System.out.println("XXX" + pivot);
		while(left<=right){
			while(arrA[left]<pivot) left++;
			while(arrA[right]>pivot)right--;
			//	System.out.println(arrA[left] + " " + pivot + " " + arrA[right] );
			if(left<=right){
				int temp = arrA[left];
				arrA[left] = arrA[right];
				arrA[right]= temp;
				left++;
				right--;
			}
		}
			if(low<right)quickS(low,right);
			if(left<high)quickS(left,high);
	}
	public void display(){
		for(int i =0;i<arrA.length;i++){
			System.out.print(" " + arrA[i] );
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int a [] = { 2,1,8,4,0,9,3,11};
		QuickSort i = new QuickSort(a);
		System.out.print("UnSorted : ");
		i.display();
		i.quickS(0,a.length-1);
		System.out.println("");
		System.out.print("Quick Sorted : ");
		i.display();
	}
}
