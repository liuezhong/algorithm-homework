
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName:  InorderTraversal
 * @Description:  94. 二叉树的中序遍历
 * @link: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author: liuezhong
 * @date:   2021/8/14 下午5:52    
*/ 

public class InorderTraversal {

//    方法1：递归

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    /*
    * 方法2：迭代
    * 依次按左-根-右次序入栈
    * */

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        InorderTraversal i = new InorderTraversal();
        i.inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
    }
}
