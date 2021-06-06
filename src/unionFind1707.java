import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class unionFind1707 {

    public class UF{
        public int counts;
        public HashMap<String,String> hashMap;
        public UF() {
            this.counts = 0;
            this.hashMap = new HashMap<>();
        }
        public void union(String p,String q){
            String rootP = find(p);
            String rootQ = find(q);
            if (rootP.equals(rootQ)) return;
            if(p.compareTo(q) <= 0) {
                hashMap.put(q,p);
            }else{
                hashMap.put(p,q);
            }
            counts--;
        }
        public boolean isConnected(String p,String q){
            String rootP = find(p);
            String rootQ = find(q);
            return rootP.equals(rootQ);
        }
        public String  find(String p) {
            if(!hashMap.containsKey(p)) {
                hashMap.put(p,p);
                counts++;
                return p;
            }

            if(!hashMap.get(p).equals(p)) {
                String  root = hashMap.get(p);
                hashMap.put(p,find(root));
            }

            return hashMap.get(p);
        }
    }


    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        if(names == null || names.length == 0 ||
                synonyms == null || synonyms.length == 0) return new String[]{};
//        HashMap<String,Integer> hashMap = new HashMap<>();
        UF uf = new UF();
//        for(int i = 0;i<names.length;i++){
//            String[] replace = names[i].replace("(", " ").replace(")", "").split(" ");
//            hashMap.put(replace[0],Integer.parseInt(replace[1]+""));
//        }
        for(int i = 0;i<synonyms.length;i++){
            String[] split = synonyms[i].replace("(", "").replace(")", "").split(",");
            uf.union(split[0],split[1]);
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<names.length;i++){
            String[] replace = names[i].replace("(", " ").replace(")", "").split(" ");
            String root = uf.find(replace[0]);
            map.put(root,map.getOrDefault(root,0)+Integer.parseInt(replace[1]+""));
        }
        String[] rst = new String[map.size()];
        int counts= 0;
        for(Map.Entry<String,Integer> keyVal : map.entrySet()) {
            rst[counts] = keyVal.getKey() + "(" + keyVal.getValue() + ")";
            counts++;
        }

        return rst;
    }

    //输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
    // synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
    //输出：["John(27)","Chris(36)"]
    public static void main(String[] args) {
        unionFind1707 obj = new unionFind1707();
        String[] names = {
                "John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"
        };
        String[] syn = {
                "(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"
        };
        String[] strings = obj.trulyMostPopular(names, syn);
        System.out.println(Arrays.toString(strings));
        System.out.println("John".compareTo("Jon"));
    }
}
