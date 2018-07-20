package c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class R496_SumPowOfTwo {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> pot=new ArrayList<>();
		int a=1;
		for(int i=1;i<31;i++) {
			a*=2;
			pot.add(a);
		}
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<n;i++) 
			arr[i]=Integer.parseInt(s[i]);
			
		boolean[] is=new boolean[n];
		for(int i=0;i<n;i++) {
			if(is[i]) continue;
			for(int j=0;j<n;j++) {
				if((j<i&&!is[j])||i==j) continue;
				if(pot.contains(arr[i]+arr[j])) {
					is[i]=true;
					is[j]=true;
					break;
				}
			}
		}
		
		int ans=0;
		for(int i=0;i<n;i++)
			if(!is[i]) ans++;
		
		System.out.println(ans);
	}
}
