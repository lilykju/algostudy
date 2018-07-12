package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class R494_CoinQuery {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] s=br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int j = Integer.parseInt(s[1]);
		TreeMap<Integer,Integer> tm=new TreeMap<>();
		s=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			int c=Integer.parseInt(s[i]);
			if(tm.containsKey(c)) {
				int v=tm.get(c);
				tm.replace(c, v+1);
			}else tm.put(c, 1);
		}

		while(j-->0) {
			int q=Integer.parseInt(br.readLine());
			int ans=0;
			Iterator<Integer> it=tm.descendingKeySet().iterator();
			while(it.hasNext()) {
				int k=it.next();
				if(q>=k) {
					int v=Math.min(q/k, tm.get(k));
					q -= v*k;
					ans += v;
				}
			}
			if(q==0) System.out.println(ans);
			else System.out.println(-1);
		}
	}
}
