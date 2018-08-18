package c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class R501_SongsCompression {


	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		PriorityQueue<Integer> diff=new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer one,Integer two) {
				return Integer.compare(two, one);
			}
		});
		long sumOri=0,sumComp=0;
		for(int i=0;i<n;i++) {
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			diff.add(a-b);
			sumOri += a;
			sumComp += b;
		}
		int answer=0;
		if(sumComp>m) {
			answer = -1;
		}else if(sumOri<=m){
			answer=0;
		}else {
			sumOri = sumOri-m;
			while(sumOri>0&&!diff.isEmpty()) {
				sumOri -= diff.poll();
				answer++;
			}
		}
		System.out.println(answer);
	}
}
