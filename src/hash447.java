import java.util.HashMap;
import java.util.Map;

public class hash447 {

    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length ==0) return 0;
        int cnts = 0;
        for(int i = 0;i<points.length;i++){
            HashMap<Double,Integer> hashMap = new HashMap<>();
            for(int j = 0;j<points.length;j++){
                if(i == j) continue;
                double length = getLength(points[i][0], points[i][1], points[j][0], points[j][1]);
                hashMap.put(length,hashMap.getOrDefault(length,0)+1);
            }
            for(Map.Entry<Double,Integer> keyValue : hashMap.entrySet()){
                if(keyValue.getValue() >= 2) {
                    cnts+=keyValue.getValue()*(keyValue.getValue()-1);
                }
            }
        }

        return cnts;
    }

    public double getLength(int x1,int y1,int x2,int y2){
        return (x1-x2) * (x1-x2)+(y1-y2)*(y1-y2);
    }

//[[0,0],[1,0],[-1,0],[0,1],[0,-1]]
    public static void main(String[] args) {
        int[][] points = {
                {0,0},
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        hash447 obj = new hash447();
        int i = obj.numberOfBoomerangs(points);
        System.out.println(i);
    }

}
