package study;

import java.util.Arrays;
import java.util.Scanner;

public class N1860 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int tk=1;tk<=t;tk++){
			int n=in.nextInt();
			int m=in.nextInt();
			int k=in.nextInt();
			int[] time=new int[n];
			for(int i=0;i<n;i++)
				time[i]=in.nextInt();
			Arrays.sort(time);
			int fish, cust=0;
			boolean poss=true;
			for(int i=0;i<n;i++) {
				fish=(time[i]/m)*k;
				cust++;
				if(cust>fish) {
					poss=false;
					break;
				}
			}
			System.out.println("#"+tk+" "+(poss?"Possible":"Impossible"));
		}
		in.close();
	}

	/*
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int tk=1;tk<=t;tk++){
			int n=in.nextInt();
			int m=in.nextInt();
			int k=in.nextInt();
			int[] time=new int[11111/m +1];
			int max=0;
			for(int i=0;i<n;i++) {
				int a=in.nextInt()/m;
				time[a]++;
				if(a>max) max=a;
			}
			int fish=0;
			boolean poss=true;
			for(int i=0;i<=max;i++) {
				fish -=time[i];
				if(fish<0) {
					poss=false;
					break;
				}
				fish +=k;
			}
			System.out.println("#"+tk+" "+(poss?"Possible":"Impossible"));
		}
		in.close();
	}*/

}
