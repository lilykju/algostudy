package dynamic;

import java.util.Scanner;

public class Soccer {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		double a=in.nextInt()/100.0;
		double b=in.nextInt()/100.0;
		int[] cs= {2,3,5,7,11,13,17};
		int[] k= {2,3,5,7,7,5,1};
		int[] d=new int[8];
		d[0]=1;
		for(int i=1;i<8;i++) {
			d[i]=d[i-1]*(19-i)/i;
		}
		double A=0;
		double B=0;
		for(int i=0;i<7;i++) {
			A+= d[k[i]]*Math.pow(a, cs[i])*Math.pow(1-a, 18-cs[i]);
		}
		for(int i=0;i<7;i++) {
			B+= d[k[i]]*Math.pow(b, cs[i])*Math.pow(1-b, 18-cs[i]);
		}
		System.out.println(A+B-A*B);
		in.close();
	}
}
