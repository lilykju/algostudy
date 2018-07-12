package c;

import java.util.Scanner;

public class R494_IntenseHeat {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[] t=new int[n];
		for(int i=0;i<n;i++)
			t[i]=in.nextInt();
		
		double answer=0;
		for(int i=-1;i+k<n;i++) {
			double sum=0;
			for(int j=1;j<k;j++) sum+=t[i+j];
			for(int m=i+k;m<n;m++) {
				sum+=t[m];
				answer=Math.max(answer, sum/(m-i));
			}
		}
		
		System.out.println(answer);
		in.close();
	}
}
