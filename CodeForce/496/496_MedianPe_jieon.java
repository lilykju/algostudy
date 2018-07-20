package e;

import java.util.HashMap;
import java.util.Scanner;

public class R496_MedianPe {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		HashMap<Integer,Integer> map=new HashMap<>();
		int p=0,l=0, h=0;
		long ans=0;
		boolean flag=false;
		map.put(0, 1);
		for(int i=0;i<n;i++) {
			p=in.nextInt();
			if(p<m) l++;
			else if(p>m) h++;
			else flag=true;

			int gap=h-l;
			
			if(flag) {
				if(map.containsKey(gap)) {
					ans+=map.get(gap);
				}
				if(map.containsKey(gap-1)) {
					ans+=map.get(gap-1);
				}
				//System.out.println(i+" "+gap+" : "+map.get(gap)+", "+map.get(gap-1));
			}else {
				if(map.containsKey(gap)) map.replace(gap, map.get(gap)+1);
				else map.put(gap, 1);
			}
		}

		System.out.println(ans);
		in.close();
	}
}
