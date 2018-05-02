package tree;

import java.util.Scanner;

public class Traversal {
	
	static int[] preO, inO;
	
	static void postOrder(int ps, int pe, int is, int ie) {
		if(is>ie) return;
		
		int root=preO[ps];
		int ii=is;
		for(;ii<=ie;ii++) {
			if(inO[ii]==root) break;
		}
		int size=ii-is;
		
		postOrder(ps+1,ps+size,is,ii-1);
		postOrder(ps+size+1,pe,ii+1,ie);
		System.out.print(root+" ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n=in.nextInt();
			preO = new int[n];
			inO = new int[n];
			for(int i=0;i<n;i++) {
				preO[i]=in.nextInt();
			}
			for(int i=0;i<n;i++) {
				inO[i]=in.nextInt();
			}
			postOrder(0,n-1,0,n-1);
			System.out.println();
		}
		in.close();
	}
}
