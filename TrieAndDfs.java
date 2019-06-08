import java.util.*;
import java.lang.*;

class Main {


    
    static class Pair{
        int index;
        int value;
        
        Pair(int i,int v){
            index=i;
            value=v;
        }
        
        int getVal(){
            return value;
        }
    }
    
    static class Node{
        char letter;
        List<Node> children;
        boolean end;
        Node(char l){
            letter = l;
            children = new ArrayList<>();
            end = false;
        }
    }
    
    public static void dfs(Node n){

      if(n!=null){
        System.out.println(n.letter);
        for(Node child:n.children){
          dfs(child);
        }
      }
    }


    public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        
        int[] senteces = new int[B.size()];
        // HashSet<String> keys = new HashSet<>();
        
        String[] keyss = A.split("_");
        Node root = new Node(' ');
        
        //create trie for key words
        for(String w: keyss){
            Node cur=root;
            for(int i=0; i<w.length(); i++){
              char c =  w.charAt(i);
                
                //idea is to skip nodes that exist and to add ones which don't exist in the trie
                boolean found=false;
                //go over children of current node and if one of them equal to curChar then cur=child and pass
                for(Node child: cur.children){
                    if(child.letter == c){
                        cur = child;
                        found=true;
                        break;
                    }
                }
                
                if(!found){
                    Node n = new Node(c);
                    cur.children.add(n);                    
                    cur = n;
                }
                if(i==w.length()-1){
                  cur.end=true;
                }
            }    
        }
        
        //dfs(root);
        
        
        for (int i=0; i<B.size();i++){
            String[] words = B.get(i).split("_");
            //System.out.println(Arrays.toString(words));
            for(String word: words){
                //check existence of that full word in trie
                //if it does make res++
                boolean found=false;
                Node cur = root;
                
                for(int k =0; k<word.length();k++){
                    char c = word.charAt(k);
                    boolean letterFound=false;
                    //if in the whole iteration the letter wasn't found then return false
                    for(int j=0; j<cur.children.size(); j++){
                      //System.out.printf("%s %s\n",cur.children.get(j).letter,c);
                        if(cur.children.get(j).letter==c){
                            cur = cur.children.get(j);
                            letterFound=true;
                            break;
                        }
                    }
                    if(!letterFound){//word is not found so   break the loop
                        break;
                    }
                    //System.out.println(letterFound+","+c);
                    if(k==word.length()-1 && cur.end){
                        found=true;
                    }
                }
                
                
                //check in the map
                if(found){
                    senteces[i]++;
                }
                //System.out.println(Arrays.toString(senteces));
            }
        }
        
        Pair[] pairs = new Pair[senteces.length];
        
        for (int i=0; i<B.size();i++){
            pairs[i] = new Pair(i,senteces[i]);
        }
        
        Arrays.sort(pairs,(o1,o2)-> o2.getVal()-o1.getVal() );
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i=0; i<B.size();i++){
            res.add(pairs[i].index);
            //System.out.println(pairs[i].value);
        }

        return res;

        
    }



  public static void main(String[] args) {
    
    String A = "cool_ice_wifi";
    ArrayList<String> B = new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));


    ArrayList<Integer> res = solve(A,B);
    for(Integer a:res){
      System.out.printf("%d,",a);
    }
    System.out.printf("\n");

  //https://www.interviewbit.com/problems/hotel-reviews/

  }
}
