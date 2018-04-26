package BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class picnic {
	
	static int match(boolean[] matched, List<Integer>[] friend, int left) {
		if(left==0) return 1;
		
		int count=0;
		
		for(int i=0;i<friend.length;i++) {
			if(!matched[i]) {
				matched[i]=true;
				for(int j :friend[i]) {
					if(matched[j]) continue;
					matched[j]=true;
					count += match(matched, friend, left-2);
					matched[j]=false;
					
				}
				matched[i]=false;
				break;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int n=in.nextInt();
			int m=in.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] friend=(List<Integer>[])new List[n];
			for(int i=0;i<n;i++) {
				friend[i] =new ArrayList<Integer>();
			}
			for(int i=0;i<m;i++) {
				int a=in.nextInt();
				int b=in.nextInt();
				friend[a].add(b);
				friend[b].add(a);
			}
			boolean[] matched = new boolean[n];
			System.out.println(match(matched,friend,n));
			
		}
		in.close();
	}
}
