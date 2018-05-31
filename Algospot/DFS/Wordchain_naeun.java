package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wordchain {
	
	static List<String>[][] graph;
	static int[][] adj;
	static int[] ind,outd;
	
	
	static void getEulerCircuit(int here, ArrayList<Integer> circuit) {
		for(int there=0;there<adj.length;there++) {
			while(adj[here][there]>0) {
				adj[here][there]--;
				getEulerCircuit(there,circuit);
			}
		}
		circuit.add(here);
	}
	
	static ArrayList<Integer> getEulerTrailOrCircuit(){
		ArrayList<Integer> circuit=new ArrayList<>();
		for(int i=0;i<26;i++) {
			if(outd[i]==ind[i]+1) {
				getEulerCircuit(i,circuit);
				return circuit;
			}
		}
		for(int i=0;i<26;i++) {
			if(outd[i]>0) {
				getEulerCircuit(i,circuit);
				return circuit;
			}
		}
		return circuit;
	}
	
	static boolean checkEuler() {
		int plus1=0, minus1=0;
		for(int i=0;i<26;i++) {
			int delta=outd[i]-ind[i];
			if(delta<-1||1<delta) return false;
			if(delta==1)plus1++;
			if(delta==-1)minus1++;
		}
		return (plus1==1&&minus1==1)||(plus1==0 && minus1==0);
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int n=in.nextInt();
			graph=(List<String>[][])new List[26][26];
			adj=new int[26][26];
			ind=new int[26];
			outd=new int[26];
			in.nextLine();
			for(int i=0;i<26;i++)
				for(int j=0;j<26;j++)
					graph[i][j]=new ArrayList<>();
			for(int i=0;i<n;i++) {
				String s=in.nextLine();
				int a=s.charAt(0)-'a';
				int b=s.charAt(s.length()-1)-'a';
				graph[a][b].add(s);
				adj[a][b]++;
				outd[a]++;
				ind[b]++;
			}
			if(!checkEuler()) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			ArrayList<Integer> circuit=getEulerTrailOrCircuit();
			if(circuit.size()!=n+1) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			String answer="";
			for(int i=circuit.size()-1;i>0;i--) {
				int a=circuit.get(i), b=circuit.get(i-1);
				answer+= graph[a][b].get(0)+" ";
				graph[a][b].remove(0);
			}
			System.out.println(answer);
		}
		in.close();
	}
}
