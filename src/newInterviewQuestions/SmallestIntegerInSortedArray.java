package newInterviewQuestions;

public class SmallestIntegerInSortedArray {
	public int find(int [] arrA){
		int smlNumber = 1;
		for(int i = 0;i<arrA.length;i++){
			if(arrA[i]<=smlNumber){
				smlNumber += arrA[i];
			}else{
				break;
			}			
		}
		return smlNumber;
	}
	public static void main(String arg[]){		
		SmallestIntegerInSortedArray i = new SmallestIntegerInSortedArray();		
		System.out.println("Smallest Positive Integer that cant be represented by the sum of any subset of following arrays are : ");
		int [] arrA = { 1,1,3,4,6,7,9};
		System.out.println("{1,1,3,4,6,7,9} - " + i.find(arrA));
		int [] arrB = {1,1,1,1,1};		
		System.out.println("{1,1,1,1,1} -> " + i.find(arrB));
		int [] arrC = {2,3,6,7};		
		System.out.println("{2,3,6,7} -> " + i.find(arrC));
		int [] arrD = {1,2,6,7,9};		
		System.out.println("{1,2,6,7,9} -> " + i.find(arrD));
	}
}
