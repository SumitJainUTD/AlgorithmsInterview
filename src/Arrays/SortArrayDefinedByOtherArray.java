package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;

import interviewQuestion.MergeSort;

public class SortArrayDefinedByOtherArray {
	
	public int [] SortAndSearch(int [] arrA, int [] arrB){
		//create an Aux array and copy all the elements of arrA
		// create another boolean array, visited[] of size arrA[]
		// Initialize visited[] = false
		// Sort the Aux array using Merge sort.
		// Navigate through the arrB, taking one element at a time, say x
		//  1. perform binary search of x on Aux array and find the first occurrence of x
		//  2. if x is found, copy it to arrA, make visited[] = true
		//  3. Do linear navigation on Aux array till you find x, copy all these to arrA and mark visited[] = true  
		// When arrB is over, copy rest of the elements from Aux to arrA.
		
		int oIndex = -1; 
		boolean [] visited = new boolean [arrA.length];
		for(int i=0;i<visited.length;i++){
			visited[i] = false;
		}
		int [] Aux = new int[arrA.length];
		for(int i=0;i<arrA.length;i++){
			Aux[i] = arrA[i];
		}
		System.out.println("Original Array : ");
		displayArray(arrA);
		System.out.println("\nDefined Array : ");
		displayArray(arrB);
		MergeSort m = new MergeSort(Aux);
		Aux = m.mergeSorting();
		for(int i=0;i<arrB.length;i++){
			int x = arrB[i];
			int index = findFirstOccurrence(Aux, x, 0, Aux.length-1);
			if(index>=0){
				arrA[++oIndex]=Aux[index];
				visited[index] = true;
				//oIndex++;
				while(Aux[++index]==x){
					arrA[++oIndex]=Aux[index];
					visited[index] = true;
				}
			}
		}
		for(int i=0;i<Aux.length;i++){
			if(visited[i]==false){
				arrA[++oIndex] = Aux[i];
			}
		}
		return arrA;
	}
	
	public int findFirstOccurrence(int [] arrA, int x, int start, int end){
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
	
	public int [] usingHashing(int [] arrA, int [] arrB){
		//Insert all the elements of arrA in hash Table,
		//Element as key and its count as its value
		//Navigate through arrB, check element's presence in Hash table
		//if it is present then takes its value (count) and insert into arrA.
		//Once arrB is completed, take rest of the elements from Hash table
		// Sort Them and insert into arrB.
		int resIndex = -1;
		Hashtable<Integer, Integer> h = new Hashtable<>();
		for(int i=0;i<arrA.length;i++){
			if(h.containsKey(arrA[i])){
				int count = h.get(arrA[i]);
				count++;
				h.put(arrA[i], count);
			}else{
				h.put(arrA[i], 1);
			}
		}
		for(int i=0;i<arrB.length;i++){
			if(h.containsKey(arrB[i])){
				int count  = h.get(arrB[i]);
				while(count>0){
					arrA[++resIndex] = arrB[i];
					count--;
				}
				h.remove(arrB[i]);
			}
		}		
		ArrayList<Integer> al = new ArrayList<Integer>();
		Set<Integer> keys = h.keySet();
		for(Integer x:keys){
			al.add(x);
		}
		Collections.sort(al);
		Iterator<Integer> it = al.iterator();
		while(it.hasNext()){
			arrA[++resIndex] = it.next();					
		}
		return arrA;
	}
	public void displayArray(int [] b){
		for(int i=0;i<b.length;i++){
			System.out.print(" " + b[i]);
		}
	}
	
	public static void main(String args[]){
		int [] arrA = {2,6,9,1,4,4,2,1,10,13,5,7,8};
		int [] arrB = {1,2,4,6};
		SortArrayDefinedByOtherArray s = new SortArrayDefinedByOtherArray();
		int [] res = s.SortAndSearch(arrA, arrB);
		System.out.print("\n  Output Array using Sort and search: ");
		s.displayArray(res);
		System.out.print("\n  Output Array using Hashing : ");
		int [] res1 = s.usingHashing(arrA, arrB);
		s.displayArray(res1);
	}

}
