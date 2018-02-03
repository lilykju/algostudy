package search;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountLuck {
	static int X = -1;
	static int P=-2;
	static int[][] k = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static class Pair{
		int x;
		int y;
		Pair(int x,int y){
			this.x = x;
			this.y= y;
		}
	}
	
	static int countLuck(int n,int m,int[][] matrix, int[] start) {
        int count=0;
        boolean check = false;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start[0],start[1]));
        while(!q.isEmpty()) {
        	Pair p=q.poll();
        	ArrayList<Pair> a=new ArrayList<>();
        	for(int i=0;i<4;i++) {
        		int nx=p.x+k[i][0];
        		int ny=p.y+k[i][1];
        		if(0<=nx&&nx<n&&0<=ny&&ny<m) {
	        		if(matrix[nx][ny]==0) {
	    				q.add(new Pair(nx,ny));
	    				a.add(new Pair(nx,ny));
	    			}
        		}
        	}
        	if(a.size()==1) {
        		matrix[a.get(0).x][a.get(0).y]=matrix[p.x][p.y];
        		if(matrix[a.get(0).x][a.get(0).y]==P)count=matrix[a.get(0).x][a.get(0).y];
        	}else {
        		for(int i=0;i<a.size();i++) {
        			matrix[a.get(i).x][a.get(i).y]=matrix[p.x][p.y]+1;
        			if(matrix[a.get(i).x][a.get(i).y]==P)count=matrix[a.get(i).x][a.get(i).y];
        		}
        	}
        	if(count!=0) break;
        }
        for(int i = 0;i < n; i++){
            for(int j=0; j<m; j++) {
            	System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println(count-1);
        return count-1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            String[] mat = new String[n];
            int[][] matrix=new int[n][m];
            int[] start=new int[2];
            for(int matrix_i = 0; matrix_i < n; matrix_i++){
                mat[matrix_i] = in.next();
                for(int j=0; j<m; j++) {
                	switch(mat[matrix_i].charAt(j)) {
                	case '.' : matrix[matrix_i][j]=0; break;
                	case'X' : matrix[matrix_i][j]=X; break;
                	case'*' : matrix[matrix_i][j]=P; break;
                	case'M' : start[0]=matrix_i; start[1]=j; break;
                	}
                }
            }
            String result = (countLuck(n,m,matrix,start)==in.nextInt()) ?"Impressed":"Opps" ;
            System.out.println(result);
        }
        in.close();
    }
}
