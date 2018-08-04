import java.util.*;
public class Main{
	static List<Integer>[] edge;
	static boolean[] check;
	static int[] pred;
	public static void main(String args[]){     
		 Scanner sc = new Scanner(System.in);
	      int n= sc.nextInt();
	      int m=sc.nextInt();
	      edge=(List<Integer>[]) new List[n];	      
	      pred=new int[m];
	      for(int i=0;i<n;i++){
	    	  edge[i]=new ArrayList<Integer>();
	    	  int cnt=sc.nextInt();
	    	  for(int j=0;j<cnt;j++){
	    		  edge[i].add(sc.nextInt()-1);
	    	  }
	      }
	      for(int i=0;i<m;i++){
	    	  pred[i]=-1;
	      }
	      int ans=0;
	      for(int i=0;i<n;i++){
	    	  check = new boolean[m];
	    	  if(dfs(i)) ans++;
	      }
	      System.out.println(ans);
	} 
	static boolean dfs(int x){
		if(x==-1) return true;
		for(int next: edge[x]){
			if(check[next]) continue;
			check[next]=true;
			if(dfs(pred[next])){
				pred[next]=x;
				return true;
			}
		}
		return false;
	}
}
