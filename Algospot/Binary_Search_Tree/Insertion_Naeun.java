package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Insertion {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n= in.nextInt();
			int[] move=new int[n];
			ArrayList<Integer> a=new ArrayList<>();
			for(int i=0;i<n;i++) {
				move[i]=in.nextInt();
				a.add(n-i);
			}
			int[] answer=new int[n];
			for(int i=n-1;i>=0;i--) 
				answer[i]=a.remove(move[i]);
			
			for(int i=0;i<n;i++)
				System.out.print(answer[i]+" ");
			System.out.println();
		}
		in.close();
	}
}
