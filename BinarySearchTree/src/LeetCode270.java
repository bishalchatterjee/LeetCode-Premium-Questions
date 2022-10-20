class TreeNode{
    int val;
    TreeNode right,left;

    TreeNode(int val){
        this.val=val;
        right=left=null;
    }
}
public class LeetCode270 {
    //270. Closest Binary Search Tree Value

    static int closestValue(TreeNode root, double target) {
        // write your code here
        /*
        non-recursion method. find the upper and lower just by moving step by step. O(h) time and O(1) space
        recursion method: find upper and find lower two methods.
        */

        if (root == null){
            return 0;
        }

        TreeNode upper = root;
        TreeNode lower = root;

        while (root != null){
            if (root.val > target){
                upper = root;
                root = root.left;
            }else if (root.val < target){
                lower = root;
                root = root.right;
            }else {
                return root.val;
            }
        }

        if (Math.abs(upper.val - target) > Math.abs(target - lower.val)){
            return lower.val;
        }
        return upper.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.right=new TreeNode(2);
        root.right=new TreeNode(9);
        root.right.left=new TreeNode(8);
        root.right.right=new TreeNode(10);

        double target = 6.124780;

        System.out.println(closestValue(root,target));
    }
}


//T.C - O(h) //h-->height of the binary tree
//S.C - O(1)