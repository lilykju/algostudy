import java.util.*;
public class Main{
	static int n,k;
	static List<Integer>[] a;
	static boolean[] check;
	static int[] pred;
	public static void main(String args[]){     
		 Scanner sc = new Scanner(System.in);
	      n= sc.nextInt();	      
	      k= sc.nextInt();
	      a=(List<Integer>[]) new List[n+1];
	      pred=new int[n+1];
	      for(int i=0;i<=n;i++){
	    	  a[i]=new ArrayList<>();
	    	  pred[i]=-1;
	      }
	      for(int i=0;i<k;i++){
	    	  a[sc.nextInt()].add(sc.nextInt());
	      }
	      int ans=0;
	      for(int i=1;i<=n;i++){
	    	  check = new boolean[n+1];
	    	  if(dfs(i)) {
	    		ans++;
	    	}	    	  
	      }
	      System.out.println(ans);
	}
	static boolean dfs(int x){
		if(x==-1) return true;
		for(int next: a[x]){
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
