package The_bomberman_game;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class the_bomberman_game {

	public static final int after_one_sec_state = 1;
	public static final int after_two_sec_state = 2;
	public static final int after_three_sec_state = 3;
	public static Boolean[][] boom_map;
	public static HashSet< Pair<Integer , Integer> > Bomb_pos_pair = new HashSet< Pair<Integer , Integer> >();

	public static void check_bomb_pos(String[] bomb_grid) // FOR THE FIRST STEP 
	{	
		char boom_check ;		
		for(int i = 0; i<bomb_grid.length; i++)							  
		{	
			for(int j = 0; j<bomb_grid[i].length(); j++)
			{
				boom_check = bomb_grid[i].charAt(j);				
				if(boom_check == '.')		 // there is not a bomb 
					boom_map[i][j] = false;					
				else {						 // there is a bomb 
					boom_map[i][j] = true; 
					//Bomb_pos_pair.add(Pair((Integer)i  , (Integer)j));
				}
			}
		}	
	}



	public static String[] fill_bombs(String[] bomb_grid) // FOR THE SECOND STEP 
	{	
		for(int i = 0; i<bomb_grid.length; i++)							  
		{	
			for(int j = 0; j<bomb_grid[i].length(); j++)
			{				
				if(boom_map[i][j] == false)
				{
					StringBuilder builder = new StringBuilder(bomb_grid[i]);
					builder.setCharAt(j, 'O'); 
					bomb_grid[i] = builder.toString(); 							// adding a bomb !
				}
				else  // there is a boom 
				{} 
			}
		}
		return bomb_grid;
	}
	public static String[] explode_pos_check(String[] bomb_grid) // explode 시킬때 for문을 계속 돌아서 그런듯...?  or 해쉬 셋으로 중복되는것은 제외하는것도 방법 !
	{			
//		Pair<Integer , Integer> bomb_pair_pos;
//		for (Iterator iterator = Bomb_pos_pair.iterator(); iterator.hasNext();) {
//			bomb_pair_pos= (Pair<Integer , Integer>)iterator.next(); //35, 100, 70, 66, 11, 44, 75, 87, 88, 90, 
//			bomb_grid = explode(i , j , bomb_grid);		
//		}
//	}

			for(int i = 0; i<bomb_grid.length; i++)				// first of all, i need to know where the bombs are				  
			{	
				for(int j = 0; j<bomb_grid[i].length(); j++)
				{				
					if(boom_map[i][j] == true)
						bomb_grid = explode(i , j , bomb_grid);				
					else{}   // there is a boom 
					
				}
			}
	return bomb_grid;
}

public static String[] explode(int first_index , int second_index, String[] bomb_grid)
{		
	int static_count = 5;
	int First_index = -1; 
	int Second_index = -1;
	while(static_count > 0)
	{
		if(static_count == 5)
		{
			First_index = first_index ;
			Second_index = second_index;	
			//System.out.println("static_count " + static_count +" first_index : " + First_index + " second_index " + Second_index);
		}
		else if(static_count == 4)
		{
			First_index = first_index - 1;
			Second_index = second_index;
			//System.out.println("static_count " + static_count +" first_index : " + First_index + " second_index " + Second_index);
		}

		else if(static_count == 3)
		{
			First_index = first_index + 1;
			Second_index = second_index;
			//System.out.println("static_count " + static_count +" first_index : " + First_index + " second_index " + Second_index);
		}

		else if(static_count == 2)
		{
			First_index = first_index ;
			Second_index = second_index - 1;
			//System.out.println("static_count " + static_count +" first_index : " + First_index + " second_index " + Second_index);
		}

		else if(static_count == 1)
		{
			First_index = first_index ;
			Second_index = second_index + 1;
			//System.out.println("static_count " + static_count +" first_index : " + First_index + " second_index " + Second_index);
		}
		if( ( First_index < 0 ) || ( Second_index < 0) || ( First_index > bomb_grid.length - 1 ) || ( Second_index > bomb_grid[0].length() -1 ) ){}
		else{
			for(int i = 0; i<bomb_grid.length; i++)							  
			{					
				for(int j = 0; j<bomb_grid[i].length(); j++)
				{	
					if(i == First_index && j == Second_index)					
					{
						StringBuilder builder = new StringBuilder(bomb_grid[First_index]);
						builder.setCharAt(Second_index, '.'); 
						bomb_grid[First_index] = builder.toString(); 							// adding a bomb !
					}
					else  // there is a boom 
					{} 
				}
			}
		}
		static_count -= 1;
	}
	return bomb_grid;
}

public static String[] bomberMan(int n_sec, String[] bomb_grid) {

	int char_count = bomb_grid[0].length();		
	int bomb_state = after_one_sec_state;
	boom_map = new Boolean[bomb_grid.length][char_count]; // draw boom map !
	//System.out.println("boom_map length : " +  boom_map.length + " boom_map char_count  : "+ char_count);
	while(n_sec > 0)
	{	
		//System.out.println(bomb_state);
		switch(bomb_state)
		{
		case after_one_sec_state:
			bomb_state = after_two_sec_state;
			check_bomb_pos(bomb_grid);
			break;
		case after_two_sec_state:	
			bomb_grid = fill_bombs(bomb_grid);
			bomb_state = after_three_sec_state;
			break;
		case after_three_sec_state:
			bomb_grid = explode_pos_check(bomb_grid);
			check_bomb_pos(bomb_grid);   		//bomb_pos array update with new bomb grid !
			bomb_state = after_two_sec_state;
			break;						
		}
		n_sec -= 1;
	}
	return bomb_grid;
}

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int row = in.nextInt();
	int characters = in.nextInt();
	int n_sec = in.nextInt();
	String[] bomb_grid = new String[row];
	for(int grid_i = 0; grid_i < row; grid_i++){
		bomb_grid[grid_i] = in.next();
	}
	String[] result = bomberMan(n_sec, bomb_grid);
	for (int i = 0; i < result.length; i++) {
		System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
	}
	System.out.println("");
	in.close();
}

public static class Pair<L,R> {
	private L l;
	private R r;
	private int first_point;
	private int second_point;

	public Pair(L l, R r){
		this.l = l;
		this.r = r;
	}
	//	  
	//	    public Pair(int First_point, int Second_point){
	//	        this.first_point = First_point;
	//	        this.second_point = Second_point;
	//	    }
	public L getL(){ return l; }
	public R getR(){ return r; }
	public void setL(L l){ this.l = l; }
	public void setR(R r){ this.r = r; }
	public int get_first_point(){ return first_point; }
	public int get_second_point(){ return second_point; }
	public void set_first_point(int First_point){ this.first_point = First_point; }
	public void set_second_point(int Second_point){ this.second_point = Second_point; }
}

}
