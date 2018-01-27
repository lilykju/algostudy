package proj_4;

import java.util.Scanner;

public class Beautiful_pairs {
	
	public static int beautifualPairs(int[] arr_1 , int[] arr_2)
	{	
		int count = 0;
		int B_element;
		Boolean[] Check_array = new Boolean[arr_1.length];
		for(int i =0; i<arr_1.length; i++)	{ Check_array[i] = false; }
		
		for(int i =0; i<arr_1.length; i++)
		{	
			B_element = arr_2[i];
			if(Check_array[i] == false && arr_1[i] == B_element){
				Check_array[i] = true;
				count +=1;
			}
		}		

		count +=1;
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		int 	N_Elements;		
		int		result;

		System.out.println("Type the number of elements  : ");
		input = new Scanner(System.in);
		N_Elements = input.nextInt();
		
		if(N_Elements >= 1 && N_Elements <= 1000)
		{		
			int[] Interger_arr_1 = new int[N_Elements];
			System.out.println("Type the elements for the first array : ");			
			for(int i = 0; i<N_Elements; i++ ){ Interger_arr_1[i] = input.nextInt();}		
		
			int[] Interger_arr_2 = new int[N_Elements];
			System.out.println("Type the elements for the second array : ");			
			for(int i = 0; i<N_Elements; i++ ){ Interger_arr_2[i] = input.nextInt();}		
				
			result = beautifualPairs(Interger_arr_1 , Interger_arr_2);
			System.out.println(result);
		}
		else
			System.out.println("The number of elements is not bounded between 1 to 1000");

		input.close();
	}

}
