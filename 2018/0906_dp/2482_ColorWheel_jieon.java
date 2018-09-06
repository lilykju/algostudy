package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class N2482_ColorWheel {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		final int r=1000000003;
		
		int[][] d=new int[k+1][n];

		Arrays.fill(d[0], 1);
		d[1][1]=1;
		
		
		for(int j=1;j<=k;j++) {
			for(int i=2;i<n;i++) {
				if(j>(i+1)/2) continue;
				d[j][i]=(d[j-1][i-2]+d[j][i-1])%r;
				//System.out.println("d["+j+"]["+i+"]="+d[j][i]);
			}
		}

		System.out.println((d[k-1][n-3]+d[k][n-1])%r);
		
		in.close();
	}
}
