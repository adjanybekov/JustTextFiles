/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        String s = "abcabc";//"awaglknagawunagwkwagl";
        int k = 3;//4;
        List<String> l = solve(s,k);
        System.out.println(l);
	}
	
	static List<String> solve(String s,int k){
	    Set<String> set = new HashSet<>();
	    
	    for(int i=0; i<s.length()-k+1; i++){
	        String sb = s.substring(i,i+k);
	        
	        if(!set.contains(sb) && uniq(sb)){
	            set.add(sb);
	        }
	    }
	    
	    return new ArrayList<>(set);
	}
	
	static boolean uniq(String sb){
	    for(char c: sb.toCharArray()){
	        if(sb.indexOf(c)!=sb.lastIndexOf(c)){
	            return false;
	        }
	    }
	    return true;
	}
}
