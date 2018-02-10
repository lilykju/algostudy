package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Journey2Moon {
	static long journeyToMoon(int n, ArrayList<Integer>[] astronaut) {
		ArrayList<Integer> numbers =new ArrayList<>();//국가당 우주인 수
		boolean[] checkA = new boolean[n];
		
		//시간복잡도 : O(n+p)??
		for(int i=0;i<n;i++) {
			if(checkA[i]) continue;
			
			int temp_num=1;
			
			//bfs
			Queue<Integer> q=new LinkedList<>();
			q.add(i);
			checkA[i]=true;
			while(!q.isEmpty()) {
				int x= q.poll();
				for(int k : astronaut[x]) {
					if(!checkA[k]) {
						q.add(k);
						checkA[k]=true;
						temp_num++;
					}
				}
			}
			numbers.add(temp_num);
		}
		
		long answer=0;
		while(numbers.size()>1) {
			int p=numbers.get(0);
			n -= p;		
			answer += p*n;
			numbers.remove(0);
		}
		System.out.println(n);
		return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        ArrayList<Integer>[] astronaut = (ArrayList<Integer>[]) new ArrayList[n];
        for(int i=0;i<n;i++) {
        	astronaut[i]=new ArrayList<Integer>();
        }
        while(p-->0) {
        	int a=in.nextInt();
        	int b=in.nextInt();
        	astronaut[a].add(b);
        	astronaut[b].add(a);
        }
        
        System.out.println(journeyToMoon(n, astronaut));
        in.close();
    }
}
