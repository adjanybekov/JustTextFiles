import java.util.*;
import java.lang.*;

public class Main {
  public static Scanner in ;


  public static long power(long x, long y, long p) 
    { 
        // Initialize result 
        long res = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
      
        while (y > 0) 
        { 
            // If y is odd, multiply x 
            // with result 
            if((y & 1)==1){
                res = (res * x) % p; 
                //System.out.println(res);
            } 
              
      
            // y must be even now 
            // y = y / 2 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 

  public static long solve(){
   
    long n = in.nextLong();
    long f1 = in.nextLong();
    long f2 = in.nextLong();
    long f3 = in.nextLong();
    long c = in.nextLong();

    long p = (2*((n*(n+1))/2 - 6))- ((n-3)*6);

   long res = power(c,p, (long)(Math.pow(10,9)+7)); 
    // f1 = power(f1,n-3,(long)(Math.pow(10,9)+7));  
    // f2 = power(f2,n-3,(long)(Math.pow(10,9)+7));
    // f3 = power(f3,n-3,(long)(Math.pow(10,9)+7));
    long rest = f1*f2*f3;
    rest =  power(rest,n-3,(long)(Math.pow(10,9)+7));

    System.out.println(res+","+f1+","+f2+","+f3);
    // res=(res*f1)% (long)(Math.pow(10,9)+7);
    // res=(res*f2)% (long)(Math.pow(10,9)+7);
    // res=(res*f3) % (long)(Math.pow(10,9)+7);
    return (res*rest)%(long)(Math.pow(10,9)+7);//(res*f1*f2*f3) % (long)(Math.pow(10,9)+7);

  }

  public static void main(String[] args) {
    

    in = new Scanner(System.in);

    long res = solve();

    System.out.println(res);
    
  }
}
