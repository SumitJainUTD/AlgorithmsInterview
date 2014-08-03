package interviewQuestion;

public class LongestPrefixSequence {
	private String [] arrA;
	public LongestPrefixSequence(String [] arrA){
		this.arrA = arrA;
	}
	public String findPrefix(){
		int resultLen = arrA[0].length();
		int curr;
		for(int i=1;i<arrA.length;i++){
			curr=0;
			while(curr<resultLen && curr<arrA[i].length() && arrA[0].charAt(curr)==arrA[1].charAt(curr)){
				curr++;
			}
			resultLen = curr;
		}
		return arrA[0].substring(0,resultLen);
	}
	public static void main(String args[]){
		String x = "Sumit Summation Summit Sum";
		String [] arrA = x.split(" ");
		LongestPrefixSequence lp = new LongestPrefixSequence(arrA);
		System.out.println("Original String : " + x);
		System.out.println("Common Prefix is : " + lp.findPrefix());		
	}
}
