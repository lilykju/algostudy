package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Restore {
	static int k;
	static String[] word;
	static int[][] cache,overlap;
	
	static String reconstruct(int last, int used) {
		if(used == (1<<k)-1) return "";
		for(int next=0;next<k;next++) {
			if((used&(1<<next))!=0) continue;
			int ifUsed = restore(next, used+(1<<next)) + overlap[last][next];
			if(restore(last, used)==ifUsed)
				return (word[next].substring(overlap[last][next])+reconstruct(next, used+(1<<next)));
		}
		//wrong
		return "****oops****";
	}
	
	static int restore(int last, int used) {
		if(used == (1<<k)-1) return 0;
		int ret=cache[last][used];
		if(ret!=-1) return ret;
		ret=0;
		for(int next=0;next<k;next++)
			if((used&(1<<next))==0) {
				int cand = overlap[last][next]+restore(next, used + (1<<next));
				ret = Math.max(ret,cand);
			}
		return cache[last][used]=ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			k=in.nextInt();
			word=new String[k];
			cache=new int[k][1<<k];
			overlap=new int[k][k];
			int max=0;
			for(int i=0;i<k;i++) {
				word[i]=in.next();
				Arrays.fill(cache[i], -1);
				if(word[max].length()<word[i].length()) max=i;
			}
			
			for(int i=0;i<k-1;i++) {
				for(int j=i+1;j<k;j++) {
					int leni=word[i].length();
					int len=Math.min(leni, word[j].length());
					for(int l=len;l>0;l--) 
						if(word[i].substring(leni-l, leni).equals(word[j].substring(0, l))) {
							overlap[i][j]=l;
							break;
						}	
				}
			}
			
			System.out.println(reconstruct(1,0));
		}
		in.close();
	}
	
}
