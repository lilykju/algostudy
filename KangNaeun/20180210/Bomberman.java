package implementation;

import java.util.Scanner;

public class Bomberman {
	
	
	//¸ðµç Ä­¿¡ ÆøÅº ¼³Ä¡
	static char[][] bombAll(int r,int c){
		
		char[][] grid = new char[r][c];
		
		for(int i = 0; i < r; i++){
        	for(int j=0; j<c; j++) {
        		grid[i][j]='O';
        	}
        }
		
		return grid;
	}
	
	//ÆøÅº ÅÍ¶ß¸®±â
	static char[][] bomb(int r,int c, int n, char[][] grid){
		int[] k1= {1,0,0,-1};
		int[] k2= {0,1,-1,0};
		char[][] bombgrid=bombAll(r,c);
        for(int i = 0; i < r; i++){
        	for(int j=0; j<c; j++) {
        		if(grid[i][j]=='O') {
        			bombgrid[i][j]='.';
        			for(int k=0;k<4;k++) {
        				int x=j+k1[k];
        				int y=i+k2[k];
        				if(0<=x && x<c && 0<=y && y<r) {
        					bombgrid[y][x]='.';
        				}
        			}
        		}
        	}
        }
        
        return bombgrid;      
	}
	
	static char[][] bomberMan(int r,int c, int n, char[][] grid) {
		
        if(n%2==0) {
        	return bombAll(r, c);
        }
        if(n==1) return grid;
        n -=1;
        grid = bomb(r,c,n,grid);
        if(n%4!=0) return grid;
        return bomb(r,c,n,grid);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        char[][] grid=new char[r][c];
        for(int i = 0; i < r; i++){
        	String temp=in.next();
        	for(int j=0; j<c; j++) {
        		grid[i][j]=temp.charAt(j);
        	}
        }
        char[][] result = bomberMan(r, c, n, grid);
        for (int i = 0; i < r; i++) {
            for(int j=0; j < c; j++) {
            	System.out.print(result[i][j]);
            }
            System.out.println();
        }
        

        in.close();
    }
}
