public class windows1208 {

    //暴力破解超时
//    public int equalSubstring(String s, String t, int maxCost) {
//        int maxWindowSize = s.length();
//        while (maxWindowSize >= 0 ){
//            for(int i = 0;i<s.length();i++) {
//                if(i+maxWindowSize > s.length()) break;
//                String sSub = s.substring(i, i + maxWindowSize);
//                String tSub = t.substring(i, i + maxWindowSize);
//                if(helper(sSub,tSub,maxCost)) {
//                    return maxWindowSize;
//                }
//            }
//            maxWindowSize--;
//        }
//
//        return 0;
//    }
//
//    public boolean helper(String sub,String t,int maxCost) {
//        int sum = 0;
//        for(int i = 0;i<sub.length();i++){
//            char a = sub.charAt(i);
//            char b = t.charAt(i);
//            int abs = Math.abs(a - b);
//            sum+=abs;
//        }
//
//        return sum <= maxCost;
//    }


    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int start = 0;
        int end = 0;
        int maxSize = 0;
        int sum = 0;
        for(;end<s.length();end++){
            sum+=cost[end];
            if(sum <= maxCost) {
                maxSize = Math.max(maxSize,end-start+1);
            }else{
                sum-=cost[start];
                start++;
            }
        }

        return maxSize;
    }
    //输入：s = "abcd", t = "bcdf", cost = 3
    //输出：3
    //解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
    //示例 2：
    //
    //输入：s = "abcd", t = "cdef", cost = 3
    //输出：1
    //解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
    //示例 3：
    //
    //输入：s = "abcd", t = "acde", cost = 0
    //输出：1
    //解释：你无法作出任何改动，所以最大长度为 1。
    public static void main(String[] args) {
        windows1208 obj  =new windows1208();
        String s=  "abcd";
        String t = "acde";
        int i = obj.equalSubstring(s, t, 0);
        System.out.println(i);
    }
}
