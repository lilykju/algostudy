package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Nerd2 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n=Integer.parseInt(br.readLine());

			TreeMap<Integer,Integer> map = new TreeMap<>();
			int answer=0;

			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int p=Integer.parseInt(st.nextToken());
				int q=Integer.parseInt(st.nextToken());

				Entry<Integer, Integer> entry=map.higherEntry(p);
				if(entry==null||entry.getValue()<q){
					map.put(p, q);
					entry=map.lowerEntry(p);
					while(entry!=null) {
						if(entry.getValue()>q) break;
						map.remove(entry.getKey());
						entry=map.lowerEntry(p);
					}
				}
				answer+=map.size();
			}
			
			System.out.println(answer);
		}
	}
}
