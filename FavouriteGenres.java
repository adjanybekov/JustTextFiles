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
		
// 		userSongs = {  
//               "David": ["song1", "song2", "song3", "song4", "song8"],
//               "Emma":  ["song5", "song6", "song7"]
//             };
            
            Map<String,List<String>> userSongs = new HashMap<>();
            
            userSongs.put("David",new ArrayList<>(Arrays.asList("song1", "song2")));
            userSongs.put("Emma",new ArrayList<>(Arrays.asList("song3", "song4")));
            
            
            Map<String,List<String>> songGenres = new HashMap<>();
            // songGenres.put("Rock",new ArrayList<>(Arrays.asList("song1", "song3")));
            
            // songGenres.put("Dubstep",new ArrayList<>(Arrays.asList("song7")));
            // songGenres.put("Techno",new ArrayList<>(Arrays.asList("song2", "song4")));
            // songGenres.put("Pop",new ArrayList<>(Arrays.asList("song5", "song6")));
            // songGenres.put("Jazz",new ArrayList<>(Arrays.asList("song8", "song9")));
            
            Map<String,List<String>>  res = solve(userSongs,songGenres);
            System.out.println(res);
            
        // songGenres = {  
        //   "Rock":    ["song1", "song3"],
        //   "Dubstep": ["song7"],
        //   "Techno":  ["song2", "song4"],
        //   "Pop":     ["song5", "song6"],
        //   "Jazz":    ["song8", "song9"]
        // }
	}
	
	static Map<String,List<String>> solve( Map<String,List<String>>userSongs, Map<String,List<String>> genresSongs){
	    //
	    
	    //map of genresSongs
	    Map<String,String>  songGenres = new HashMap<>();
	    for(String k: genresSongs.keySet()){
	        List<String>  l = genresSongs.get(k);
	        
	        for(String s: l){
	            songGenres.put(s,k);
	        }
	    }
	    System.out.println(songGenres+"songGenres");
	    //get freq of genres of a user
	    Map<String,Map<String,Integer>> freq = new HashMap<>();
	    
	    for(String k: userSongs.keySet()){
	         
	        List<String>  l = userSongs.get(k);
	        Map<String,Integer> fr = new HashMap<>();
	        for(String s: l){
	            if(songGenres.get(s)!=null)
	            fr.put(songGenres.get(s),fr.getOrDefault(songGenres.get(s),0)+1);
	        }
	        freq.put(k,fr);
	    }
	    
	    
	    
	    System.out.println(freq);
	    //take biggets ones into result
	    
	    Map<String,List<String>>  resMap = new HashMap<>();
	    
	     for(String k: freq.keySet()){
	         Map<String,Integer>  m = freq.get(k);
	         List<String> l = new ArrayList<>();
	         int max= 0;
	         for(Map.Entry<String,Integer> e: m.entrySet()){
	             if(e.getValue()>max){
	                 l = new ArrayList<>();
	                 l.add(e.getKey());
	                 max = e.getValue();
	             }else if(e.getValue()==max){
	                 l.add(e.getKey());
	             }
	         }
	         resMap.put(k,l);
	     }
	     
	     return resMap;
	    
	}
}
