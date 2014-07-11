package interviewQuestion;

import com.sun.org.apache.xml.internal.security.utils.JavaUtils;

//This Program is to find out whether String contains all the unique characters 
//With out using any additional data structures
public class UniqueCharString {
	private String ip;
	
	
	public UniqueCharString(String ip){
		this.ip = ip;
	}
	
	//method 1 : When characters are not ASCII but could be anything alphabets or special characters
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	
	public Boolean UniChars(){
		Boolean [] bln = new Boolean[256];
		for(int i=0;i<256;i++){
			bln[i]=false;
		}
		for(int i = 0;i<ip.length();i++){
			char a = ip.charAt(i);
			if(bln[a]==true){
				return false;
			}
			else{
				bln[a]=true;
			}
		}
		
		
		return true;
	}
	
	//method 2: Sort the array and do the linear scan to find out whether string 
	//contains unique elements or not
	//Time Complexity : O(nLogn)
	//Space Complexity : O(n)
	
	public Boolean UniqueCharSorting(){
		char [] a = ip.toCharArray();
		java.util.Arrays.sort(a);
		String tmp = new String(a);
		for(int i=1;i<tmp.length();i++){
			char t = tmp.charAt(i-1);
			if(t==tmp.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		String a = "Sumit_Jain";
		UniqueCharString u = new UniqueCharString(a);
		System.out.println("Method 1 : Does String ' " + a +" ' has all unique characters :" + u.UniChars());
		
		a = "Sumit";
		u = new UniqueCharString(a);
		System.out.println("Method 1 : Does String ' " + a +" ' has all unique characters :" + u.UniChars());
		
		a = "Sumit_Jain";
		u = new UniqueCharString(a);
		System.out.println("Method 2 : Does String ' " + a +" ' has all unique characters :" + u.UniqueCharSorting());
		
		a = "Sumit";
		u = new UniqueCharString(a);
		System.out.println("Method 2 : Does String ' " + a +" ' has all unique characters :" + u.UniqueCharSorting());
	}

}
