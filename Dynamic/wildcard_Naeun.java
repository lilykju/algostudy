package Dynamic;

import java.util.PriorityQueue;
import java.util.Scanner;

public class wildcard {
	
	static int[][] d;
	
	static int match(String pattern, String filename, int p, int f) {
		
		
		if(filename.length()<f) return -1;
		if(d[p][f]!=0) return d[p][f];
		if(pattern.length()==p) return d[p][f] =(filename.length()==f) ? 1: -1;
		
		char c = pattern.charAt(p);
		if((filename.length()>f)&&(c=='?'||c==filename.charAt(f))) return match(pattern, filename, p+1, f+1);
		if(c=='*') {
			//!!!!!!!
			if(match(pattern, filename, p+1,f)==1||match(pattern,filename, p, f+1)==1)
				return d[p][f]=1;
		}
		
		return d[p][f]=-1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		in.nextLine();
		while(t-->0) {
			String pattern=in.nextLine();
			int n= in.nextInt();
			in.nextLine();
			String[] filename = new String[n];
			for(int i=0;i<n;i++) {
				filename[i]=in.nextLine();
			}
			
			PriorityQueue<String> pq= new PriorityQueue<>();
			for(int i=0;i<n;i++) {
				d=new int[pattern.length()+1][filename[i].length()+1];
				if(match(pattern, filename[i],0,0)==1) 
					pq.add(filename[i]);
			}
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
		}
		in.close();
	}
}
