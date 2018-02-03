package Goodland_Electricity;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Goodland_electricity {

	private static final int NOT_POSSIBLE = -1;
	//	private static final int ONE_TRY_POSSIBLE = 1;

	public static boolean all_city_power_check(Boolean[] turn_on_city_arr)
	{
		for(int i = 0; i<turn_on_city_arr.length; i++){
			if(turn_on_city_arr[i] == false)
				return false;
			
		}
		return true;		
	}

	public static int pylons(int electric_tower_range, int[] city_arr) {

		
		Boolean[] turn_on_city_arr = new Boolean[city_arr.length];
		Arrays.fill(turn_on_city_arr, false);
		int		  turn_on_start_index  = -1;
		int		  turn_on_last_index = -1;
		int 	  count = 0;
		int 	  tower_check_start_index = 0;
		int       prev_tower_check_start_index = -1; // should not be included for the first time
		int		  electric_tower_count = 0;

		for(int i =0 ; i< city_arr.length; i++)
		{
			if(city_arr[i] == 1)
				electric_tower_count += 1;   	// count how many electric tower there are !
		}
		
		if(electric_tower_range == city_arr.length){   //1) if the range is the same as the number of city !
			if(electric_tower_count != 0)
				return 1;
			else
				return NOT_POSSIBLE;
		}
		else										   //2) remaining cases !
		{
			while(electric_tower_count > 0)
			{
				for(int j = tower_check_start_index + electric_tower_range - 1; j> prev_tower_check_start_index; j--)
				{	
					if( j > city_arr.length - 1) // if j is larger than set it as the last index of array 
						j = city_arr.length - 1;
				
					if(city_arr[j] == 1)         // start to find out from the optimal point !
					{	
						turn_on_start_index = j - electric_tower_range + 1; 
						if( turn_on_start_index < 0 )				// if turn_on_start_index is smaller than set it as 0
							turn_on_start_index = 0;						

						turn_on_last_index = j + electric_tower_range - 1;	 					
						if(turn_on_last_index > city_arr.length - 1) // if turn_on_last_index is larger than set it as the last index of array 
							turn_on_last_index = city_arr.length - 1;


						for(int k = turn_on_start_index; k<= turn_on_last_index; k++ )
						{	turn_on_city_arr[k] = true;	}							

						count += 1;					                 // after power up the city , plus count !
						prev_tower_check_start_index = tower_check_start_index;
						tower_check_start_index = turn_on_last_index + 1; // start from next city of last one powered up
						break;
					}
					else{}
				}

				electric_tower_count -= 1;							  // minus electric tower count !
				if(all_city_power_check(turn_on_city_arr) == true)    // check whether all cities are powered up or not , if all city have electricity , then break !
					break;
				else												  // otherwise, continue providing power on to the other cities !
					continue;

			}				

			if(all_city_power_check(turn_on_city_arr) == true)		 // there might be the case not all the cities power up after turning on the electric tower!
				return count;
			else
				return NOT_POSSIBLE;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int N_cities = input.nextInt();
		int Electric_tower_range = input.nextInt();
		int[] city_arr = new int[N_cities];
		Boolean city_arr_value_check = true;
		if(Electric_tower_range >= 1 || Electric_tower_range <= N_cities){ // constraints are applied

			for(int arr_i = 0; arr_i < N_cities; arr_i++){
				city_arr[arr_i] = input.nextInt();
				if((city_arr[arr_i] == 1 || city_arr[arr_i] == 0) == false)
					city_arr_value_check = false;
			}
			if(city_arr_value_check == true)
			{
				int result = pylons(Electric_tower_range, city_arr);
				System.out.println(result);
			}
			else{}
		}
		else{}
		input.close();

	}

}
