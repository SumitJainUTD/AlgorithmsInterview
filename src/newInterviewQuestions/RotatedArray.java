package newInterviewQuestions;

public class RotatedArray {
	public boolean isRotated(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		String sAdd = s1 + s1;
		if(sAdd.contains(s2)){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String arg[]){
		String s1 = "sumitjain";
		String s2 = "tjainsumi";
		RotatedArray r = new RotatedArray();
		System.out.println("Is '" + s1 + "' and '" + s2 + "' are rotated?? : " + r.isRotated(s1, s2));
	}

}
