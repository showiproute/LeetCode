import java.util.*;

public class pinduoduo2 {
    public static HashSet<Character> hashSet = new HashSet<>();
    public static void solution(String str) {
        for(int i = 0;i<str.length();i++){
            hashSet.add(str.charAt(i));
        }
        int end = hashSet.size();
        ArrayList<int[]> rst = new ArrayList<>();
//        System.out.println(hashSet.toString());

        for(int i =0;i<=str.length()-end;i++){
//            end = i+hashSet.size();
            for(int j = i;j<=str.length();j++){
                String subString = str.substring(i, j);
                if(isValid(subString)) {
                    int[] temp = {i,j-i};
                    rst.add(temp);
                    break;
                }
            }
        }
        //test
//        for(int i = 0;i<rst.size();i++){
//            System.out.println(Arrays.toString(rst.get(i)));
//        }

        Collections.sort(rst, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });

        System.out.print(rst.get(0)[0]);
        System.out.print(" ");
        System.out.print(rst.get(0)[1]);
    }

    public static boolean isValid(String subString) {
        for(Character item: hashSet){
            if(!subString.contains(item+"")){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext() ) {
            String inputStr = sc.nextLine();
            solution(inputStr);
        }
    }
}
