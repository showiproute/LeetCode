import java.util.ArrayList;
import java.util.Arrays;

public class backTracking60 {
    /*
    n=3 k =3
    1 2 3
    1 3 2
    2 1 3
    2 3 1
    3 1 2
    3 2 1
     */

    //暴力破解 时间复杂度过高 o(n^2)
//    public ArrayList<String> rst = new ArrayList<>();
//    public String target = "";
//
//    public String getPermutation(int n, int k) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 1;i<=n;i++){
//            sb.append(i+"");
//        }
//        backTracking(sb.toString(),new StringBuilder(),k);
////        System.out.println(rst.toString());
//        return rst.get(k-1);
//    }
//
//    public void backTracking(String s,StringBuilder temp,int k) {
//        if(temp.length() == s.length()) {
//            rst.add(temp.toString());
//            return;
//        }
//        if(rst.size() == k) {
//            target = rst.get(k-1);
//            return;
//        }
//
//        for(int i = 0;i<s.length();i++){
//            if(temp.toString().contains(s.charAt(i)+"")){
//                continue;
//            }
//            temp.append(s.charAt(i));
//            backTracking(s,temp,k);
//            temp.deleteCharAt(temp.length()-1);
//        }
//    }

    public int[] factorial;
    public int k;
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i =1 ;i<=n;i++){
            sb.append(i);
        }
        this.factorial = new int[n+1];
        this.factorial[0] = 1;
        this.k = k;
        init(n);
        StringBuilder temp = new StringBuilder();
        backTracking(sb.toString(),temp);
        return temp.toString();
    }

    public void backTracking(String s,StringBuilder temp){
        if(temp.length() == s.length()) {
//            for(int i = 0;i<s.length();i++){
//                if(!temp.toString().contains(s.charAt(i)+"")){
//                    temp.append(s.charAt(i));
//                    break;
//                }
//            }
            return;
        }
        for(int i = 0;i<s.length();i++){
            if(temp.toString().contains(s.charAt(i)+"")) {
                continue;
            }
            int size = factorial[s.length()-temp.length()-1];
            if(k > size) {
                k-=size;
                continue;
            }
            temp.append(s.charAt(i));
            backTracking(s,temp);
        }

    }

    public void init(int n){
        for(int i  =1;i<=n;i++){
            factorial[i] = calFactorial(i);
        }
    }

    public int calFactorial(int n ){
        int sum = 1;
        for(int i =1;i<=n;i++){
            sum*=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        backTracking60 obj = new backTracking60();
        String permutation = obj.getPermutation(3, 2);
        System.out.println(permutation);
    }

}

