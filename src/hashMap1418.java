
import java.util.*;

public class hashMap1418 {

    //输入：orders = [["David","3","Ceviche"],
    // ["Corina","10","Beef Burrito"],
    // ["David","3","Fried Chicken"],
    // ["Carla","5","Water"],
    // ["Carla","5","Ceviche"],
    // ["Rous","3","Ceviche"]]
    //输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],
    // ["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
    //
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> hashSet = new TreeSet<>();
        //key:table value:order
        HashMap<Integer,HashMap<String,Integer>> hashMap = new HashMap<>();
        for(List<String> order : orders) {
            //insert into hashSet
            String target = order.get(order.size()-1);
            hashSet.add(target);
            int key = Integer.parseInt(order.get(1));
            if(hashMap.containsKey(key)) {
                HashMap<String, Integer> temp = hashMap.get(key);
                temp.put(target,temp.getOrDefault(target,0)+1);
            }else{
                HashMap<String,Integer> temp =new HashMap<>();
                temp.put(target,1);
                hashMap.put(key,temp);
            }
        }
        //order
        List<Map.Entry<Integer,HashMap<String,Integer>>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, HashMap<String, Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, HashMap<String, Integer>> o1, Map.Entry<Integer, HashMap<String, Integer>> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        //print
        List<List<String>> rst = new ArrayList<>();
        //first
        List<String> first = new ArrayList<>();
        first.add("Table");
        first.addAll(hashSet);
        rst.add(first);
        for(Map.Entry<Integer,HashMap<String,Integer>> keyValue : list) {
            List<String> temp = new ArrayList<>();
            int tableIndex = keyValue.getKey();
            temp.add(tableIndex+"");
            for(String order : hashSet) {
                int val = keyValue.getValue().getOrDefault(order,0);
                temp.add(val+"");
            }
            rst.add(temp);
        }

        return rst;
    }

    public static void main(String[] args) {

    }
}
