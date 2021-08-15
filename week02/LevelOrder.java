import java.util.*;

/**
 * @ClassName:  LevelOrder
 * @Description: 429. N 叉树的层序遍历
 * @link: https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @author: liuezhong
*/ 

public class LevelOrder {

    /*
    * 方法1：递归
    * */

    public List<List<Integer>> levelOrder1(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        order(root, 0, map);
        return new ArrayList<>(map.values());
    }

    public void order(Node root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(level, new ArrayList<>());
        list.add(root.val);
        map.put(level, list);
        for (Node node : root.children) {
            order(node, level + 1, map);
        }
    }

    /*
    * 方法2：迭代,辅助队列
    * */

    public List<List<Integer>> levelOrder2(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                root = queue.remove();
                level.add(root.val);
                queue.addAll(root.children);
            }
            result.add(level);
        }
        return result;
    }

    /*
    * 方法3：迭代，辅助列表
    * */

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Node> previousLayer = Arrays.asList(root);
        while (!previousLayer.isEmpty()) {
            List<Integer> previousVals = new ArrayList<>();
            List<Node> currentLayer = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }
        return result;
    }
}
