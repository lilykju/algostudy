package dynamic;

import java.util.Scanner;

public class MergeFile {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] sum=new int[n+1];
			int[][] d=new int[n+1][n+1];
			for(int i=1;i<=n;i++){
				d[i][i]=sc.nextInt();
				sum[i]=sum[i-1]+d[i][i];
			}
			for(int k=1;k<n;k++){
				for(int i=1;i<=n-k;i++){
					for(int j=i;j<i+k;j++){
						int temp=d[i][j]+d[j+1][i+k];
						if(i==j) temp-=d[i][j];
						if(j+1==i+k) temp-=d[j+1][i+k];
						if(d[i][i+k]==0||d[i][i+k]>temp) d[i][i+k]=temp;
					}
					d[i][i+k]+=sum[i+k]-sum[i-1];
				}
			}		
			System.out.println(d[1][n]);
		}
		sc.close();
	}
}
