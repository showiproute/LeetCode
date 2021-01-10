import java.util.ArrayList;

public class tree99 {

    public void recoverTree(TreeNode root) {
        if(root == null) return ;
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);

        int[] twoNode = findTwoNode(list);
        rebuild(root,twoNode[0],twoNode[1]);
        return;
    }

    public void rebuild(TreeNode root,int x,int y) {
        if(root!=null){
            rebuild(root.left,x,y);
            if(root.val == x) {
                root.val = y;
            }else if(root.val == y) {
                root.val = x;
            }
            rebuild(root.right,x,y);
        }
    }

    public void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root!=null){
            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }
    }

    public int[] findTwoNode(ArrayList<Integer> list){
        if(list == null || list.size() == 0) return new int[]{};
        int[] arr = new int[2];
        int x = -1;
        int y = -1;
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i) > list.get(i+1)){
                y = list.get(i+1);
                if(x == -1) {
                    x = list.get(i);
                }
            }
        }

        return new int[]{x,y};
    }

}
