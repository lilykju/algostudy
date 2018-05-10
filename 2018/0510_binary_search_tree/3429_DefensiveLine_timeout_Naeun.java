package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.TreeMap;

public class N3429_DefensiveLine {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n=Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tree=new TreeMap<>();
			int[] h=new int[n];
			int[] e=new int[n];
			int[] s=new int[n];
			int f=0,num=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				h[i]=Integer.parseInt(st.nextToken());
				tree.put(h[i], i);
				if(i!=0&&h[i-1]>=h[i]) {
					for(int k=i;k>=f;k--) {
						s[k]=num-e[k]+1;
					}
					f=i;
					num=0;
				}
				e[i]=++num;
			}
			for(int k=n-1;k>=f;k--) {
				s[k]=num-e[k]+1;
			}
			
			long max=0;
			for(int i=0;i<n-1;i++) {
				Entry<Integer,Integer> en=tree.higherEntry(h[i]);
				if(en!=null) {
					while(en!=null) {
						if(max<e[i]+s[en.getValue()])
							max=e[i]+s[en.getValue()];
						en=tree.higherEntry(en.getKey());
					}
				}
				tree.remove(h[i]);
			}
			System.out.println(max);
			
		}
	}
}
