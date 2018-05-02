package tree;

import java.util.Scanner;

public class N2250_TreeHW {
	static int[] left, right;
	static int w=0;
	static int[] wid;
	static int[] ans= {1,1};
	
	static void dfs(int x,int l) {
		if(x==-1) return;
		dfs(left[x],l+1);
		w+=1;
		if(wid[l]==0) wid[l]=w;
		else {
			if(ans[1]<(w-wid[l]+1)) {
				ans[0]=l;
				ans[1]=w-wid[l]+1;
			}else if(ans[1]==(w-wid[l]+1)&&ans[0]>l) {
				ans[0]=l;
			}
		}
		dfs(right[x],l+1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean[] r=new boolean[n+1];
		left=new int[n+1];
		right=new int [n+1];
		for(int i=1;i<=n;i++) {
			int num=in.nextInt();
			left[num]=in.nextInt();
			right[num]=in.nextInt();
			if(left[num]!=-1) r[left[num]]=true;
			if(right[num]!=-1) r[right[num]]=true;
		}
		int root=0;
		for(int i=1;i<=n;i++) {
			if(!r[i]) {
				root=i;
				break;
			}
		}
		wid=new int[n+1];
		dfs(root,1);
		System.out.println(ans[0]+" "+ans[1]);
		in.close();
	}
}
