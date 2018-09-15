package c;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class R506_MaximalIntersection {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] segment=new int[n][2];
		PriorityQueue<Integer> pqS=new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a,Integer b) {
				return Integer.compare(segment[b][0], segment[a][0]);
			}
		});
		PriorityQueue<Integer> pqE=new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a,Integer b) {
				return Integer.compare(segment[a][1], segment[b][1]);
			}
		});
		for(int i=0;i<n;i++) {
			segment[i][0]=in.nextInt();
			segment[i][1]=in.nextInt();
			pqS.add(i);
			pqE.add(i);
		}
		in.close();
		
		int firstS=pqS.poll();
		int secondS=pqS.poll();
		int firstE=pqE.poll();
		int secondE=pqE.poll();
		int answer=0;
		if(firstS==firstE) answer=segment[secondE][1]-segment[secondS][0];
		else answer=Math.max(segment[firstE][1]-segment[secondS][0], segment[secondE][1]-segment[firstS][0]);
		if(answer<0) answer=0;
		System.out.println(answer);
		
	}

}
