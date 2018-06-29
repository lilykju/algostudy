package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1963_PrimePath {
	
	static boolean[] notPrime;
	
	static void getPrime() {
		for(int i=2;i<100;i++) {
			if(notPrime[i]) continue;
			for(int j=1;i*j<10000;j++) {
				notPrime[i*j]=true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		notPrime=new boolean[10000];
		getPrime();
		while(t-->0) {
			//String[] temp=in.next().split("");
			int from=in.nextInt();
			int to=in.nextInt();
			if(from==to) {
				System.out.println(0);
				continue;
			}
			int[] d=new int[10000];
			Arrays.fill(d, -1);
			int answer=-1;
			Queue<Integer> q=new LinkedList<>();
			q.add(from);
			d[from]=0;
			while(!q.isEmpty()) {
				int x=q.poll();
				for(int k=1;k<=1000;k*=10) {
					int temp=x-x%(k*10)+x%k;
					for(int i=0;i<10;i++) {
						if(k==1000&&i==0)continue;
						int y=temp+k*i;
						//System.out.println(y);
						if(!notPrime[y]&&d[y]==-1) {
							d[y]=d[x]+1;
							if(y==to) {
								answer=d[y];
								break;
							}
							q.add(y);
						}	
					}
					if(answer!=-1) break;
				}
				if(answer!=-1) break;
			}
			System.out.println((answer==-1)?"Impossible":answer);
		}
		in.close();
	}
}
