package study;

import java.util.Scanner;

public class N4530 {
	
	static long[] d;
	
	static long get(long x) {
		long ret=0;
		int n=1, r;
		while(x/10!=0||x%10!=0) {
			r=(int) (x%10);
			if(r!=0) {
				if(r<4) ret+=r*d[n-1];
				else ret += (r-1)*d[n-1]+(long)Math.pow(10, n-1);
			}
			x/=10;
			n++;
		}
		return ret;
	}

	public static void main(String[] args) {
		d=new long[13];
		d[1]=1;
		for(int i=2;i<13;i++) {
			d[i]=d[i-1]*9+(long)Math.pow(10, i-1);
		}
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int tk=1;tk<=t;tk++) {
			long start=in.nextLong(), end=in.nextLong();
			long ans = end - start;
			if(start>0) ans-= get(end)-get(start);
			else if(end>0)ans-= get(end)+get(-start)+1;
			else ans-= get(-start)-get(-end);
			System.out.println("#"+tk+" "+ans);
		}
		
		in.close();
	}

}
