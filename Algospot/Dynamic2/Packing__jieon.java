package Dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Packing {
	
	static int n,nnn;
	static int[] volume, need;
	static int[][] cache;
	static String[] name;
	
	static int pack(int capacity, int item) {
		if(item==n) return 0;
		int ret=cache[capacity][item];
		if(ret!=-1) return ret;
		ret=pack(capacity,item+1);
		if(capacity>=volume[item])
			ret=Math.max(ret, pack(capacity-volume[item],item+1)+need[item]);
		return cache[capacity][item]=ret;
	}
	
	static void reconstruct(int capacity,int item, ArrayList<String> picked) {
		if(item==n) return;
		if(pack(capacity,item)==pack(capacity,item+1)) {
			reconstruct(capacity,item+1,picked);
		}else {
			picked.add(name[item]);
			nnn += need[item];
			reconstruct(capacity-volume[item],item+1,picked);
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int tc=in.nextInt();
		while(tc-->0) {
			n=in.nextInt();
			int capacity=in.nextInt();
			name=new String[n];
			volume=new int[n];
			need=new int[n];
			for(int i=0;i<n;i++) {
				name[i]=in.next();
				volume[i]=in.nextInt();
				need[i]=in.nextInt();
			}
			cache=new int[capacity+1][n];
			for(int i=0;i<capacity+1;i++)
				Arrays.fill(cache[i], -1);
			nnn=0;
			ArrayList<String> picked=new ArrayList<>();
			reconstruct(capacity,0,picked);
			System.out.println(nnn+" "+picked.size());
			for(String s:picked)
				System.out.println(s);
		}
		in.close();
	}
}
