import java.util.*;
import java.lang.*;
class Main {
  public static String solve(String s){
      if(s.length()==0) return "";

      String[] split = s.substring(0,s.length()-1).split("\\s+");

      Comparator<String> lengthComparator = new Comparator<String>() {
    		@Override    
			public int compare(String o1, String o2) {
        		return Integer.compare(o1.length(),o2.length());
    		}
		};

    Arrays.sort(split,lengthComparator);

    StringBuilder res = new StringBuilder();
    res.append(split[0].substring(0,1).toUpperCase()+split[0].substring(1,split[0].length()));
    for(int i=1; i<split.length; i++){
      res.append(" ");
      res.append(split[i].toLowerCase());
    }
    res.append(".");

    return res.toString();

  }


  public static void main(String[] args) {
    
    String s = "Love you i world.";

    System.out.println(solve(s));
  }
}
