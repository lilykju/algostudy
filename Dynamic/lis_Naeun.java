package Dynamic;

import java.util.Scanner;

public class lis {

	static int dynamicLIS(int[] seq,int[] d, int x) {
		if(d[x]!=0) return d[x];
		
		int max=0;
		for(int i=x+1;i<seq.length;i++) {
			int temp=dynamicLIS(seq, d, i);
			max=Math.max(temp, max);
		}
		return d[x]=max+1;
	}
	
	static int LIS(int n, int[] seq) {
		int[] c=new int[n];
		int max=-1;
		for(int i=0;i<n;i++) {
			int index=biSearch(c,0,max,seq[i]);
			if(index==max) max++;
			c[++index]=seq[i];
		}
		return max+1;
	}
	
	static int biSearch(int[] c,int low,int high, int x) {
		if(high<low) return high;
		int mid= (low+high)/2;
		if(x==c[mid]) return mid-1;
		if(x>c[mid]) return biSearch(c, mid+1,high, x);
		else return biSearch(c,low,mid-1,x);
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			int[] seq=new int[n];
			for(int i=0;i<n;i++) {
				seq[i]=in.nextInt();
			}
			
			System.out.println(LIS(n,seq));
			
			
		}
		in.close();
	}
}
