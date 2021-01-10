import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tree1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> rst = new ArrayList<>();
        if(root1 == null && root2  ==null) return rst;
        dfs(root1,rst);
        dfs(root2,rst);
        Collections.sort(rst);
        return rst;
    }

    public void dfs(TreeNode root,List<Integer> list) {
        if(root!=null){
            dfs(root.left,list);
            list.add(root.val);
            dfs(root.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(4);
        t1.left =p1;
        t1.right=p2;

        TreeNode t2 = new TreeNode(1);
        TreeNode pp1 = new TreeNode(0);
        TreeNode pp2 = new TreeNode(3);
        t2.left=pp1;
        t2.right=pp2;
        tree1305 obj = new tree1305();
        List<Integer> allElements = obj.getAllElements(t1, t2);
        System.out.println(allElements.toString());

    }

}
