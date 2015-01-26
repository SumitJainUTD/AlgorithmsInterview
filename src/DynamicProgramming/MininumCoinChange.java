package DynamicProgramming;

import java.util.Arrays;

// here the objective is to find the minimum number of coins required
//to make change of any amount
//Example : Amount 5, coins avaailable
//there are many possiblilties like {1,1,1,1,1},{2,2,1}, {3,2}
//OUr answer is {3,2} = 2 coins

public class MininumCoinChange {
	public int CCDyna(int[] coins, int amount) {
		int[] CC = new int[coins.length]; // resets for every smaller problems
											// and minimum in it is optimal
											// solution for smaller problem.
		int[] MinAmt = new int[amount + 1]; // stores the optimal results for
											// smaller problems.
		MinAmt[0] = 0; // for amount 0, need 0 coins.

		for (int amt = 1; amt <= amount; amt++) {
			for (int i = 0; i < CC.length; i++) {
				CC[i] = -1;
			}
			for (int i = 0; i < CC.length; i++) {
				if (coins[i] <= amt) { // check if coin value is less than
										// amount needed.
					if (MinAmt[amt - coins[i]] < 0) { // check if no optimal
														// solution available
														// for the (amount-coin
														// value).
						CC[i] = -1;
					} else {
						CC[i] = MinAmt[amt - coins[i]] + 1; // if available,
															// select the coin
															// and add 1 to
															// solution of
															// (amount-coin
															// value)
					}
				}
			}			
			MinAmt[amt] = -1;
			for (int i = 0; i < CC.length; i++) {
				if (CC[i] >= 0) {
					if (MinAmt[amt] == -1 || MinAmt[amt] > CC[i]) {
						MinAmt[amt] = CC[i];
					}
				}
			}
		}
//		System.out.println(Arrays.toString(CC));
//		System.out.println(Arrays.toString(MinAmt));
		return MinAmt[amount];
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] coins = { 1, 2, 3 };
		int amount = 5;
		MininumCoinChange i = new MininumCoinChange();
		System.out.println("Minimum no of coins are required to make amount "
				+ amount + " is : " + i.CCDyna(coins, amount));
	}
}