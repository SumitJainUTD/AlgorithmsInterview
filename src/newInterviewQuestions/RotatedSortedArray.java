package newInterviewQuestions;

public class RotatedSortedArray {
	public static void main(String args[]){
		int a[] = {10,11,12,1,2,3,4,5,6,7,8};
		RotatedSortedArray r = new RotatedSortedArray();
		System.out.println(r.findElement(a,7));		
	}
	public int findElement(int [] arrA, int element){
		int low =  0;
		int high = arrA.length-1;		
		while(low<high){
			int mid = (low+high)/2;
			if(arrA[mid]==element){
				return mid;
			}
			if(arrA[mid]>=arrA[low]){
				if(arrA[mid]>element){
					if(arrA[low]<=element){
						high = mid-1;
					}else{
						low = mid+1;
					}
				}else{
					low = mid+1;
				}
			}else{
				if(arrA[mid]<element){
					if(arrA[low]>element){
						low = mid+1;
					}else{
						high = mid-1;
					}
				}else{
					high = mid-1;
				}					
			}
		}
		return -1;
	}	
}

