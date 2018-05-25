package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dictionary {
	static boolean[][] adj;
	static boolean[] seen;
	static ArrayList<Integer> order;
	
	static void makeGraph(String[] words) {
		for(int j=1;j<words.length;j++) {
			int i=j-1, len=Math.min(words[i].length(), words[j].length());
			
			for(int k=0;k<len;k++) {
				if(words[i].charAt(k)!=words[j].charAt(k)) {
					int a= words[i].charAt(k) - 'a';
					int b= words[j].charAt(k) - 'a';
					adj[a][b] = true;
					break;
				}
			}
		}
	}
	
	static void dfs(int here) {
		
		seen[here]=true;
		for(int there=0;there<26;there++) {
			if(adj[here][there]&&!seen[there]) 
				dfs(there);
		}
		order.add(here);
	}
	
	static void topologicalSort() {
		int n=adj.length;
		seen=new boolean[n];
		order=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			if(!seen[i]) dfs(i);
		}
		for(int i=order.size()-1;i>=0;i--) {
			for(int j=i-1;j>=0;j--) {
				if(adj[order.get(j)][order.get(i)]) {
					order=new ArrayList<>();
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] words=new String[n];
			for(int i=0;i<n;i++) {
				words[i]=br.readLine();
			}
			adj=new boolean[26][26];
			makeGraph(words);
			topologicalSort();
			if(order.isEmpty()) {
				System.out.println("INVALID HYPOTHESIS");
				continue;
			}
			for(int i=order.size()-1;i>=0;i--)
				System.out.print((char)(order.get(i)+'a'));
			System.out.println();
		}
	}
}
