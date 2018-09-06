package e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class R494_TreeConstructing {	

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] s=br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int d = Integer.parseInt(s[1]);
		int k = Integer.parseInt(s[2]);
		if(n<=d||(k==1&&n>2)) {
			System.out.println("NO");
			return;
		}
		int[] md=new int[n+1];
		int[] mk=new int[n+1];
		ArrayList<String> a=new ArrayList<>();
		int m=d/2;
		for(int i=1;i<=d;i++) {
			md[i]=d+1-i;
			if(md[i]<=m) md[i]=d-md[i];
			mk[i]=2;
			a.add(i+" "+(i+1));
		}
		md[d+1]=d;
		mk[1]=mk[d+1]=1;
		
		int idx=d+2;
		for(int i=2;i<=n;i++) {
			if(idx>n||idx==i) break;
			if(md[i]<d) {
				for(int j=mk[i];j<k;j++) {
					if(idx>n) break;
					md[idx]=md[i]+1;
					mk[idx]++;
					mk[i]++;
					a.add(i+" "+idx);
					idx++;
				}
			}
		}
		if(idx>n) {
			System.out.println("YES");
			for(String ans:a) {
				System.out.println(ans);
			}
			
		}else System.out.println("NO");
	}
}
