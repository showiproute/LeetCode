public class tree654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length ==0) return null;

        return build(nums,0,nums.length-1);
    }

    public TreeNode build(int[] nums,int left,int right) {
        if(left > right) return null;

        int index = left;
        int maxValue = Integer.MIN_VALUE;
        for(int i = left;i<=right;i++) {
            if(nums[i] >maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums,left,index-1);
        root.right = build(nums,index+1,right);

        return root;
    }

    public static void main(String[] args) {


    }
}
