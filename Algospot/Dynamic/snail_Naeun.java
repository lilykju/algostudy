package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class snail {
	static int n,m;
	static double[][] d;
	
	static double climb(int days, int climbed) {
		if(climbed >= n) return 1;
		if(days == m) return 0;
		if(d[days][climbed]!=2) return d[days][climbed];
		return d[days][climbed]=0.75*climb(days+1,climbed+2)+0.25*climb(days+1,climbed+1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		while (test_case-- > 0) {
			n=in.nextInt();
			m=in.nextInt();
			d=new double[m][n+1];
			for(int i=0;i<m;i++) {
				Arrays.fill(d[i], 2);
			}
			
			System.out.println((double)climb(0,0));
		}
		in.close();
	}
}
