import java.util.*;
class Edge{
    public int start;
    public int end;
    public int cost;
    Edge(){
        this(0,0,0);
    }
    Edge(int a,int b,int c){
        start=a;end=b;cost=c;
    }
}
public class Main{
    static class Compare implements Comparator<Edge>{
        public int compare(Edge one, Edge two){
            return Integer.compare(one.cost,two.cost);
        }
    }
    public static void disjoint_union(int[] p,int x, int y){
        x=find(p,x);
        y=find(p,y);
        p[x]=y;
    }
    public static int find(int[] p,int x){
        if(x==p[x]){
            return x;
        }else{
            return find(p,p[x]);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] p=new int[v+1];
        for(int i=1;i<=v;i++){
            p[i]=i;
        }
        ArrayList<Edge> g = new ArrayList<Edge>();
        while(e-->0){
            g.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(g,new Compare());
        int ans=0;
        for(Edge edge:g){
            int x= find(p,edge.start);
            int y= find(p,edge.end);
            if(x!=y){
                disjoint_union(p,x,y);
                ans += edge.cost;
            }
        }
        System.out.println(ans);
    }
}
