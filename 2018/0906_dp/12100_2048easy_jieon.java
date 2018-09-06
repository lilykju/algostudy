package bruteforce;

import java.util.Scanner;

public class N12100_2048easy {
	
	static void printBoard(int n, int[][] board) {
		System.out.println("board");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
	
	static int moveUpDown(int turn, int type, int n, int[][] boardNow) {
		int[][] boardNext = new int[n][n];
		int max=0;
		int p=(type==0)?1:-1;
		for(int j=0;j<n;j++) {
			int sIdx=(p>0)?0:n-1;
			int pIdx=(p>0)?0:n-1;
			int nIdx=pIdx+p;
			while(0<=nIdx&&nIdx<n) {
				while((0<=pIdx&&pIdx<n)&&boardNow[pIdx][j]==0)pIdx+=p;
				nIdx=pIdx+p;
				while(0<=nIdx&&nIdx<n&&boardNow[nIdx][j]==0)nIdx+=p;
				if(nIdx>=n||nIdx<0)break;
				if(boardNow[pIdx][j]==boardNow[nIdx][j]) {
					boardNext[sIdx][j]=boardNow[pIdx][j]*2;
					pIdx=nIdx+p;
					nIdx+=2*p;
				}else {
					boardNext[sIdx][j]=boardNow[pIdx][j];
					pIdx=nIdx;
					nIdx+=p;
				}
				max=Math.max(max, boardNext[sIdx][j]);
				
				sIdx+=p;
			}
			if(pIdx<n&&pIdx>=0) {
				boardNext[sIdx][j]=boardNow[pIdx][j];
				max=Math.max(max, boardNext[sIdx][j]);
			}
		}
		int moveMax = move(turn+1,n,boardNext);
		return Math.max(max, moveMax);
	}
	
	static int moveLeftRight(int turn, int type, int n, int[][] boardNow) {
		int[][] boardNext = new int[n][n];
		int max=0;
		int p=(type==0)?1:-1;
		for(int i=0;i<n;i++) {
			int sIdx=(p>0)?0:n-1;
			int pIdx=(p>0)?0:n-1;
			int nIdx=pIdx+p;
			while(0<=nIdx&&nIdx<n) {
				while((0<=pIdx&&pIdx<n)&&boardNow[i][pIdx]==0)pIdx+=p;
				nIdx=pIdx+p;
				while(0<=nIdx&&nIdx<n&&boardNow[i][nIdx]==0)nIdx+=p;
				if(nIdx>=n||nIdx<0)break;
				if(boardNow[i][pIdx]==boardNow[i][nIdx]) {
					boardNext[i][sIdx]=boardNow[i][pIdx]*2;
					pIdx=nIdx+p;
					nIdx+=2*p;
				}else {
					boardNext[i][sIdx]=boardNow[i][pIdx];
					pIdx=nIdx;
					nIdx+=p;
				}
				max=Math.max(max, boardNext[i][sIdx]);
				
				sIdx+=p;
			}
			if(pIdx<n&&pIdx>=0) {
				boardNext[i][sIdx]=boardNow[i][pIdx];
				max=Math.max(max, boardNext[i][sIdx]);
			}
		}
		int moveMax = move(turn+1,n,boardNext);
		return Math.max(max, moveMax);
	}
	
	
	static int move(int turn,int n, int[][] board) {
		if(turn==5) return 0;
		int upMax= moveUpDown(turn,0,n,board);
		int downMax= moveUpDown(turn,1,n,board);
		int leftMax= moveLeftRight(turn,0,n,board);
		int rightMax= moveLeftRight(turn,1,n,board);
		int max = Math.max(upMax,downMax);
		max = Math.max(max, Math.max(leftMax, rightMax));
		return max;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] board=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				board[i][j]=in.nextInt();

		
		System.out.println(move(0,n,board));
		
		
		in.close();
	}

}
