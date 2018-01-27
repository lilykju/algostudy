package proj_6;

import java.util.Scanner;

public class Lilys_homework {
	public static int lilysHomework(int[] integer_arr)
	{	
		int minimum_val=9999;
		int maximum_val=-9999;
		int minimum_val_index = -1;
		int maximum_val_index = -2;
		int count=0;
		int temp_val;
		int[] integer_arr_copied = new int[integer_arr.length];
		int[] compare_array = new int[2];
		if(integer_arr.length == 1 || integer_arr.length == 2)
			return 0;
		else{
			for(int i =0; i<integer_arr.length; i++){ integer_arr_copied[i] = integer_arr[i]; }

			for(int i = 0; i<integer_arr.length; i++) // pick the minimum value and maximum value
			{
				if(minimum_val > integer_arr[i]){
					minimum_val = integer_arr[i];
					minimum_val_index = i;
					//System.out.println("minimum_val : "+ minimum_val +  "  minimum_val_index : " + minimum_val_index);
				}

				if(maximum_val < integer_arr[i]){
					maximum_val = integer_arr[i];
					maximum_val_index = i;
					//System.out.println("maximum_val : "+ maximum_val +  "  maximum_val_index : " + maximum_val_index);
				}		
			}
			
			if(minimum_val_index != 0)  // set the minimum value and maximum value at first and last point !
			{
				integer_arr[minimum_val_index] = integer_arr[0];
				integer_arr[0] = minimum_val;
				count += 1;

			}			

			if(maximum_val_index != integer_arr.length-1)
			{
				integer_arr[maximum_val_index] = integer_arr[integer_arr.length-1];
				integer_arr[integer_arr.length-1] = maximum_val;
				count += 1;
			}	

			for(int i = 1; i<integer_arr.length-1; i++)
			{
			
//								
//								System.out.println("size : " +"	"+	integer_arr.length);
//								for(int k = 0; k< integer_arr.length; k++)
//								{System.out.println("value : " + integer_arr[k]);}
//								
				minimum_val = integer_arr[i];
				minimum_val_index = i;
//				System.out.println("minimum_val : " +"	"+	minimum_val + "	minimum_val_index : " +"	" + minimum_val_index);
				for(int j = 1; j<integer_arr.length-1; j++)
				{
					if(minimum_val > integer_arr[j])
					{	
//						System.out.println("minimum_val : " +"	"+	minimum_val + "	integer_arr[j] : " +"	" + integer_arr[j]);
						minimum_val_index = j;

						if(minimum_val_index != j){
							integer_arr[minimum_val_index] = integer_arr[j];
							integer_arr[j] = minimum_val;
							count+=1;
						}
					}
				}			
			}

			compare_array[0] = count;
//			System.out.println("First Count val : " + count);
			count = 0;
			
			
			if(maximum_val_index != 0)   // set the minimum value and maximum value at last and first point in a reverse way !
			{
				integer_arr_copied[maximum_val_index] = integer_arr_copied[0];
				integer_arr_copied[0] = maximum_val;
				count += 1;
			}

			if(minimum_val_index != integer_arr.length-1)
			{
				integer_arr_copied[minimum_val_index] = integer_arr_copied[integer_arr_copied.length-1];
				integer_arr_copied[integer_arr.length-1] = minimum_val;
				count += 1;
			}	
			
			
			for(int i = 1; i<integer_arr_copied.length; i++)
			{
				maximum_val = integer_arr[i];
				maximum_val_index = i;

				for(int j = 1; j<integer_arr.length-1; j++)
				{
					if(maximum_val < integer_arr[j]){
						maximum_val_index = j;

						if(maximum_val_index != j){
							integer_arr[maximum_val_index] = integer_arr[j];
							integer_arr[j] = maximum_val;
							count+=1;
						}
					}
					compare_array[1] = count;
				}
				
			}
//			System.out.println("Second Count val : " + count);
			if(compare_array[0] > compare_array[1] )
				return compare_array[1];
			else
				return compare_array[0]; 
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// SORTING ... between maximum or minimum value for sorting 

		Scanner input;
		int 	N_Elements;
		int		result;

		System.out.println("Type the number of elements  : ");
		input = new Scanner(System.in);
		N_Elements = input.nextInt();

		if(N_Elements >= 2 && N_Elements <= 10000)
		{		
			int[] Interger_arr = new int[N_Elements];
			System.out.println("Type the elements  : ");			
			for(int i = 0; i<N_Elements; i++ ){ Interger_arr[i] = input.nextInt();}		
			result = lilysHomework( Interger_arr );
			System.out.println(result);
		}
		else
			System.out.println("The number of elements is not bounded between 1 to 10000");

		input.close();

	}

}

