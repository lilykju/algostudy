package Stock_Maximize;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stock_Maximize {

	static int stockmax(int[] prices) {
		// Complete this function
		return 0;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int predicted_price_arr = input.nextInt();
		for(int a0 = 0; a0 < predicted_price_arr; a0++){
			int n = input.nextInt();
			int[] prices = new int[n];
			for(int prices_i = 0; prices_i < n; prices_i++){
				prices[prices_i] = input.nextInt();
			}
			int result = stockmax(prices);
			System.out.println(result);
		}
		input.close();
	}


}
