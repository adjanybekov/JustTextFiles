/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 1, 0, 1},
                         {0, 1, 0, 1, 0},
                         {0, 0, 0, 0, 1},
                         {0, 1, 0, 0, 0}};
                         
        System.out.println(solve(matrix));                         
                         
	}
	
	public static int solve(int[][] matrix){
	    //simulate process
	    //if  no soliution return -1, but -1 is not possible
	    int change=0;
	    int step =0;
	    
	    int[][] cur = matrix.clone();
	    boolean changed =true;
	    while(changed){
	        changed = false;
	        //cannot be done in place....
	        for(int i=0; i<matrix.length; i++){
	            for(int j=0; j<matrix[0].length; j++){
	                if(matrix[i][j]!=0){
	                    //mark nbrs
	                    //left
	                    if(j-1>=0 && matrix[i][j-1]==0){ cur[i][j-1]=1;changed=true;}
	                    
	                    //right
	                    if(j+1<=matrix[0].length-1 &&matrix[i][j+1]==0){cur[i][j+1]=1;changed=true;}
	                    
	                    //up
	                    if(i-1>=0 && matrix[i-1][j]==0){cur[i-1][j]=1;changed=true;}
	                    
	                    //down
	                    if(i+1<=matrix.length-1 && matrix[i+1][j]==0){cur[i+1][j]=1;changed=true;}
	                    
	                }
	            }
	        }
    	    step++;
    	    matrix = cur.clone();
	    }
	    //check if there are any 0 left
	    
	     for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                  return -1;
                }
            }
        }
	    return step;
	    
	    // complexity of this soluition is ...
	    // O(m*n* (max(n,m)-1) )
	    
	    
	    
	}
}
