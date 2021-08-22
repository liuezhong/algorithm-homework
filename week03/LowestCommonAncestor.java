import java.util.*;

/**
 * @ClassName:  LowestCommonAncestor
 * @Description: 236. 二叉树的最近公共祖先
 * @link: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author: liuezhong
 * @date:   2021/8/21 上午10:53
*/

public class LowestCommonAncestor {

    /*
    * 方法1：递归
    * 时间复杂度：O(n)，空间复杂度：O(n)，n为节点个数。
    */

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /*
    * 方法2：存储父节点
    * 时间复杂度：O(n)，空间复杂度：O(n)，n为节点个数。
    * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        getParent(root, parentMap);
        while (p != null) {
            visited.add(p);
            p = parentMap.get(p);
        }

        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public void getParent(TreeNode root, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, node);
            }
        }
    }

}
