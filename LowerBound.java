import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


//|**|*|* [1,1], [5,6] ->2,3
class Result {

    /*
     * Complete the 'numberOfItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY startIndices
     *  3. INTEGER_ARRAY endIndices
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
    // Write your code here
        int n = startIndices.size();
        
        int arr[] = new int[s.length()];
        
        List<Integer> bars = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='*'){
                if(i==0){
                    arr[0]=1;
                }else{
                    arr[i]=arr[i-1]+1;
                }
            }else if(s.charAt(i)=='|'){
                if(i>0){
                    arr[i]=arr[i-1];    
                }                
                bars.add(i);
            }
        }
        // System.out.println(s);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(startIndices);
        // System.out.println(endIndices);
        
        List<Integer> res = new ArrayList<>();        
        for(int i=0; i<n; i++){
            int start = startIndices.get(i)-1;
            int end = endIndices.get(i)-1;
            
            
            
            // while(s.charAt(start)!='|'){
            //     start++;
            // }
            
            // for(int j=0; j<bars.size(); j++){
            //     if(bars.get(j)>=start){
            //         start = bars.get(j);
            //         break;
            //     }
            // }
            
            start = binarySearchClosestBarToTheRight(start,bars);
            
            // while(s.charAt(end)!='|'){
            //     end--;
            // }
            
            for(int j=bars.size()-1; j>=0; j--){
                if(bars.get(j)<=end){
                    end = bars.get(j);
                    break;
                }
            }
            
            // end = upper_bound(bars,0,bars.size()-1,end);//binarySearchClosestBarToTheLeft(end, bars);
            
            
            
            int starCount = Math.max(arr[end]-arr[start],0);
           
            res.add(starCount);
            
        }
                
        return res;
    }
    
    //bar greater than or equal to start, greatest lower bound
    static int binarySearchClosestBarToTheRight(int start, List<Integer> bars){
        int l=0,r=bars.size()-1;
        int res = -1;
        
        while(l<r){
            
            int mid = l+(r-l)/2;
            
            if(bars.get(mid) >= start){
                r = mid;            
            }else{
                l = mid+1;
            }
        }
        //we need a result that is greatest lower bound, which is equivalent to lefmost element of array
        return bars.get(l);
    }
    
    static int binarySearchClosestBarToTheLeft(int end, List<Integer> bars){
        int l=0, r=bars.size()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            
            if(bars.get(mid)<=end){
                l = mid+1;
            }else{
                r=mid;
            }
        }
        if(l < bars.size() && bars.get(l) <= end) {
            l++;
        }
        return bars.get(l);
    }
    
    
    static int upper_bound(List<Integer> arr, int low,
                int high, int X)
{
 
    // Base Case
    if (low > high)
        return low;
 
    // Find the middle index
    int mid = low + (high - low) / 2;
 
    // If arr[mid] is less than
    // or equal to X search in
    // right subarray
    if (arr.get(mid) <= X) {
        return upper_bound(arr, mid + 1,
                           high, X);
    }
 
    // If arr[mid] is greater than X
    // then search in left subarray
    return upper_bound(arr, low,
                       mid - 1, X);
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int startIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> startIndices = IntStream.range(0, startIndicesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int endIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> endIndices = IntStream.range(0, endIndicesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.numberOfItems(s, startIndices, endIndices);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
