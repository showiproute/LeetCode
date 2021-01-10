import java.util.*;

public class disifanshi2 {

    static class Point  {
        int x;
        int y;
        public  Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

//    public static int solution2(ArrayList<Point> list,int n ){
//        Collections.sort(list, new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                return o1.x - o2.x;
//            }
//        });
//
//        int maxValue =Integer.MIN_VALUE;
//
//        for(int i =0;i<n;i++){
//            int left = list.get(i).x;
//            int right = list.get(i).y;
//            for(int j =i+1;j<n;j++){
//                if(list.get(j).x <=right && list.get(j).y >=right){
//                    right = list.get(j).y;
//                }
//            }
//            maxValue = Math.max(maxValue,right-left);
//        }
//
//        return maxValue;
//    }

    public static int solution(ArrayList<Point> list,int n ) {
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        int left = list.get(0).x;
        int right = list.get(0).y;
        int maxValue = right-left;

        for(int i =1;i<n;i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            if( x<=right && y>=right) {
                right = y;
                maxValue = Math.max(maxValue,right-left);
            }else if(x<=right && y<=right) {
                continue;
            }else if(x>right) {
                left = x;
                right = y;
                maxValue = Math.max(maxValue,right-left);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<Point> arrayList = new ArrayList<>();
            for(int i =0;i<n;i++){
                String[] s = sc.nextLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                Point p = new Point(x, y);
                arrayList.add(p);
            }
            int solution = solution(arrayList, n);
            System.out.println(solution);
        }

    }
}
