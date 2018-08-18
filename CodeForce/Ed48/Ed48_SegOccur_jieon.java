package b;

import java.util.Scanner;

public class Ed48_SegOccur {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		StringBuffer s = new StringBuffer(in.next());
		String t = in.next();
		int[] sum = new int[n+1];
		if (n >= m)
			for (int i = 1; i <= n - m + 1; i++) {
				sum[i] = sum[i - 1];
				if (s.substring(i - 1, i + m - 1).equals(t))
					sum[i] += 1;
			}

		for (int i = 0; i < q; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			if (end - start < m - 1)
				System.out.println(0);
			else
				System.out.println((sum[end - m + 1] - sum[start - 1]));
		}

		in.close();
	}
}
