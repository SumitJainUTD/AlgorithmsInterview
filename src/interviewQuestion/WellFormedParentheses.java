package interviewQuestion;

public class WellFormedParentheses {

	public Boolean isWellFormed(String strParentheses) {
		if (strParentheses == null) {
			return false;
		}
		// Idea is to have two counters, one for open parentheses '{' and one
		// for close '}'
		// Read one character at a time and increment one of the counters
		// If any given point of time count of close parentheses is greater than
		// the open one, return false
		// If at the end both counters are equal, return true
		int openParenCounter = 0;
		int closeParenCounter = 0;
		for (int i = 0; i < strParentheses.length(); i++) {
			char x = strParentheses.charAt(i);
			if (x == '{')
				openParenCounter++;
			else if (x == '}')
				closeParenCounter++;

			if (closeParenCounter > openParenCounter) {
				return false;
			}
		}
		if (openParenCounter == closeParenCounter)
			return true;
		else
			return false;

	}

	public static void main(String args[]) {
		String x1 = "{{{{}}}}{}{}{}{}{}{}{}{}{}{}{{{}}}";
		String x2 = "{{{{}}}}{}{}{}{{}{}{}{}{}{}{}{{{}}}";
		String x3 = "{}{";
		String x4 = "}{";
		String x5 = "{{{{{{{{}}}}}}}}";
		WellFormedParentheses w = new WellFormedParentheses();
		System.out.println("Is " + x1 + " well formed ??? :"
				+ w.isWellFormed(x1));
		System.out.println("Is " + x2 + " well formed ??? :"
				+ w.isWellFormed(x2));
		System.out.println("Is " + x3 + " well formed ??? :"
				+ w.isWellFormed(x3));
		System.out.println("Is " + x4 + " well formed ??? :"
				+ w.isWellFormed(x4));
		System.out.println("Is " + x5 + " well formed ??? :"
				+ w.isWellFormed(x5));

	}
}
