package search;

import java.util.Arrays;
import java.util.Scanner;

public class N2217_rope {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int[] rope=new int[n];
		for(int i=0;i<n;i++)
			rope[i]=in.nextInt();
		Arrays.sort(rope);
		
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(max, rope[i]*(n-i));
		}
		System.out.println(max);
		in.close();
	}
}
