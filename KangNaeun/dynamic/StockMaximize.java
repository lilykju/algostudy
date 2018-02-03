package dynamic;

import java.util.Scanner;
import java.util.ArrayList;


/*
 * 시간복잡도 : O(n)
 * 
 * 가격이 가장 높을 때 앞의 전부를 팔 때 이득이 최대가 된다.
 * 
 * max : 이득의 최댓값  
 * sell: (뒤에서 부터 )가장 높은 가격
 * 
 * prices를 뒤에서 부터 확인하며 sell 값보다 가격이 높을 경우 sell값을 변경하고,
 * 같을 경우는 continue;
 * 낮을 경우에 sell에서 해당 가격의 차를 max에 더한다.
 * 
 */

public class StockMaximize {
	
	static long stockmax(int[] prices) {   
	 	int l = prices.length;
	 	long max=0;
		int sell=0;
        for(int i=l-1;i>=0;i--) {
        	if(sell<prices[i]) {
        		sell = prices[i];
        	}else if(sell>prices[i]) {
        		max += sell - prices[i];
        	}
        }
        return max; 	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] prices = new int[n];
            for(int prices_i = 0; prices_i < n; prices_i++){
                prices[prices_i] = in.nextInt();
            }
            System.out.println(stockmax(prices));
        }
        in.close();
    }
}
