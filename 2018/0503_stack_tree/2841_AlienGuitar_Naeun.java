package stack;

import java.util.Scanner;
import java.util.Stack;

public class N2841_AlienGuitar {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.nextInt();
		@SuppressWarnings("unchecked")
		Stack<Integer>[] g=(Stack<Integer>[])new Stack[7];
		for(int i=1;i<7;i++) {
			g[i]=new Stack<>();
		}
		int count=0;
		for(int i=0;i<n;i++) {
			int li=in.nextInt();
			int pr=in.nextInt();
			if(g[li].isEmpty()) {
				count++;
				g[li].push(pr);
			}else {
				while(!g[li].isEmpty()&&g[li].peek()>pr) {
					count++;
					g[li].pop();
				}
				if(g[li].isEmpty()||g[li].peek()!=pr) {
					count++;
					g[li].push(pr);
				}
			}
		}
		System.out.println(count);
		
		in.close();
	}
}
