/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) {
		int k = 2;
        String[] keywords = {"anacell", "cetracular", "betacellular"};
        String[] reviews = {
          "Anacell provides the best services in the city",
          "betacellular has awesome services",
          "Best services provided by anacell, everyone should use anacell",
        };
		
		
		List<String> kwrds = Arrays.asList(keywords);
		
		List<String> rvws = Arrays.asList(reviews);
     System.out.println(    solve(kwrds,rvws,k));
	}
	
	public static List<String> solve( List<String> keywords, List<String> reviews,int k){ 
        
        
        //  find most popular keywords
        
        //freq of keywords
        
        List<Set<String>> reviewSet = new ArrayList<>();
        
        for(String review: reviews){
           String[] rvArr = review.toLowerCase().split(" ");
           Set<String> set = new HashSet(Arrays.asList(rvArr) );
           reviewSet.add(set);
        }
        System.out.println(reviewSet);
        Map<String,Integer> map = new HashMap<>();
        for(String keyword: keywords){
            for(Set<String> review: reviewSet){
                if(review.contains(keyword)){
                    map.put(keyword,map.getOrDefault(keyword,0)+1);
                }else{
                    map.put(keyword,map.getOrDefault(keyword,0)+1);
                }
            }
        }
        
        
        //sort by riles
        
        List<String> l = new ArrayList<>(map.keySet());
        
        System.out.println(l);
        Collections.sort(l, (w1,w2)->map.get(w1)==map.get(w2)?
                                                        w1.compareTo(w2):map.get(w2)-map.get(w1));
        
        
        //get top keywords
        
        
	    return l.subList(0,k);
	    
	}
}
