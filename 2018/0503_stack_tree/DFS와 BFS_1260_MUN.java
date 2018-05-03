import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int n ;
    static int m;
    static int v;
    static int map[][];
    static int visit[];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        v = scan.nextInt();

        map = new int[n+1][n+1];
        visit = new int[n+1];

        for(int i=0;i< m ;i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            map[start][end] = 1;
            map[end][start] = 1;
        }
        for(int i=0;i<n;i++){
            visit[i]=0;
        }

        dfs(v,n);

        System.out.println();
        for(int i=0;i<n+1;i++){
            visit[i]=0;
        }

        bfs2(v,n);
    }

    public static void dfs(int v, int n){
        Stack stack = new Stack();
        stack.push(v);
        while(!stack.isEmpty()){
            int num = (int) stack.pop();
                visit[num]=1;
                System.out.print(num+" ");
                for(int i = 1; i< n+1; i++){
                    if(map[num][i]==1 && visit[i]!=1){
                        stack.push(i);
                        break;
                    }
                }

        }

    }

    public static void bfs(int v, int n){
        Queue queue = new LinkedList();
        queue.add(v);
        visit[v]=1;
        while(!queue.isEmpty()){
            int num = (int) queue.poll();
            System.out.print(num+" ");
            for(int i = 1; i< n+1; i++){
                if(map[num][i]==1 && visit[i]!=1){
                    queue.add(i);
                    visit[i]=1;
                }
            }
        }
    }

    public static void bfs2(int v, int n){
        Queue queue = new LinkedList();
        queue.add(v);

        while(!queue.isEmpty()){
            int num = (int) queue.poll();
            if(visit[num]==1){

            }else{
                visit[num]=1;
                System.out.print(num+" ");
                for(int i = 1; i< n+1; i++){
                    if(map[num][i]==1 && visit[i]!=1){
                        queue.add(i);

                    }
                }
            }

        }
    }
}