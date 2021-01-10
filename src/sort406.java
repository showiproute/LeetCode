import java.util.Arrays;
import java.util.Comparator;

public class sort406 {

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[][]{};

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0]-o1[0];
                }
            }
        });

        int[][] rst = new int[people.length][people[0].length];
        for(int i = 0;i< people.length;i++) {
            int x = people[i][0];
            int y = people[i][1];
            if(rst[y] != null) {
                move(rst,y);
                rst[y] = new int[]{x,y};
            }else{
                rst[y] = new int[]{x,y};
            }
        }

        return rst;
    }

    public void move(int[][] rst,int index) {
        for(int i = rst.length-1;i>index;i--){
            rst[i] = rst[i-1];
        }
    }

    public static void main(String[] args) {
        //输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        //输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        int[][] people= {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        sort406 obj = new sort406();
        int[][] ints = obj.reconstructQueue(people);
        for(int i = 0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
