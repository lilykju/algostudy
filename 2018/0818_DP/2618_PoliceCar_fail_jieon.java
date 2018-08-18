package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N2618_PoliceCar {
	
	static int n,w;
	static int[] x,y;
	static int[][] d;
	
	static int move(int a,int b) {
		int caseNum=Math.max(a,b)+1;
		if(caseNum==w+2) return 0;
		int ret=d[a][b];
		if(ret!=-1)return ret;
		ret=0;
		int ret1=move(caseNum,b)+Math.abs(x[caseNum]-x[a])+Math.abs(y[caseNum]-y[a]);
		int ret2=move(a,caseNum)+Math.abs(x[caseNum]-x[b])+Math.abs(y[caseNum]-y[b]);
		int as;
		if(ret1>ret2) {
			ret=ret2;
			as=2;
		}else {
			ret=ret1;
			as=1;
		}
		
		return d[a][b]=ret;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		w=in.nextInt();
		x=new int[w+2];
		y=new int[w+2];
		
		for(int i=2;i<w+2;i++) {
			x[i]=in.nextInt();
			y[i]=in.nextInt();
		}
		x[0]=y[0]=1;
		x[1]=y[1]=n;
		d= new int[w+2][w+2];
		for(int i=0;i<w+2;i++)
			Arrays.fill(d[i], -1);
		
		System.out.println(move(0,1));
		
		in.close();
	}
}
