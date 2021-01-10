import java.util.*;

public class dfs332 {

    HashMap<String, List<String>> adjMap = new HashMap<>();
    public List<List<String>> tickets = new ArrayList<>();
    public List<String> rst = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return new ArrayList<>();
        this.tickets = tickets;

        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!adjMap.containsKey(from)) {
                List<String> temp = new ArrayList<>();
                temp.add(to);
                adjMap.put(from,temp);
            }else {
                List<String> temp = adjMap.get(from);
                temp.add(to);
                Collections.sort(temp);
                adjMap.put(from,temp);
            }
        }
        //test
//        for(Map.Entry<String,List<String>> keyValue : adjMap.entrySet()) {
//            System.out.println(keyValue.getKey());
//            System.out.println(keyValue.getValue());
//        }


        dfs("JFK");
        Collections.reverse(rst);
        return rst;
    }

    public void dfs(String from) {
        while(adjMap.containsKey(from) && adjMap.get(from).size() > 0) {
            String to = adjMap.get(from).get(0);
            adjMap.get(from).remove(0);
            dfs(to);
        }
        rst.add(from);
    }


    public static void main(String[] args) {
//        输入[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
//        输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
        List<List<String>> inputList = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("MUC");
        l1.add("LHR");
        List<String> l2 = new ArrayList<>();
        l2.add("JFK");
        l2.add("MUC");
        List<String> l3 = new ArrayList<>();
        l3.add("SFO");
        l3.add("SJC");
        List<String> l4 = new ArrayList<>();
        l4.add("LHR");
        l4.add("SFO");
        List<String> l5 = new ArrayList<>();
        l5.add("ATL");
        l5.add("SFO");
        inputList.add(l1);
        inputList.add(l2);
        inputList.add(l3);
        inputList.add(l4);
//        inputList.add(l5);
        dfs332 obj = new dfs332();
        List<String> itinerary = obj.findItinerary(inputList);
        System.out.println(itinerary.toString());
    }


}

