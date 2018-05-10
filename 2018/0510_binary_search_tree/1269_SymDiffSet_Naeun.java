package tree;

import java.util.HashSet;
import java.util.Scanner;

public class N1269_SymDiffSet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		HashSet<Integer> A=new HashSet<>();
		int sum=0;
		for(int i=0;i<a;i++) {
			A.add(in.nextInt());
		}
		for(int i=0;i<b;i++) {
			if(A.contains(in.nextInt())) {
				sum++;
			}
		}
		System.out.println((a+b-sum*2));
		in.close();
	}
}
