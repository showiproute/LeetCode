import java.util.*;

public class meituan01 {


    public static  int maxProfit(Integer[] items,Integer[] profit){
        HashMap<Character,Integer> amountMap = new HashMap<>();
        HashMap<Character,Integer> profitMap = new HashMap<>();
        for(int i =0 ;i<items.length;i++) {
            amountMap.put((char) ('a'+i),items[i]);
        }
        for(int i =0;i<profit.length;i++){
            profitMap.put((char)('a'+i),profit[i]);
        }
        List<Map.Entry<Character,Integer>> profitList = new ArrayList<>(profitMap.entrySet());
        profitList.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int sum  =0;
        int total = amountMap.get('d');
        int counts = 0;
        while(total > 0) {
            Map.Entry<Character, Integer> kv = profitList.get(counts);
            Character key = kv.getKey();
            Integer value = kv.getValue();
            Integer amount = amountMap.get(key);
            if(total > amount) {
                total-=amount;
                sum+=amount*value;
                counts++;
            }else{
                sum+=total*value;
                break;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] values = sc.nextLine().split(" ");
            Integer[] items = new Integer[4];
            Integer[] profit = new Integer[3];
            for(int i =0;i<4;i++){
                items[i] = Integer.parseInt(values[i]);
            }
            int counts = 0;
            for(int i =4;i<7;i++){
                profit[counts] = Integer.parseInt(values[i]);
                counts++;
            }
            int max = maxProfit(items, profit);
            System.out.println(max);
        }


    }
}
