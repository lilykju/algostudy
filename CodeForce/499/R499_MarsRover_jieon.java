package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class R499_MarsRover {

	static int[] op,d;
	static int[][] child;
	static boolean[] noEff;
	
	static void check(int x) {
		if(noEff[x]) return;
		noEff[x]=true;
		if(op[x]<2) return;
		check(child[x][0]);
		if(op[x]==2) return;
		check(child[x][1]);
	}
	
	static int down(int x) {
		if(op[x]<2) return d[x]= op[x];
		int child1=down(child[x][0]);
		if(op[x]==2) return d[x]= child1^1;
		int child2=down(child[x][1]);
		if(op[x]==3) {
			if(child1==0) check(child[x][1]);
			if(child2==0) check(child[x][0]);
			return d[x]= child1&child2;
		}
		if(op[x]==4) {
			if(child1==1) check(child[x][1]);
			if(child2==1) check(child[x][0]);
			return d[x]= child1|child2;
		}
		return d[x]= child1^child2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
		op=new int[n+1];
		d=new int[n+1];
		child=new int[n+1][2];
		noEff=new boolean[n+1];
		ArrayList<Integer> inNode=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(reader.readLine());
            String s = st.nextToken();
			if(s.equals("IN")) {
				op[i]=Integer.parseInt(st.nextToken());
				inNode.add(i);
			}else if(s.equals("NOT")) {
				op[i]=2;
				child[i][0]=Integer.parseInt(st.nextToken());
			}else { 
				if(s.equals("AND")) op[i]=3;
				else if(s.equals("OR")) op[i]=4;
				else if(s.equals("XOR")) op[i]=5;
				for(int j=0;j<2;j++) {
					child[i][j]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		down(1);
		
		for(int i:inNode) {
			System.out.print(noEff[i]?d[1]:d[1]^1);
		}
	
	}

}
