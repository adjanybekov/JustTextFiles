import java.util.*;
import java.lang.*;


public class MarsRoverOperation {

	/**
	 * The Mars Rover accepts instructions to move in the form of "LFFFRFFFRRFFF"
	 * where "L" => rotate 90 degrees left
	 *  	 "R" => rotate 90 degrees right
	 *    	 "F" => move forward one unit
	 * 
	 *
	 * Example:
	 * 		 For input "FFRF", the result should be [1,2].
	 */

	/**
	 * This method moves the Mars Rover, according to the instructions passed in the input.
	 *
	 * @param input Instructions in the format "FFLR"
	 * @return final position of the robot in the format [1,2]
	 */
   enum Direction{
     North,West,South,East
   }
	public static String move(String input) {
		int n = input.length();
    	Direction[] directions = {Direction.North,Direction.West,Direction.South,Direction.East};    
		int curCord[]={0,0};//x,y
		Direction curDir = Direction.North;

		for(int i=0; i<n; i++){
			char c = input.charAt(i);

			if(c=='F'){
		        switch (curDir) 
		        { 
		          case North: 
		              curCord[1]++;
		              break; 
		          case South: 
		              curCord[1]--;
		              break; 
		          case East:
		              curCord[0]++;
		              break;
		          case West: 
		              curCord[0]--;
		              break;
		        }
			}else if(c=='R'){      
        		curDir = directions[Math.floorMod(curDir.ordinal()-1,4)];
			
			}else if(c=='L'){        
				curDir = directions[Math.floorMod(curDir.ordinal()+1,4)];
			}
      
		}

		return Arrays.toString(curCord);

	}

	/**
	 * Your application also accepts the move input as a command-line argument.
	 */
	public static void main(String argv[]) {
		Scanner in = new Scanner(System.in);

		String input = in.next();
		System.out.println(move(input));
	}

}
