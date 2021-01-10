import java.util.*;

public class digit399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashSet<String> allChar = new HashSet<>();
        HashMap<String,HashMap<String,Double>> hashMap = new HashMap<>();
        for(int i = 0;i<equations.size();i++){
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if(hashMap.containsKey(x)) {
                HashMap<String, Double> stringDoubleHashMap = hashMap.get(x);
                stringDoubleHashMap.put(y,values[i]);
            }else{
                HashMap<String,Double> temp = new HashMap<>();
                temp.put(y,values[i]);
                hashMap.put(x,temp);
            }

            if(hashMap.containsKey(y)) {
                HashMap<String, Double> stringDoubleHashMap = hashMap.get(y);
                stringDoubleHashMap.put(x,1/values[i]);
            }else{
                HashMap<String,Double> temp = new HashMap<>();
                temp.put(x,1/values[i]);
                hashMap.put(y,temp);
            }
            allChar.add(x);
            allChar.add(y);
        }
        //test
//        for(Map.Entry<String,HashMap<String,Double>> keyValue : hashMap.entrySet()) {
//            System.out.println(keyValue.getKey());
//            System.out.println(keyValue.getValue());
//        }
        double[] rst = new double[queries.size()];
        for(int i = 0;i<queries.size();i++){
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            //test
//            System.out.println("x:"+x+"y:"+y);
            if(!allChar.contains(x) || !allChar.contains(y)) {
                rst[i] = -1;
                continue;
            }
            if(x.equals(y)) {
                rst[i] = 1;
                continue;
            }
            rst[i] = dfs(x,y,hashMap,1.0,new HashSet<>());
        }

        return rst;
    }

    public double dfs(String x,String y,HashMap<String,HashMap<String,Double>> hashMap,double sum,HashSet<String> visited) {
        if(!hashMap.containsKey(x)){
            return -1;
        }
        HashMap<String, Double> stringDoubleHashMap = hashMap.get(x);
        visited.add(x);
        for(Map.Entry<String,Double> keyValue : stringDoubleHashMap.entrySet()) {
            String newX = keyValue.getKey();
            Double val = keyValue.getValue();
            if(visited.contains(newX)){
                continue;
            }
            if(newX.equals(y)) {
                return sum*val;
            }else{
                double dfs = dfs(newX, y, hashMap, sum * val, visited);
                if(dfs!=-1) return dfs;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        digit399 obj = new digit399();
        List<List<String>> equa = new ArrayList<>();
        ArrayList<String> e1 = new ArrayList<>();
        e1.add("x1");
        e1.add("x2");
        equa.add(e1);
        ArrayList<String> e2 = new ArrayList<>();
        e2.add("x2");
        e2.add("x3");
        equa.add(e2);
        ArrayList<String> e3 = new ArrayList<>();
        e3.add("x3");
        e3.add("x4");
        equa.add(e3);
        ArrayList<String> e4 = new ArrayList<>();
        e4.add("x4");
        e4.add("x5");
        equa.add(e4);

        double[] values = new double[equa.size()];
        values[0] = 3.0;
        values[1] = 4.0;
        values[2] = 5.0;
        values[3] = 6.0;
        List<List<String>> quer = new ArrayList<>();
        ArrayList<String> q1 = new ArrayList<>();
        q1.add("x1");
        q1.add("x5");
        quer.add(q1);
        ArrayList<String> q2 = new ArrayList<>();
        q2.add("x5");
        q2.add("x2");
        quer.add(q2);
        ArrayList<String> q3 = new ArrayList<>();
        q3.add("x2");
        q3.add("x4");
        quer.add(q3);
        ArrayList<String> q4 = new ArrayList<>();
        q4.add("x2");
        q4.add("x2");
        quer.add(q4);
        ArrayList<String> q5 = new ArrayList<>();
        q5.add("x2");
        q5.add("x9");
        quer.add(q5);

        double[] doubles = obj.calcEquation(equa, values, quer);
        System.out.println(Arrays.toString(doubles));
    }
            /*
[["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]]
[3.0,4.0,5.0,6.0]
[["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]
     */

}
