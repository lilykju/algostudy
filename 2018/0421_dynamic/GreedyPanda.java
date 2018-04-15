package dynamic;

import java.util.Scanner;

public class GreedyPanda {

	static int n;
	static int[][] boo;
	static int[][] d;
	static int[] kx = { 0, 0, 1, -1 };
	static int[] ky = { 1, -1, 0, 0 };

	static int go(int x, int y) {
		if (d[x][y] != 0)
			return d[x][y];
		int life = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + kx[i];
			int ny = y + ky[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (boo[x][y] < boo[nx][ny])
					life = Math.max(life,go(nx,ny)+1);
				
			}
		}
		return d[x][y] = life;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		boo = new int[n][n];
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boo[i][j] = in.nextInt();
			}
		}
		int max = 0;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				max = Math.max(max, go(x,y));
			}
		}
		System.out.println(max);
		in.close();
	}
}
