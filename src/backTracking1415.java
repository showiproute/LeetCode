import java.util.ArrayList;

public class backTracking1415 {

    ArrayList<String> rst = new ArrayList<>();

    public String getHappyString(int n, int k) {
        char[] array = {'a','b','c'};
        dfs(array,0,n,new StringBuilder());

        if(rst.size()<k){
            return "";
        }else{
            return rst.get(k-1);
        }
    }

    public void dfs(char[] array,int index,int n,StringBuilder temp ) {
        if(index == n) {
            rst.add(temp.toString());
            return;
        }

        for(int i = 0;i<array.length;i++){
            if(temp.length() > 0 && array[i] == temp.charAt(temp.length()-1)){
                continue;
            }
            temp.append(array[i]);
            dfs(array,index+1,n,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        backTracking1415 obj = new backTracking1415();
        String happyString = obj.getHappyString(1, 4);
        System.out.println(happyString);
    }
}
