import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class backTracking1715 {

    public String longestWord(String[] words) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(words));
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o2.length() - o1.length();
            }
        });

        for(String word : arrayList) {
            if(backTracking(arrayList,0,word)) return word;
        }

        return "";
    }

    public boolean backTracking(ArrayList<String> list,int start,String target) {
        if(start == target.length()) return true;
        for(int end = start;end<target.length();end++){
            if(end - start +1 == target.length()) return false;
            String prev = target.substring(start, end + 1);
            if(list.contains(prev) && backTracking(list,end+1,target)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] arrs = {"cat","banana","dog","nana","walk","walker","dogwalker"};
        backTracking1715 obj = new backTracking1715();
        String s = obj.longestWord(arrs);
        System.out.println(s);
    }


}
