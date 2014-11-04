package newInterviewQuestions;

import java.util.Stack;

public class InfixToPostFix {

	private boolean blnoperatorAdded;
	public boolean blnNegativeNo = false;
	public boolean blnIsPrevParan = false;
	public Stack lnksck;
	public String output = "";

	public String convert(String input) {
		lnksck = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char chr = input.charAt(i);
			switch (chr) {
			case '+':
				decide(chr, 1);
				break;
			case '-':
				if (blnIsPrevParan) {
					blnNegativeNo = true;
				}
				if (!blnNegativeNo) {
					decide(chr, 1);
				}
				blnIsPrevParan = false;
				break;
			case '*':
				decide(chr, 3);
				blnIsPrevParan = false;
				break;
			case '/':
			case '%':
				decide(chr, 4);
				blnIsPrevParan = false;
				break;
			case '^':
				decide(chr, 5);
				blnIsPrevParan = false;
				break;
			case 'r':
				decide(chr, 6);
				blnIsPrevParan = false;
				break;
			case '(':
				lnksck.push(chr);
				blnIsPrevParan = true;
				break;
			case ')':
				closeParn(chr);
				break;
			default:// must be number
				blnIsPrevParan = false;
				if (blnoperatorAdded == true) {
					output = output + " " + chr;
					blnoperatorAdded = false;
				} else {
					output = output + chr;
				}
				break;
			}
		}
		while (!lnksck.isEmpty()) {
			output = output + " " + lnksck.pop();
		}
		// System.out.println("Post Fix Equation: " + output);
		return output;
	}

	public void closeParn(char c) {
		while (!lnksck.isEmpty()) {
			char ct = (char) lnksck.pop();
			if (ct == '(') {
				break;
			} else {
				output = output + " " + ct;
			}
		}
	}

	public void decide(char chr, int NewPrec) {
		boolean blnInsert = true;
		while (!lnksck.isEmpty()) {
			char topChr = (char) lnksck.pop();
			if (topChr == '(') {
				lnksck.push(topChr);// if ( is poped out, push it back
				if (NewPrec == '-') {
					blnNegativeNo = true;
					blnInsert = false;
				}
				break;
			} else {
				int topPrec;
				if (topChr == '-') {
					topPrec = 1;
				} else if (topChr == '+') {
					topPrec = 1;
				} else if (topChr == '*') {
					topPrec = 3;
				} else if (topChr == '/' || topChr == '%') {
					topPrec = 5;
				} else {
					topPrec = 6;
				}
				if (topPrec < NewPrec) {
					lnksck.push(topChr);
					break;
				} else {
					output = output + " " + topChr;
				}
			}
		}
		if (blnInsert) {
			lnksck.push(chr);
			blnoperatorAdded = true;
		}
	}

	public static void main(String args[]) {
		InfixToPostFix i = new InfixToPostFix();
		String input = "A*(B+C)/D";
		System.out.println("Infix Expression " + input);
		String x = i.convert(input);
		System.out.println("Postfix Expression " + x);
	}
}
