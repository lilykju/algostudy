package a;

import java.util.ArrayList;
import java.util.Scanner;

public class R496_Stariway {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int now=0,before=0;
		int num=0;
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<n;i++) {
			now=in.nextInt();
			if(now>before) num++;
			else {
				a.add(num);
				num=1;
			}
			before=now;
		}
		a.add(num);
		System.out.println(a.size());
		for(int x : a) System.out.print(x+" ");
		in.close();
	}
}
