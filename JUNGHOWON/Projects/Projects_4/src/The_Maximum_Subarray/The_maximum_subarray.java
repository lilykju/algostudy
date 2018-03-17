package The_Maximum_Subarray;
import java.util.*;


public class The_maximum_subarray {

	public static int getMax(int[] inputArray){ 
		int maxValue = inputArray[0]; 
		for(int i=1;i < inputArray.length;i++){ 
			if(inputArray[i] > maxValue){ 
				maxValue = inputArray[i]; 
			} 
		} 
		return maxValue; 
	}

	static int[] maxSubarray(int[] arr) {
		// Complete this function
		int[] result = new int[2];
		int subarrays_sum = 0;
		int subsequences_sum = 0;
		int max_sum = 0;
		Boolean negative_check = false;
		Boolean positive_check = false;
		ArrayList<Integer> subarrays = new ArrayList<Integer>();

		for(int i = 0; i<arr.length; i++)
		{				
			if(arr[i] > 0)
				positive_check = true;			
			else
				negative_check = true;			
		}

		if(positive_check == false && negative_check == true) // only negative numbers, then get the maximum value among them 
		{			
			subarrays_sum = subsequences_sum = getMax(arr);
			result[1] = result[0] = subarrays_sum;			 
		}

		else{			
			subsequences_sum = subarrays_sum = 0;			
			for(int i = 0; i<arr.length; i++)
			{	
				subarrays_sum += arr[i];				
				if(subarrays_sum > max_sum)
					max_sum = subarrays_sum;
				else if(subarrays_sum < 0)
					subarrays_sum = 0;
				if(arr[i] > 0)
					subsequences_sum += arr[i];			
			}
			result[0] = max_sum;
			result[1] = subsequences_sum;			
		}		
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int number_of_elements = input.nextInt();
			int[] arr = new int[number_of_elements];
			for(int arr_i = 0; arr_i < number_of_elements; arr_i++){
				arr[arr_i] = input.nextInt();
			}
			int[] result = maxSubarray(arr);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
			}
			System.out.println("");
		}
		input.close();
	}
}