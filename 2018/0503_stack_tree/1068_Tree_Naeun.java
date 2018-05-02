package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class N1068_Tree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> leaf = new ArrayList<>();
		int[] p = new int[n];
		for (int i=0; i<n; i++) {
			leaf.add(i);
			p[i] = in.nextInt();
		}
		int xx = in.nextInt();
		int count = 0;
		if (p[xx] != -1) {
			int c=0;
			for (int i = 0; i < n; i++) {
				if (leaf.contains(p[i])) {
					leaf.remove((Integer) p[i]);
				}
				if (p[xx] == p[i])
					c++;
			}
			count = leaf.size()+((c==1)?1:0);

			for (int l : leaf) {
				while (l != xx && l != -1) {
					l = p[l];
				}
				if (l == xx)
					count--;
			}
		}
		System.out.println(count);
		in.close();
	
	}
}
