import java.util.*;

public class bfs127 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hashSet = new HashSet<>(wordList);
        if(!hashSet.contains(endWord)){
            return 0;
        }
        hashSet.remove(beginWord);
        //test
//        System.out.println("hashSet"+hashSet.toString());

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps =0;

        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            //test
//            System.out.println("queue"+queue.toString());
//            System.out.println("visited"+visited.toString());
            for(int i= 0 ;i<size;i++){
                String word = queue.poll();
                visited.add(word);
                if(word.equals(endWord)) {
                    return steps;
                }
                char[] charArray = word.toCharArray();
                for(int j=0;j<charArray.length;j++){
                    for(char k ='a';k<='z';k++){
                        charArray[j] = k;
                        String tmp = new String(charArray);
                        if(hashSet.contains(tmp) && !visited.contains(tmp)){
                            visited.add(tmp);
                            queue.offer(tmp);
                        }
                    }
                    //恢复
                    charArray = word.toCharArray();
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord= "cog";
        List<String> wordList = new ArrayList<>();
//        "hot","dot","dog","lot","log","cog"
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        bfs127 obj = new bfs127();
        int i = obj.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
    }
}
