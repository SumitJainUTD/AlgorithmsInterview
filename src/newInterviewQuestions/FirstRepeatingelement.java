package newInterviewQuestions;

import java.util.HashSet;

public class FirstRepeatingelement {
	public int find(int [] arrA){
		int index = -1;
		HashSet<Integer> hs = new HashSet<>();
		for(int i = arrA.length-1;i>=0;i--){
			if(hs.contains(arrA[i])){
				index = i;
			}else{
				hs.add(arrA[i]);
			}
		}
		return arrA[index];
	}
	public static void main(String args[]){
		int [] a = {1,2,5,7,5,3,10,2};
		FirstRepeatingelement f = new FirstRepeatingelement();
		System.out.println("{1,2,5,7,5,3,10,2}");
		System.out.println("first repeated element by index is : " + f.find(a));
	}
}
