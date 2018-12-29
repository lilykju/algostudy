package sorting;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N1181_words {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
			public int compare(String a, String b) {
				if(a.length()!=b.length()) {
					return Integer.compare(a.length(), b.length());
				}else return a.compareTo(b);
			}
		});
		for(int i=0;i<n;i++) {
			pq.add(in.next());
		}
		String before="";
		while(!pq.isEmpty()) {
			String pr=pq.poll();
			if(!before.equals(pr)) {
				System.out.println(pr);
				before=pr;
			}
		}
		
		in.close();
	}

}
