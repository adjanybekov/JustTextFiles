/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		//
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		int d = solve(root,root.left,root.right.right);
		System.out.println(d);
	}
	
	public static int solve(TreeNode root,TreeNode p,TreeNode q){
	    //find min distance between nodes
	    //least common ancestor
	    TreeNode lca = lca(root,p,q);
	    
	    //find distance from lca to both nodes
	    return distance(lca,p)+
	    distance(lca,q);
	    
	    
	    //return sum of distances
	}
	
	static int distance(TreeNode src,TreeNode target){
	    int d = 0;
	    
	    TreeNode tmp  =src;
	    
	    while(tmp!=target){
	        d++;
	        if(tmp.val>target.val){
	            tmp =  tmp.left;
	        }else{
	            tmp = tmp.right;
	        }
	    }
	    return d;
	}
	
	static TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
	    
	    TreeNode tmp = root;
	    TreeNode res = null;
	    while(tmp!=null){
	        res = tmp;
	        if(tmp.val>p.val && tmp.val>q.val){
	            tmp = tmp.left;
	        }else if(tmp.val<p.val && tmp.val<q.val){
	            tmp = tmp.right;
	        }else{
	            return tmp;
	        }
	    }
	    return null;
	}
}
