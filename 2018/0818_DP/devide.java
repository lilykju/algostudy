import java.util.*;
public class Main {
	static int[][][] d;
	static boolean[][][] c;
	static int[] a;
	static int min=-32786*101;
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		d=new int[n][m+1][2];
		c=new boolean[n][m+1][2];
		int ans=Math.max(dev(n-1,m,0), dev(n-1,m,1));		
		System.out.println(ans);
	}
	static int dev(int n,int m,int in){
		if(m<=0) return 0;
		if(n<0) return min;
		if(c[n][m][in]) return d[n][m][in];
		if((n+2)/2<m){
			d[n][m][in]=min;
			c[n][m][in]=true;
			return min;
		}
		if(in==0){
			int temp1=dev(n-1,m,0);
			int temp2=dev(n-1,m,1);
			d[n][m][in]=Math.max(temp1, temp2);
		}else{
			int temp1=dev(n-1,m,1);
			int temp2=dev(n-1,m-1,0);
			d[n][m][in]=Math.max(temp1, temp2)+a[n];
		}
		c[n][m][in]=true;
		return d[n][m][in];
	}
}
