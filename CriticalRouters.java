/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
//check adj list,matrix are only for integers?

// complexity of bfs

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		//order of output?
		
		int[][] arr  = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
		int edgeCount = 7;
		int vertCount = 7;
		
		int[] res = solve(arr,vertCount,edgeCount);
		
		System.out.println(Arrays.toString(res));
		
	}
	/*     0 1 2 3 4 5 6
	    0 [0,1,1,0,0,0,0]
	    1 [1,0,0,1,0,0,0]
	    2 [1,0,0,1,0,1,0]
	    3 [0,1,1,0,1,0,0]
	    4 [0,0,0,1,0,0,0]
	    5 [0,0,1,0,0,0,1]
	    6 [0,0,0,0,0,1,0]
	*/
	
	public static List<Integer> bfs(int[][]graph,int v){
	    Queue<Integer> q = new LinkedList<>();
         List<Integer> l = new ArrayList<>();
         l.add(v);
	    q.offer(v);
	    boolean[] visited = new boolean[graph.length];
	    visited[v]=true;
	    
	    while(!q.isEmpty()){
	        int node = q.poll();
	        
	        for(int i=0; i<graph.length;i++){
	            if(graph[node][i]==1 && visited[i]==false){
	                visited[i]=true;
	                q.offer(i);
	                l.add(i);
	            }
	        }
	    }
	    
	    return l;
	    
	}
	public static boolean check(int[][] graph,int v){
        
        //take copy of graph
        //make all rows of node 0
        //make all cols of node 0
        
        
        int [][] myInt = new int[graph.length][];
        for(int i = 0; i < graph.length; i++)
            myInt[i] = graph[i].clone();
        
        for(int i=0; i<graph.length;i++){
            for(int j=0; j<graph.length; j++){
                if(i==v|| j==v){
                    graph[i][j]=0;
                }
            }
        }
	    
	    //bfs with matrix = O(v^2)
	    List<Integer> l = bfs(graph,(v+1)%graph.length);
	    
	    //copy back
        for(int i = 0; i < graph.length; i++)
            graph[i] = myInt[i].clone();
            
            
	    if(l.size()<graph.length-1){
	        return true;
	    }
	    return false;
	}
	public static int[] solve(int[][] verts,int vCount,int eCount){
	    //
	    int[][] graph = new int[vCount][vCount];
	    
	    for(int i=0;i<verts.length;i++){
	      graph[verts[i][0]][verts[i][1]]=1;
	      graph[verts[i][1]][verts[i][0]]=1;
	    }
	    	System.out.println(Arrays.deepToString(graph));
	    List<Integer> resList = new ArrayList<>();
	    
	    //remove node one by one
	    
	    // check if removal causes disconnection
	    //add node to resList
	    
	    //check == O(v^2)
	    for(int i=0; i<vCount; i++){
	        
	        if(check(graph,i)){
	            resList.add(i);
	        }
	        
	        
	    }
	    
	    
	    
	    return resList.stream().mapToInt(i->i).toArray();
	    //complexity =  O(v*v^2)-> O(v^3)
	}
}
