package newInterviewQuestions;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class PermutationStrings {
	
	public boolean isPermutation(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		Hashtable<Character , Integer> ht = new Hashtable<>();
		for(int i=0;i<s1.length();i++){
			char c = s1.charAt(i);
			if(ht.containsKey(c)){	
				int val = ht.get(c) +1;
				ht.put(c, val);
			}else{
				ht.put(c, 1);
			}
		}
		for(int i=0;i<s2.length();i++){
			char c = s2.charAt(i);
			if(ht.containsKey(c)){
				int val = ht.get(c);
				if(val==0){
					return false;
				}
				val--;
				ht.put(c, val);
			}else{
				return false;
			}
		}
		Set<Character> keys = ht.keySet();
		for(Character k :keys ){
			if(ht.get(k)!=0){
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]){
		String s1 = "sumit";
		String s2 = "mtisu";
		PermutationStrings p = new PermutationStrings();
		System.out.println(s1 +" and "+ s2 + " are permutation of each other? " + p.isPermutation(s1, s2));
		s1 = "xyzab";
		s2 = "bayzxx";
		System.out.println(s1 +" and "+ s2 + " are permutation of each other? " + p.isPermutation(s1, s2));
	}

}
