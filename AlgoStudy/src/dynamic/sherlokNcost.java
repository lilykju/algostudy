package dynamic;

import java.util.Scanner;
import java.util.Arrays;

public class sherlokNcost {
	
	//시간복잡도 : O(n)
	//공간복잡도 : O(n)
	//d[i][j] i번째까지 j->0:그대로, 1:1로 바꾸었을 때 비용의 최댓값
	 static int cost(int[] arr) {
		 if(arr.length==1) return 0;
		 int[][] d=new int[arr.length][2];
		 d[0][0]=0;
		 d[0][1]=0;
		 for(int i=1;i<arr.length;i++) {
			 d[i][0]=Math.max(d[i-1][0]+Math.abs(arr[i]-arr[i-1]), d[i-1][1]+Math.abs(arr[i]-1));
			 d[i][1]=Math.max(d[i-1][0]+Math.abs(1-arr[i-1]), d[i-1][1]);
		 }
	 
		 return Math.max(d[arr.length-1][0], d[arr.length-1][1]);
	 }

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int[] arr = new int[n];
	            for(int arr_i = 0; arr_i < n; arr_i++){
	                arr[arr_i] = in.nextInt();
	            }
	            int result = cost(arr);
	            System.out.println(result);
	        }
	        in.close();
	 }
}
