import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class tree0412 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        dfs(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return counts;
    }

    public int counts = 0;

    public void dfs(TreeNode root,int sum) {
        if(root == null) return;
        if(root.val == sum) {
            counts++;
        }
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }


}
