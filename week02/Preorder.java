import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName:  Preorder
 * @Description: 589. N 叉树的前序遍历
 * @link: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @author: liuezhong
*/

public class Preorder {

//    方法1：递归

    public List<Integer> preorder1(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        order(root, result);
        return result;
    }

    public void order(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node node : root.children) {
            order(node, result);
        }
    }

//    方法2：迭代

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            Collections.reverse(root.children);
            for(Node node : root.children) {
                stack.push(node);
            }
        }
        return result;
    }
}
