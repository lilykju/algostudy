package study;

import java.util.Scanner;

public class N5550_frog {
	static char[] croak= {'c','r','o','a','k'};;
	static int getIdx(char c) {
		for(int i=0;i<5;i++)
			if(croak[i]==c) return i;
		return -1;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int TC=in.nextInt();
		in.nextLine();
		for(int tc=1;tc<=TC;tc++) {
			String sound=in.nextLine();
			int[] now=new int[5];
			int ans=0;
			for(int i=0;i<sound.length();i++) {
				int idx=getIdx(sound.charAt(i));
				if(idx==0) {
					now[0]+=1;
					if(now[4]!=0) now[4]-=1;
				}else {
					if(now[idx-1]==0) {
						ans=-1;
						break;
					}
					now[idx-1]-=1;
					now[idx]+=1;
				}		
			}
			if(now[4]==0) ans=-1;
			if(ans!=-1) {
				ans = now[4];
				for(int i=0;i<4;i++) {
					if(now[i]!=0) {
						ans=-1;
						break;
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		in.close();
	}

}
