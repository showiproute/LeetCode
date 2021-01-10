public class dfs1306 {

    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0 || start < 0 || start > arr.length) return false;
        return dfs(arr,start,new boolean[arr.length]);
    }

    public boolean dfs(int[] arr,int start,boolean[] visited) {
        if(start < 0 || start >= arr.length || visited[start]) return false;
        if(arr[start] == 0) return true;
        visited[start] = true;

        boolean left = dfs(arr,start-arr[start],visited);
        boolean right = dfs(arr,start+arr[start],visited);
        return left || right;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        dfs1306 obj = new dfs1306();
        boolean b = obj.canReach(arr, 2);
        System.out.println(b);
    }

}
