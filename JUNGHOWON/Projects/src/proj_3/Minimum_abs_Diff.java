package proj_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Minimum_abs_Diff {

	public static int minimumAbsDiff(int N_elements , int[] Integer_arr)
	{	
		//int count = N_elements * (N_elements - 1);
		ArrayList<Integer>   compare_value = new ArrayList<Integer>(); // for getting a max value 

		for(int i = 0; i<Integer_arr.length; i++)
		{	
			if(i == Integer_arr.length - 1 ) // last number!
				break;
			else
			{
				for(int j = i+1; j<Integer_arr.length; j++) // remaining ones ! 
				{
					compare_value.add(Math.abs(Integer_arr[i] - Integer_arr[j]));
				}	
			}
		}

		return Collections.min(compare_value);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		int 	N_Elements;
		int		result;
		int 	Length;

		System.out.println("Type the number of elements  : ");
		input = new Scanner(System.in);
		N_Elements = input.nextInt();
		
		if(N_Elements >= 2 && N_Elements <= 10000)
		{		
			int[] Interger_arr = new int[N_Elements];
			System.out.println("Type the elements  : ");			
			for(int i = 0; i<N_Elements; i++ ){ Interger_arr[i] = input.nextInt();}		
			result = minimumAbsDiff( N_Elements , Interger_arr );
			System.out.println(result);
		}
		else
			System.out.println("The number of elements is not bounded between 2 to 10000");
		

		input.close();
	}

}
