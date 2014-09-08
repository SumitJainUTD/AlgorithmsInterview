package newInterviewQuestions;

public class ReplaceAllSpaces {
	
	public void replace(String s1, int length){
		char [] chars = s1.toCharArray();
		int spaceCount =0;
		for(int i=0;i<length;i++){
			if(chars[i]==' '){
				spaceCount++;
			}
		}
		int newLength = length + 2*spaceCount;
		for(int i=length-1;i>=0;i--){
			if(chars[i]==' '){
				chars[newLength-1]='0';
				chars[newLength-2]='2';
				chars[newLength-3]='%';
				newLength = newLength-3;
			}else{
				chars[newLength-1]=chars[i];
				newLength = newLength-1;
			}
		}
		s1 = String.valueOf(chars);
		System.out.println("Output String : " + s1);
	}
	
	public static void main(String args[]){
		String s1 = "I am Sumit Jain      ";
		int trueLength = 15;	
		System.out.println("Input String : " + s1);
		ReplaceAllSpaces r = new ReplaceAllSpaces();
		r.replace(s1, trueLength);
	}

}
