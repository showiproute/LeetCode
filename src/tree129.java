import java.util.ArrayList;

public class tree129 {

    ArrayList<String> rst = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if(root == null ) return 0;

        dfs(root,new StringBuilder());
        int sum = 0;
        for(int i = 0;i<rst.size();i++){
            System.out.println(rst.get(i));
            sum+=Integer.parseInt(rst.get(i));
        }

        return sum;
    }

    public void dfs(TreeNode root,StringBuilder sb) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sb.append(root.val);
            rst.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(root.val);
        dfs(root.left,sb);
        dfs(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode p9 = new TreeNode(9);
        TreeNode p0 = new TreeNode(0);
        TreeNode p5 = new TreeNode(5);
        TreeNode p1= new TreeNode(1);
        root.left =p9;
        root.right=p0;
        p9.left =p5;
        p9.right=p1;
        tree129 obj = new tree129();
        int i = obj.sumNumbers(root);
        System.out.println(i);
    }


}
