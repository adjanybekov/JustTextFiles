/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
// 		int[][] arr = {{5, 1},{4, 5}};
      int[][] arr = {{1, 2, 3},{4, 5, 1}};
		int res = solve(arr);
		System.out.println(res);

	}
	
	static int solve(int[][]arr){
	    if(arr.length==0)return 0;
	    int min = Integer.MAX_VALUE;
	    for(int i=1;i<arr[0].length; i++){
	        if(i==1){
	            continue;
	        }
	        arr[0][i] = Math.min(arr[0][i-1],arr[0][i]);
	    }
	    
	    for(int i=1;i<arr.length; i++){
	        if(i==1){
	            continue;
	        }
	        arr[i][0] = Math.min(arr[i-1][0],arr[i][0]);
	    }
	    
	    for(int i=1; i<arr.length; i++){
	        for(int j=1; j<arr[0].length; j++){
	            arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
	        }
	    }
	    return arr[arr.length-1][arr[0].length-1];
	}
}
