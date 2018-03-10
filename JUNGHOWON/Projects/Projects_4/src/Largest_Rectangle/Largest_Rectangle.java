package Largest_Rectangle;

import java.util.*;


public class Largest_Rectangle {

	static long largestRectangle(int[] h) {
		// Complete this function
			
		long count = 1;
		ArrayList<Long> Rectangle_array = new ArrayList<Long>(); 

		for(int i = 0; i<h.length; i++)
		{		
			long compare_value =  h[i];

			for(int left = i-1; left >=0; left--)
			{	
				if(left < 0)
					break;						
				else if(compare_value <= h[left])
					count += 1;				
				else
					break;
			}
			
			for(int right = i+1; right < h.length; right++)
			{					
				if(right >= h.length)					
					break;				
				else if(compare_value <= h[right])
					count += 1;				
				else				
					break;				
			}			
			
			Rectangle_array.add(compare_value * count);
			count = 1;
		}		
		return	Collections.max(Rectangle_array);		 
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] h = new int[n];
		for(int h_i = 0; h_i < n; h_i++){
			h[h_i] = input.nextInt();
		}
		long result = largestRectangle(h);
		System.out.println(result);
		input.close();
	}

}
