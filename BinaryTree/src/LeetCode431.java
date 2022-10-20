import java.util.ArrayList;
import java.util.List;

class BinaryNode{
    int val;
    BinaryNode right,left;

    BinaryNode(int val){
        this.val=val;
        right=left=null;
    }
}
class NAryNode{
    int data;
    List<NAryNode> children;

    NAryNode(int data){
        this.data=data;
        children=new ArrayList<>();
    }
}
public class LeetCode431 {
    //431. Encode N-ary Tree to Binary Tree

    // Encodes an n-ary tree to a binary tree.
    static BinaryNode encode(NAryNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        TreeNode cur = newRoot;
        for (int i = 0; i < root.children.size(); i++) {
            if (i == 0) {
                newRoot.left = encode(root.children.get(i));
                cur = cur.left;
            } else {
                cur.right = encode(root.children.get(i));
                cur = cur.right;
            }
        }
        return newRoot;
    }

    // Decodes your binary tree to an n-ary tree.
    static Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node newRoot = new Node(root.val, new ArrayList<>());
        TreeNode temp = root.left;
        while (temp != null) {
            newRoot.children.add(decode(temp));
            temp = temp.right;
        }
        return newRoot;
    }
}
