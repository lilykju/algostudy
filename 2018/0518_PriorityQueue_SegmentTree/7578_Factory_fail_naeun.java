package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class N7578_Factory {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<n;i++) {
			a.add(in.nextInt());
		}
		int answer=0;
		for(int i=0;i<n;i++) {
			int next=in.nextInt();
			int temp=a.indexOf(next);
			answer+=temp-0;
			a.remove(temp);
		}
		
		System.out.println(answer);
		
		in.close();
	}
}
