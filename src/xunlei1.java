import java.util.*;

public class xunlei1 {

    public static HashMap<String,String> hashMap = new HashMap<>();
    public static HashSet<String> hashSet = new HashSet<>();
    public static ArrayList<String> temp = new ArrayList<>();

    public static void process() {
        for(Map.Entry<String,String> keyValue : hashMap.entrySet()) {
            temp.remove(keyValue.getKey());
        }
        String lastNode = temp.get(0);
        ArrayList<String> rst = new ArrayList<>();
        rst.add(lastNode);
        int length = hashMap.size();
        int counts = 0;
        while(counts < length) {
            for(Map.Entry<String,String> keyValue : hashMap.entrySet()) {
                if(keyValue.getValue().equals(lastNode)) {
                    rst.add(keyValue.getKey());
                    lastNode = keyValue.getKey();
                    break;
                }
            }
            counts++;
        }

        Collections.reverse(rst);
        int j =0;
        for(;j<rst.size()-1;j++){
            System.out.print(rst.get(j)+" ");
        }
        System.out.print(rst.get(j));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            for(int i = 0;i<n;i++){
                String[] values = sc.nextLine().split(" ");
                hashMap.put(values[0],values[1]);
                if(!hashSet.contains(values[0])) {
                    temp.add(values[0]);
                    hashSet.add(values[0]);
                }
                if(!hashSet.contains(values[1])){
                    temp.add(values[1]);
                    hashSet.add(values[1]);
                }
            }
            process();
        }

    }

}
