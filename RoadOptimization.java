/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
// 		int maxTravelDist=7000;
//         int[][] forwardRouteList={{1,2000},{2,4000},{3,6000}};
//         int[][] returnRouteList={{1,2000}};
        
        
        int maxTravelDist=10000;
        int[][] forwardRouteList={{1,3000},{2,5000},{3,7000},{4,10000}};
        int[][] returnRouteList={{1,2000},{2,3000},{3,4000},{4,5000}};
        int[][] array = solve(forwardRouteList,returnRouteList,maxTravelDist);
        
        
        System.out.println(Arrays.deepToString(array));
        // System.out.println(Arrays.asList());
	}
	
	public static int[][] solve(int[][] forwardRouteList,int[][]returnRouteList, int maxTravelDist){
	    
	    //it has to be the biggest, if possible maxTravelDist
	    
	    //find biggest possible O(n*m)
	    int biggest = Integer.MIN_VALUE;
	    for(int i=0; i<forwardRouteList.length;i++){
	        for(int j=0; j<returnRouteList.length; j++){
	            int cur  = forwardRouteList[i][1]+returnRouteList[j][1];
	            if(cur<=maxTravelDist){
	                biggest = Math.max(cur,biggest);    
	            }
	            
	        }
	    }
	    System.out.println(biggest);
	    
	    // find all possible and return O(n*m)
	    List<List<Integer>> res = new ArrayList<>();
	    
	    for(int i=0; i<forwardRouteList.length;i++){
	        for(int j=0; j<returnRouteList.length; j++){
	            int cur  = forwardRouteList[i][1]+returnRouteList[j][1];
	            if(cur==biggest){
	                List<Integer> l = new ArrayList<>();
	                l.add(forwardRouteList[i][0]);
	                l.add(returnRouteList[j][0]);
	                res.add(l);
	            }
	        }
	    }
	    
	    int[][] resArr = new int[res.size()][2];
	    
	    for(int i=0; i<res.size(); i++){
	        resArr[i][0] = res.get(i).get(0);
	        resArr[i][1] = res.get(i).get(1);
	    }
	    
	    return resArr;
	    
	    
	    // can we use same thing 1+ times ?
	    
	    
	    //complexities??? O(2*n*m+ 2*n*m) time O(2*n*m)
	}
}
