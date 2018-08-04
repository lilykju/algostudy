package e;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class R498_Military {
	
	static List<Integer>[] tree;
	static ArrayList<Integer> order;
	static int[] seq,endseq;
	
	static void preOrder(int i) {
		seq[i]=order.size();
		order.add(i);
		for(int k:tree[i]) {
			preOrder(k);
		}
		endseq[i]=order.size()-1;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int q=in.nextInt();
		tree=(List<Integer>[])new List[n+1];
		for(int i=1;i<=n;i++)
			tree[i]=new ArrayList<>();
		for(int i=2;i<=n;i++) {
			tree[in.nextInt()].add(i);
		}
		order=new ArrayList<>();
		seq=new int[n+1];
		endseq=new int[n+1];
		preOrder(1);
		
		for(int i=0;i<q;i++) {
			int x=in.nextInt();
			int t=seq[x]+in.nextInt()-1;
			if(t>=order.size()||t>endseq[x]) {
				System.out.println(-1);
			}else {
				System.out.println(order.get(t));
			}
		}
	
		in.close();
	}
}
