package Arrays;

public class OccurrencesInArray {
	public int findOccurrences(int [] arrA, int x){
		int count = 0;
		int startPoint = findFirstOccurrence(arrA,x,0,arrA.length-1);
		if(startPoint<0){
			return -1;
		}
		int endPoint = findLastOccurrence(arrA, x, 0, arrA.length-1);
		count = endPoint-startPoint+1;
		return count;
	}
	public int findFirstOccurrence(int [] arrA, int x,int start, int end ){
		if(end>=start){
			int mid = (start+end)/2;			
			if((mid==0||(arrA[mid-1]<x)) && arrA[mid]==x){
				return mid;
			}else if(arrA[mid]<x){
				return findFirstOccurrence(arrA, x, mid+1, end);
			}else{
				return findFirstOccurrence(arrA, x, start, mid-1);
				
			}
		}else return -1;
	}
	public int findLastOccurrence(int [] arrA, int x,int start, int end ){
		if(end>=start){
			int mid = (start+end)/2;
			if((mid==arrA.length-1||arrA[mid+1]>x) &&(arrA[mid]==x)){
				return mid;
			}else if(arrA[mid]>x){
				return findLastOccurrence(arrA, x, start, mid-1);
			}else{
				return findLastOccurrence(arrA, x, mid+1, end);
			}
		}else return -1;
	}
	public static void main(String args[]){
		int [] arrA = {1,2,2,2,2,2,2,2,3,4,5,5,6};
		int x = 2;
		OccurrencesInArray i = new OccurrencesInArray();
		int r = i.findOccurrences(arrA, x);
		System.out.println("No of Occurrences of number " + x + " is : " + r);
	}
}
