package Dynamic;

import java.util.Scanner;

public class numb3rs {
	
	static int n,p,d;
	static boolean[][] city;
	static int[] nums;
	static double[][] result;
	
	static double go(int from,int days) {
		if(days==0) return (from==p ? 1.0 : 0.0);
		if(result[from][days]!=0) return result[from][days];
		for(int to=0;to<n;to++) {
			if(city[from][to]) {
				result[from][days]+= go(to,days-1)/nums[to];
			}
		}
		return result[from][days];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		while (test_case-- > 0) {
			n=in.nextInt();
			d=in.nextInt();
			p=in.nextInt();
			city=new boolean[n][n];
			nums=new int[n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					city[i][j]=(in.nextInt()==1);
					if(city[i][j]) nums[i]++;
				}
			}
			result=new double[n][d+1];
			int t=in.nextInt();
			while(t-->0) {
				System.out.print(go(in.nextInt(),d)+" ");
			}
			System.out.println();
		}
		in.close();
	}
}
