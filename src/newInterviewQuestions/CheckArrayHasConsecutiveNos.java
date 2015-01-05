package newInterviewQuestions;

public class CheckArrayHasConsecutiveNos {
//1. Find the Maximum and minimum elements in array (Say the array is arrA)
//2. Check if array length   = max-min+1
//3. subtract the min from every element of the array.
//4. Check if array doesn't have duplicates
//for Step 4
	//a) If array contains negative elements
			//a.1) create an aux array and put 0 at every position
			//a.2) navigate the main array and update the aux array as aux[arrA[i]]=1
			//a.3) During step 2 if u find any index position already filled with 1, we have duplicates, return false
		//This operation performs in O(n) time and O(n) space
	//b) If array does not contains negative elements - Time Complexity : O(n), Space Complexity : O(1)
		//b.1) Navigate the array
		//b.2) update the array as for ith index :- arrA[arrA[i]] = arrA[arrA[i]]*-1 (if it already not negative)
		//b.3) If is already negative, we have duplicates, return false.

	public Boolean WihtOutAuxArray(int [] arrA){
		//this method with work if numbers are non negative
		int max = findMax(arrA);
		int min = findMin(arrA);
		if(arrA.length!=max-min+1) return false;
		for(int i = 0;i<arrA.length;i++){
			arrA[i] = arrA[i]-min+1;
		}
		for(int i = 0;i<arrA.length;i++){
			int x  = Math.abs(arrA[i]);
			if(arrA[x-1]>0){
				arrA[x-1] = arrA[x-1]*-1;
			}
			else{
				return false;
			} 
		}
		return true;
	}
	public Boolean withAuxArray(int [] arrA){
		// this method with work even if numbers are negative
		int []  aux = new int [arrA.length];
		int max = findMax(arrA);
		int min = findMin(arrA);
		if(arrA.length!=max-min+1) return false;
		for(int i = 0;i<arrA.length;i++){
			arrA[i] = arrA[i]-min;
			aux[i] = 0;
		}
		for(int i = 0;i<arrA.length;i++){
			if(aux[arrA[i]]==0){
				aux[arrA[i]]=1;
			}
			else{
				return false;
			}
		}
		//If we have reached till here means , we satisfied all the requirements
		return true;
	}
	public int findMax(int [] arrA){
		int max = arrA[0];
		for(int i = 1;i<arrA.length;i++){
			if(max<arrA[i]){
				max = arrA[i];
			}
		}
		return max;
	}
	public int findMin(int [] arrA){
		int min = arrA[0];
		for(int i = 1;i<arrA.length;i++){
			if(min>arrA[i]){
				min = arrA[i];
			}
		}
		return min;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] arrA = {21,24,22,26,23,25};
		CheckArrayHasConsecutiveNos i = new CheckArrayHasConsecutiveNos();
		System.out.println(i.withAuxArray(arrA));
		int [] arrB = {11,10,12,14,13};
		System.out.println(i.WihtOutAuxArray(arrB));
		int [] arrC = {11,10,14,13};
		System.out.println(i.WihtOutAuxArray(arrC));
		
	}
}