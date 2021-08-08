import java.util.Arrays;

public class comparator274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        //0,1,3,5,6
        int i = citations.length-1;
        int h = 0;
        while (i >=0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] citations = {100};
        comparator274 obj = new comparator274();
        int i = obj.hIndex(citations);
        System.out.println(i);
    }

}
