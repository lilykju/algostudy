package study;

import java.util.ArrayList;
import java.util.Scanner;

public class N1798_jeju {
	static class tri{
		int num,t,s;
		tri(int a,int b, int c){
			num=a;
			t=b;
			s=c;
		}
	}
	final static int htom = 540;
	static int N, M, max, A;
	static int[][] dist;
	static ArrayList<Integer> ans;
	static ArrayList<Integer> H;
	static ArrayList<tri> P;
	static boolean[] visited;
	
	static void brute(int start,int ltime,int day,int sat,ArrayList<Integer> aa) {
		System.out.println(start+": "+ltime);
		if(ltime>=20)
		for(tri t:P) {
			if(visited[t.num]||(t.t+dist[start][t.num]>ltime-10)) continue;
			visited[t.num]=true;
			aa.add(t.num);
			brute(t.num,ltime-t.t-dist[start][t.num],day,sat+t.s,aa);
			aa.remove((Integer)t.num);
			visited[t.num]=false;
		}
		
		if(day==M) {
			if(dist[start][A]<=ltime&&sat>max) {
				max=sat;
				ans.clear();
				ans.addAll(aa);
				ans.add(A);
				for(int a:ans)
					System.out.print(" "+(a+1));
				System.out.println();
			}
		}else {
			for(int h:H) {
				if(dist[start][h]<=ltime) {
					aa.add(h);
					brute(h,htom,day+1,sat,aa);
					aa.remove((Integer)h);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int TC=in.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			max=0;
			ans=new ArrayList<>();
			N=in.nextInt();
			M=in.nextInt();
			dist=new int[N][N];
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					dist[i][j]=dist[j][i]=in.nextInt();
				}
			}
			A=-1;
			H=new ArrayList<>();
			P=new ArrayList<>();
			visited=new boolean[N];
			for(int i=0;i<N;i++) {
				String type= in.next();
				if(type.equals("A")) A=i;
				else if(type.equals("H")) H.add(i);
				else P.add(new tri(i,in.nextInt(),in.nextInt()));
			}
			
			brute(A,htom,1,0,new ArrayList<>());	
			
			System.out.print("#"+tc+" "+max);
			if(max!=0) {
				for(int a:ans)
					System.out.print(" "+(a+1));
			}
		}
		in.close();
	}

}
