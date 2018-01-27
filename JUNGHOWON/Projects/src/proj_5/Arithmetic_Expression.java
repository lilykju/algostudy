package proj_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Arithmetic_Expression {

	public static String Arithmetic_expression(int[] Integer_arr)
	{	
		ArrayList<String> Store_Arithmetic_exp = new ArrayList<String>(); //
		ArrayList<Integer> Store_Arithmetic_Cal = new ArrayList<Integer>(); //
		double count;
		int    first_index = 0;
		int 	dividable_index = -100;
		

		for(int i =0; i<Integer_arr.length; i++)
		{	
			if(i == Integer_arr.length -1 ) // for the last one ! 
				break;
			else
			{	
					if(i == 0){
						first_index  = i;
						Store_Arithmetic_Cal.add( Integer_arr[i]*Integer_arr[i+1]);
						Store_Arithmetic_Cal.add( Integer_arr[i]+Integer_arr[i+1]);
						Store_Arithmetic_Cal.add( Integer_arr[i]-Integer_arr[i+1]);
						Store_Arithmetic_exp.add( Integer_arr[i] + " * " + Integer_arr[i+1]);
						Store_Arithmetic_exp.add( Integer_arr[i] + " + " + Integer_arr[i+1]);
						Store_Arithmetic_exp.add( Integer_arr[i] + " - " + Integer_arr[i+1]);
						// divideble check !					
					}	
	
					else{
						count = Math.pow(3, i);
						first_index = first_index + 3*(i-1);
						while(count>0.0)
						{							
							Store_Arithmetic_Cal.add(Store_Arithmetic_Cal.get(first_index)*Integer_arr[i+1]);
							Store_Arithmetic_Cal.add(Store_Arithmetic_Cal.get(first_index)+Integer_arr[i+1]);
							Store_Arithmetic_Cal.add(Store_Arithmetic_Cal.get(first_index)-Integer_arr[i+1]);
							Store_Arithmetic_exp.add(Store_Arithmetic_exp.get(first_index) + " * " + Integer_arr[i+1]);
							Store_Arithmetic_exp.add(Store_Arithmetic_exp.get(first_index) + " + " + Integer_arr[i+1]);
							Store_Arithmetic_exp.add(Store_Arithmetic_exp.get(first_index) + " - " + Integer_arr[i+1]);

							first_index += 1;
							count = count -1.0;		
						}
						first_index = 0;
					}
			}		
		}
		
		for(int k=Store_Arithmetic_Cal.size()-1; k>=0; k--)
		{	
			if(Store_Arithmetic_Cal.get(k) % 101 == 0)
			{	
				dividable_index = k;	
				break;
			}				
		}
		if(dividable_index == -100)
			return "There is no possible cases";
		else
			return Store_Arithmetic_exp.get(dividable_index);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input should be divideble by 101 at least one case

		Scanner input;
		int 	N_Elements;
		String		result;

		System.out.println("Type the number of elements  : ");
		input = new Scanner(System.in);
		N_Elements = input.nextInt();

		if(N_Elements >= 2 && N_Elements <= 10000)
		{		
			int[] Interger_arr = new int[N_Elements];
			System.out.println("Type the elements  : ");			
			for(int i = 0; i<N_Elements; i++ ){ Interger_arr[i] = input.nextInt();}		
			result = Arithmetic_expression( Interger_arr );
			System.out.println(result);
		}
		else
			System.out.println("The number of elements is not bounded between 2 to 10000");

		input.close();
	}

}
