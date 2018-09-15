package d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class R506_ConcatenatedMultiples {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[] a=new int[n];
		int[] l=new int[n];
		List<HashMap<Integer,Integer>> r=new ArrayList<>();
		for(int i=0;i<11;i++) {
			r.add(new HashMap<Integer,Integer>());
		}
		for(int i=0;i<n;i++) { 
			a[i]=in.nextInt();
			l[i]=(int)(Math.log10(a[i])+1);
			a[i]%=k;
			if(r.get(l[i]).containsKey(a[i])) {
				r.get(l[i]).replace(a[i], r.get(l[i]).get(a[i])+1);
			}else {
				r.get(l[i]).put(a[i], 1);
			}
			
		}
		in.close();
		
		long answer=0;
		for(int i=0;i<n;i++) {
			long m=a[i];
			for(int j=1;j<11;j++) {
				m=m*10%k;
				int rr=(k-(int)m)%k;
				if(r.get(j).containsKey(rr)) {
					answer+=r.get(j).get(rr);
					if(l[i]==j&&a[i]==rr) answer-=1;
				}
			}
		}
		System.out.println(answer);
	}
	
}
