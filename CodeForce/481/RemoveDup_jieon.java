package a;

import java.util.ArrayList;
import java.util.Scanner;

public class R481_RemoveDup {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		ArrayList<Integer> answer=new ArrayList<>();
		for(int i=n-1;i>=0;i--) {
			if(!answer.contains(a[i]))
				answer.add(a[i]);
		}
		System.out.println(answer.size());
		for(int i=answer.size()-1;i>=0;i--) {
			System.out.print(answer.get(i)+" ");
		}
		in.close();
	}
}
