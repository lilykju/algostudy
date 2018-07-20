package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class pr{
	int x,y;
	pr(int a,int b){
		x=a;
		y=b;
	}
}
public class Lan {

	static int INF=987654321;
	static int n;
	static double[][] adj;
	
	static double prim() {
		
		boolean[] check=new boolean[n];
		double ret=0;
		PriorityQueue<pr> pq=new PriorityQueue<>(new Comparator<pr> (){
			public int compare(pr a,pr b) {
				return Double.compare(adj[a.x][a.y], adj[b.x][b.y]);
			}
		});
		for(int i=1;i<n;i++) {
			pq.add(new pr(0,i));
		}
		check[0]=true;
		while(!pq.isEmpty()) {
			pr p=pq.poll();
			if(check[p.y]) continue;
			ret+=adj[p.x][p.y];
			check[p.y]=true;
			for(int i=0;i<n;i++) {
				if(!check[i]) {
					pq.add(new pr(p.y,i));
				}
			}
		}
		
		return ret;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] s=br.readLine().split(" ");
			n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			adj=new double[n][n];
			int[] x=new int[n];
			int[] y=new int[n];
			s=br.readLine().split(" ");
			for(int i=0;i<n;i++) x[i]=Integer.parseInt(s[i]);
			s=br.readLine().split(" ");
			for(int i=0;i<n;i++) y[i]=Integer.parseInt(s[i]);
			
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++) {
					double d=Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j], 2);
					d =Math.sqrt(d);
					adj[i][j]=adj[j][i]=d;
				}

			for(int i=0;i<m;i++) {
				s=br.readLine().split(" ");
				int s0=Integer.parseInt(s[0]);
				int s1=Integer.parseInt(s[1]);
				adj[s0][s1]=adj[s1][s0]=0;
			}
			
			System.out.println(prim());
		}
	}
}
