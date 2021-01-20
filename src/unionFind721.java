import java.util.*;

public class unionFind721 {

    public class UF {
        public int counts;
        public HashMap<String,String> hashMap;
        public UF(){
            this.counts = 0;
            this.hashMap = new HashMap<>();
        }

        public void union(String p,String q){
            String rootP = find(p);
            String rootQ = find(q);
            if (rootP.equals(rootQ)) return;
            hashMap.put(rootP,rootQ);
            counts--;
        }

        public boolean isConnected(String p,String q) {
            String rootP = find(p);
            String rootQ = find(q);
            return rootP.equals(rootQ);
        }

        public String find(String p) {
            if(!hashMap.containsKey(p)){
                hashMap.put(p,p);
                counts++;
            }

            if(!hashMap.get(p).equals(p)){
                String par = hashMap.get(p);
                hashMap.put(p,find(par));
            }

            return hashMap.get(p);
        }

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> rst = new ArrayList<>();
        UF uf = new UF();
        if(accounts == null || accounts.size() == 0) return rst;
        for(List<String> account : accounts) {
            if(account.size() == 2) {
                uf.union(account.get(1),account.get(1));
                continue;
            }
            for(int j = 1;j<account.size()-1;j++){
                uf.union(account.get(j),account.get(j+1));
            }
        }

        //test
//        for(Map.Entry<String,String> keyVal : uf.hashMap.entrySet()){
//            System.out.println(keyVal.getKey()+"||||"+keyVal.getValue());
//        }
        //bfs
        HashSet<String> visited = new HashSet<>();
        for(Map.Entry<String,String> keyVal : uf.hashMap.entrySet()) {
//            if(!keyVal.getKey().equals(keyVal.getValue())) {
            if(visited.contains(keyVal.getKey()) || visited.contains(keyVal.getValue())) continue;
                String account = findAccount(keyVal.getKey(), accounts);
                Queue<String> queue = new LinkedList<>();
                ArrayList<String> result = new ArrayList<>();
                result.add(account);
                ArrayList<String> temp = new ArrayList<>();
                queue.offer(keyVal.getKey());
                bfs(uf.hashMap,visited,queue,temp);
                Collections.sort(temp);
                result.addAll(temp);
                if(result.size() >=2) {
                    rst.add(result);
                }
//            }
        }


        return rst;
    }

    public void bfs(HashMap<String,String> hashMap,HashSet<String> visited,Queue<String> queue,List<String> temp){
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size;i++){
                String node = queue.poll();
                if(visited.contains(node)) continue;
                temp.add(node);
                visited.add(node);
                for(Map.Entry<String,String> keyVal : hashMap.entrySet()) {
                    if(keyVal.getKey() == node) {
                        if(!visited.contains(keyVal.getValue())){
                            queue.offer(keyVal.getValue());
                        }
                    }
                    if(keyVal.getValue() == node) {
                        if(!visited.contains(keyVal.getKey())) {
                            queue.offer(keyVal.getKey());
                        }
                    }
                }
            }
        }
    }

    public String findAccount(String val,List<List<String>> accounts) {
        for(List<String> account : accounts) {
            if(account.contains(val)) return account.get(0);
        }
        return "";
    }


//[["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],
// ["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],
// ["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],
// ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],
// ["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> john = new ArrayList<>();
        john.add("John");
        john.add("johnsmith@mail.com");
        john.add("john00@mail.com");
        accounts.add(john);
        List<String> kevin = new ArrayList<>();
        kevin.add("Kevin");
        kevin.add("Kevin4@m.co");
        kevin.add("Kevin2@m.co");
        kevin.add("Kevin2@m.co");
        accounts.add(kevin);
        List<String> john3 = new ArrayList<>();
        john3.add("John");
        john3.add("johnsmith@mail.com");
        john3.add("john_newyork@mail.com");
        accounts.add(john3);
        List<String> mary = new ArrayList<>();
        mary.add("Mary");
        mary.add("mary@mail.com");
        accounts.add(mary);
        unionFind721 obj = new unionFind721();
        List<List<String>> lists = obj.accountsMerge(accounts);
        for(List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
}
