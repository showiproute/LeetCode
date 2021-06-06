public class dfs1849 {

    /*
    输入：s = "1234"
输出：false
解释：不存在拆分 s 的可行方法。
示例 2：

输入：s = "050043"
输出：true
解释：s 可以拆分为 ["05", "004", "3"] ，对应数值为 [5,4,3] 。
满足按降序排列，且相邻值相差 1 。
示例 3：

输入：s = "9080701"
输出：false
解释：不存在拆分 s 的可行方法。
示例 4：

输入：s = "10009998"
输出：true
解释：s 可以拆分为 ["100", "099", "98"] ，对应数值为 [100,99,98] 。
满足按降序排列，且相邻值相差 1 。
     */
    public boolean splitString(String s) {
        long pre = 0;
        for(int i = 0;i<s.length()-1;i++){
            pre = pre*10 + s.charAt(i) - '0';
            if(pre > 10000000000L) return false;
            if (dfs(s,pre,i+1)) return true;
        }

        return false;
    }

    public boolean dfs(String s,long pre,int index) {
        if(index == s.length()) return true;
        long cur = 0;
        for(int i = index;i<s.length();i++){
            cur = cur*10+s.charAt(i) - '0';
            if(cur > 10000000000L) return false;
            if(pre <= cur) return false;
            if(pre - 1 == cur && dfs(s,cur,i+1)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        dfs1849 obj = new dfs1849();
        String s = "10009998";
        boolean b = obj.splitString(s);
        System.out.println(b);
    }

}
