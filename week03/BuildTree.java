import java.util.*;

/**
 * @ClassName:  BuildTree
 * @Description: 105. 从前序与中序遍历序列构造二叉树
 * @link: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author: liuezhong
 * @date:   2021/8/21 上午11:26    
*/ 

public class BuildTree {

    /*
    * 方法1：递归
    * 时间复杂度：O(n)，空间复杂度：O(n)，n为节点个数
    * */

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuileTree(indexMap, preorder, inorder, 0, preorder.length - 1, 0 , inorder.length - 1);
    }

    private TreeNode myBuileTree(Map<Integer, Integer> indexMap, int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = indexMap.get(preorder[preLeft]);
        int leftSize = rootIndex - inLeft;
        root.left = myBuileTree(indexMap, preorder, inorder, preLeft + 1, preLeft + leftSize,  inLeft, rootIndex - 1);
        root.right = myBuileTree(indexMap, preorder, inorder, preLeft + leftSize + 1, preRight, rootIndex + 1, inRight);
        return root;
    }

    /*
    * 方法2：迭代法
    * 时间复杂度：O(n)，空间复杂度：O(n)
    * 当preorder[i]与inorder[j]不相等时，preorder[i + 1]即为preorder[i]的左节点，并入栈preorder[i],i++
    *                        相等时，对栈进行出栈，出栈的顺序即为中序遍历的顺序，直到栈顶元素与inorder[i]不相等为止
    *                        preorder[i + 1]即为最后一个与inorder[i]相等的栈元素的右节点，
    * */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length || preorder.length < 1) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        int inIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inIndex]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]){
                    node = stack.pop();
                    inIndex++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BuildTree b = new BuildTree();
        b.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{20, 9, 15, 3, 7});
    }
}
