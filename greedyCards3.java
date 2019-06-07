import java.util.*;
import java.lang.*;

public class Main {
public static Scanner in;
public static int countSorted(int n,int sortedCount,HashMap<Integer,Integer> hand){
  
  for(int i=sortedCount+1; i<=n; i++){
    if(hand.containsKey(i)){
      sortedCount++;
    }else{
      break;
    }
  }
  return sortedCount;
}
public static void solve(int n){
  Queue<Integer>  q = new LinkedList<>();
  HashMap<Integer,Integer> map  = new HashMap<>();  

  for(int i=0; i<n; i++){
    int h = in.nextInt();

    if(map.containsKey(h)){
      map.put(h,map.get(h)+1);
    }else{
      map.put(h,1);
    }
  }
  
  int sortedCount = countSorted(n, 0, map);

  int end =0;

  for(int i=0; i<n; i++){
    int p = in.nextInt();
    if(i==n-1){
      end=p;
    }
    q.add(p);
  }

  int res=0;

  while(sortedCount < n/2){

    //push in 0 and take away to element
    q.add(0);
    map.put(0,map.get(0)-1);

    int top = q.poll();
    map.put(top, top==0? (map.get(0)+1):1 );    
    sortedCount = countSorted(n, sortedCount, map);
    res++;
  }

  res+=map.size()-1;

  System.out.println(res);



}

  public static void main(String[] args) {
    

    in = new Scanner(System.in);

    int n = in.nextInt();
    solve(n);
    
    /*    
    if(x==y & z==0){
      res = 0;
    }
    //when it becomes poistive?
    x>y and x>(y+z)

    //when negative?
    x<y and y>(x+z)

  unknown if Math.abs(x-y)<=z
    else{
      
    }

    
    */
   
    
  }
}
