package Dynamic;

import java.util.Scanner;

public class poly {

	static final int LI = 10000000;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		while (test_case-- > 0) {
			int n = in.nextInt();
			int[][] d = new int[n + 1][n + 1];
			int answer=1;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j < i; j++) {
					d[i][j] = 0;
					for (int k = 1; k <= i - j; k++) {
						d[i][j]+=(d[i-j][k]*(j+k-1))%LI;
						d[i][j]%=LI;
					}
					if(i==n) answer=(answer+d[i][j])%LI;
				}
				d[i][i] = 1;
			}
			System.out.println(answer);
		}
		in.close();
	}
}
