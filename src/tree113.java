import java.util.ArrayList;
import java.util.List;

public class tree113 {

    List<List<Integer>> rst = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,new ArrayList<>(),sum);
        return rst;
    }

    public void dfs(TreeNode root,List<Integer> temp,int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(sum == root.val){
                temp.add(root.val);
                rst.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }

        temp.add(root.val);
        dfs(root.left,temp,sum-root.val);
        dfs(root.right,temp,sum-root.val);
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {

    }

}

