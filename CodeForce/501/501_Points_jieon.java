package a;

import java.util.ArrayList;
import java.util.Scanner;

public class R501_Points {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=1;i<=m;i++)
			a.add(i);
		for(int i=0;i<n;i++) {
			int s=in.nextInt();
			int e=in.nextInt();
			for(int j=s;j<=e;j++)
				a.remove((Integer)j);
		}
		System.out.println(a.size());
		for(int k : a)
			System.out.print(k+" ");
		
		in.close();
	}
}
