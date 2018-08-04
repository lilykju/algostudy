package b;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class R498_Polycalp {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[] diff=new int[n];
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer one,Integer two) {
				return Integer.compare(diff[two], diff[one]);
			}
		});
		//ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<n;i++) {
			diff[i]=in.nextInt();
			pq.add(i);
			/*if(a.size()<k)a.add(diff[i]);
			else {
				int min=diff[i];
				for(int j=0;j<k;j++) {
					if(a.get(j)<diff[i]) {
						
					}
				}
			}*/
		}
		PriorityQueue<Integer> pq2=new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			pq2.add(pq.poll());
		}
		int idx=-1;
		int total=0;
		int[] ans=new int[k];
		for(int i=0;i<k-1;i++) {
			int temp=pq2.poll();
			total+=diff[temp];
			ans[i]=temp-idx;
			idx=temp;
		}
		total+=diff[pq2.poll()];
		ans[k-1]=n-idx-1;
		System.out.println(total);
		for(int i=0;i<k;i++)
			System.out.print(ans[i]+" ");
		in.close();
	}
}
