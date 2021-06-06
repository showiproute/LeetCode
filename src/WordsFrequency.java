import java.util.HashMap;

public class WordsFrequency {

    //WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
    //wordsFrequency.get("you"); //返回0，"you"没有出现过
    //wordsFrequency.get("have"); //返回2，"have"出现2次
    //wordsFrequency.get("an"); //返回1
    //wordsFrequency.get("apple"); //返回1
    //wordsFrequency.get("pen"); //返回1
    //
    HashMap<String,Integer> hashMap = new HashMap<>();
    public WordsFrequency(String[] book) {
        for(int i = 0;i<book.length;i++){
            hashMap.put(book[i],hashMap.getOrDefault(book[i],0)+1);
        }
    }

    public int get(String word) {
        return hashMap.getOrDefault(word, 0);
    }

    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        int you = wordsFrequency.get("you");//返回0，"you"没有出现过
        System.out.println(you);
        wordsFrequency.get("have"); //返回2，"have"出现2次
        wordsFrequency.get("an"); //返回1
        wordsFrequency.get("apple"); //返回1
        wordsFrequency.get("pen"); //返回1
    }
}
