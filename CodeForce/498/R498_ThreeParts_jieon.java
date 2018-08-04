package c;

import java.util.Scanner;

public class R498_ThreeParts {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=in.nextInt();
		}
		long sum1=0,sum3=0,answer=0;
		int idx1=0,idx3=n-1;
		while(idx1<=idx3) {
			if(sum1<=sum3) {
				sum1+=arr[idx1];
				idx1++;
			}else {
				sum3+=arr[idx3];
				idx3--;
			}
			if(sum1==sum3) answer=sum1;
		}
		System.out.println(answer);
		in.close();
	}
}
