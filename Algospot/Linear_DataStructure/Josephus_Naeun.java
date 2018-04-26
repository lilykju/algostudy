package Linear;

import java.util.LinkedList;
import java.util.Scanner;

public class Josephus {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int test=in.nextInt();
		while(test-->0) {
			int n=in.nextInt();
			int k=in.nextInt();
			
			LinkedList<Integer> ll=new LinkedList<>();
			int kill=0;
			for(int i=1;i<=n;i++) ll.add(i);
			
			while(n>2) {
				ll.remove(kill);
				--n;
				if(kill==n) {
					kill=0;
				}
				
				for(int i=0;i<k-1;i++) {
					++kill;
					if(kill==n) {
						kill=0;
					}
				}
			}
			System.out.println(ll.get(0)+" "+ll.get(1));
			
		}
		in.close();
	}
}
