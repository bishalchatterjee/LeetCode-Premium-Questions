import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left,right;

    TreeNode(int val){
        this.val=val;
        left=right=null;
    }
}
public class LeetCode1469 {
    //1469. Find All The Lonely Nodes

    static List<Integer> lonelyNodes(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        helperBFS(root,res);
        return res;
    }
    static void helperBFS(TreeNode root, List<Integer> res){
        Queue<TreeNode> qu=new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            TreeNode node=qu.poll();
            if(node.left!=null && node.right!=null){
                qu.offer(node.left);
                qu.offer(node.right);
            }else if(node.left==null && node.right!=null){
                res.add(node.right.val);
                qu.offer(node.right);
            }else if(node.right==null && node.left!=null){
                res.add(node.left.val);
                qu.offer(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right = new TreeNode(3);


        System.out.println(lonelyNodes(root));
    }
}


//T.C - O(N) //N--> Number of nodes
//S.C - O(M) //M--> max size of the bfs queue