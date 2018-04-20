package Dynamic;

import java.util.Scanner;

public class tiling2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int A=1000000007;
		int test_case=in.nextInt();
		while(test_case-->0) {
			int n=in.nextInt();
			int[] d=new int[n+1];
			
			d[0]=1;
			d[1]=1;
			for(int i=2;i<=n;i++) {
				d[i]=(d[i-1]%A+d[i-2]%A)%A;
			}
			System.out.println(d[n]);
		}
		in.close();
	}
}
