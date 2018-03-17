package Even_Tree;
import java.util.*;

public class Even_Tree {
	  
	  static ArrayList<Integer>[] tree;
	  
	  static int evenTree(int n, int m, int[][] tree) {
	        // Complete this function
		  int[] tree_arr = new int[n];		
		  tree_arr[0] = -1; // root		 
		  
		  int[] tree_vertex_counting = new int[n];
		  Arrays.fill(tree_vertex_counting, 1);
		  int index = 0;
		  int count = 0;
		  
		  for(int i=0; i<m; i++)    // tree 다 채움 
		  {
			  index = tree[i][0] - 1; // node 0 이 없음
			  tree_arr[index] = --tree[i][1];
			 
		  }
		  
		  for(int j=1; j<tree_arr.length; j++) // root는 제외 
		  {	
			int vertex_value = tree_arr[j] ;
			while(vertex_value != 0)           // root ==> 0
			{
				tree_vertex_counting[vertex_value] += 1;
				vertex_value = tree_arr[vertex_value];
			}
		  }
		  for(int i = 0; i<tree_vertex_counting.length; i++) // 짝수 갯수의 노드 갯수만 세면 됨
		  {
			  if(tree_vertex_counting[i] % 2 == 0)
				  count += 1;
		  }
		  return count;
	    }
	  	
	    
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        int n = input.nextInt();
	        int m = input.nextInt();
	        int[][] tree = new int[m][2];
	        for(int tree_i = 0; tree_i < m; tree_i++){
	            for(int tree_j = 0; tree_j < 2; tree_j++){
	                tree[tree_i][tree_j] = input.nextInt();
	            }
	        }
	        int result = evenTree(n, m, tree);
	        System.out.println(result);
	        input.close();
	    }

}
