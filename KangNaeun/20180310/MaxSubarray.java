package dynamic;

import java.util.Scanner;

public class MaxSubarray {
	
	static int maxSubarray(int[] arr) {
		
		int n=arr.length;
		int[] d = new int[n];
		//d[i]= i번째까지 최댓값
		d[0]=arr[0];
		int subarray=d[0];
		for(int i=1;i<n;i++) {
			d[i]=arr[i];
			if(d[i-1]>0) d[i] += d[i-1];
			if(subarray<d[i]) subarray = d[i];
		}
		
		return subarray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            int subsequence=0;
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
                if(arr[arr_i]>0) subsequence+=arr[arr_i];
            }
            int result = maxSubarray(arr);
            if(subsequence <= 0) {
            	subsequence = result;
            }
            System.out.println(result+" "+subsequence);

        }
        in.close();
    }
}
