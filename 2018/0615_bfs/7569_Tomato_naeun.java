package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class loc {
	int h, n, m;

	public loc(int h, int n, int m) {
		this.h = h;
		this.n = n;
		this.m = m;
	}
}

public class N7569_Tomato {

	static int[] kh = { 0, 0, 0, 0, 1, -1 }, kn = { 0, 0, 1, -1, 0, 0 }, km = { 1, -1, 0, 0, 0, 0 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int m = in.nextInt();
		int n = in.nextInt();
		int h = in.nextInt();
		int[][][] box = new int[h][n][m];
		Queue<loc> q = new LinkedList<>();
		int count = 0;
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					box[k][i][j] = in.nextInt();
					if (box[k][i][j] != -1)
						count++;
					if (box[k][i][j] == 1)
						q.add(new loc(k, i, j));

				}
			}
		}

		int day = 0;
		while (!q.isEmpty()) {
			loc p = q.poll();
			count--;
			for (int k = 0; k < 6; k++) {
				int x = p.n + kn[k];
				int y = p.m + km[k];
				int z = p.h + kh[k];
				if (0 <= x && x < n && 0 <= y && y < m && 0 <= z && z < h) {
					if (box[z][x][y] == 0) {
						box[z][x][y] = box[p.h][p.n][p.m] + 1;
						q.add(new loc(z, x, y));
					}
				}
			}
			day = box[p.h][p.n][p.m];
		}
		
		System.out.println((count == 0) ? (day-1) : -1);

		in.close();
	}

}
