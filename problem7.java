import java.util.*;
import java.lang.*;
//21.51
class Main {

  static class Word{
    String word;
    int index;
    Word(String w, int i){
      word=w;
      index=i;
    }

    Word(){}
  }

  public static String solve(String s){
      if(s.length()==0) return "";

      String[] split = s.substring(0,s.length()-1).split("\\s+");

      Comparator<Word> lengthComparator = new Comparator<Word>() {
    		@Override    
			public int compare(Word o1, Word o2) {
        if(Integer.compare(o1.word.length(),o2.word.length())==0){
          return Integer.compare(o1.index,o2.index);
        }
        	return Integer.compare(o1.word.length(),o2.word.length());
    		}
		};
    Word[] sentence = new Word[split.length];
    for(int i=0; i<split.length; i++){
      Word w = new Word(split[i],i);
      sentence[i]=w;
    }

    Arrays.sort(sentence,lengthComparator);

    StringBuilder res = new StringBuilder();
    res.append(sentence[0].word.substring(0,1).toUpperCase()+sentence[0].word.substring(1,sentence[0].word.length()));
    for(int i=1; i<sentence.length; i++){
      res.append(" ");
      res.append(sentence[i].word.toLowerCase());
    }
    res.append(".");

    return res.toString();

  }


  public static void main(String[] args) {
    
    String s = "You elloh love me hello world.";

    System.out.println(solve(s));
  }
}
