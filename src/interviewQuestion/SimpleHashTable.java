package interviewQuestion;

import java.util.Hashtable;

public class SimpleHashTable {
	
	int [] a = new int[5];
	
	String [] arrNames = new String[]{"Sumit","Jain","Raghav","Garg","Gaurav","Rishi"};
	
	
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
	
	public void insertValues(){
		for(int i=0;i<arrNames.length;i++ ){
			ht.put(i+1,arrNames[i]);
		}
	}
	
	public String getValue(int key){
		return ht.get(key);
	}
	public static void main (String [] args){
		SimpleHashTable sht = new SimpleHashTable();
		sht.insertValues();
		System.out.println("All values inserted");
		System.out.println("Employee with ID 1 is "+ sht.getValue(1));
		System.out.println("Employee with ID 3 is "+ sht.getValue(6));
	}
}
