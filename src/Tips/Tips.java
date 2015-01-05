package Tips;

public class Tips {

	public static float[] sort(float a, float b, float c){
		float [] arrA = new float[3];
		arrA[0]=Math.max(Math.max(a, b),c);
		arrA[1]=Math.min(Math.max(a, b),c);
		arrA[2]=Math.min(Math.min(a, b),c);
		return arrA;
	}	
	public static void main(String args[]){
		char[] x = {'s','u','m','i','t'};
		String a = new String(x);
		System.out.println(a);
		
		String b = String.valueOf(x);
		System.out.println(a);
		float [] y = Tips.sort(1.1f, 4.7f, 9.2f);
		for(int i =0;i<y.length;i++){
			System.out.print(" " + y[i]);
		}
	}
}
