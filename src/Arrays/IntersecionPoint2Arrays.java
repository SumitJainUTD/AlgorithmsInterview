package Arrays;

public class IntersecionPoint2Arrays {
	int intersectionPoint = -1;
	int x;
	int y;

	public int intersection(int[] arrA, int[] arrB) {
		while (x < arrA.length && y < arrB.length) {
			if (arrA[x] > arrB[y])
				y++;
			else if (arrA[x] < arrB[y])
				x++;
			else {
				intersectionPoint = arrA[x];
				return intersectionPoint;
			}
		}
		return intersectionPoint;
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] a = { 1,2, 3, 6, 8, 10 };
		int[] b = { 4, 5, 6, 11, 15, 20 };
		IntersecionPoint2Arrays i = new IntersecionPoint2Arrays();
		System.out.println("Intersection point is : " + i.intersection(a, b));

	}
}
