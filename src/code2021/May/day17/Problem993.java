/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.May.day17;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * @author chenhang
 * @created 2021/5/17
 */
public class Problem993 {

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

class Solution {
    /**
     * 只需要判断x与y的深度是否相等、是否为非兄弟节点即可 不需要建树
     * @param root 根节点
     * @param x x节点
     * @param y y节点
     * @return 深度是否相同
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        return calcDepth(root, x, 0) == calcDepth(root, y, 0) && !checkBrother(root, x, y);
    }

    public int calcDepth(TreeNode root, int x, int depth) {
        if (root.val == x) {
            return depth;
        } else if (root.left == null && root.right == null) {
            return -Integer.MAX_VALUE;
        } else if (root.left == null) {
            return calcDepth(root.right, x, depth + 1);
        } else if (root.right == null) {
            return calcDepth(root.left, x, depth + 1);
        } else {
            return Math.max(calcDepth(root.left, x, depth + 1), calcDepth(root.right, x, depth + 1));
        }
    }

    public boolean checkBrother(TreeNode root, int x, int y) {
        if (root.left != null && root.right != null) {
            if ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)) {
                return true;
            } else {
                return checkBrother(root.left, x, y) || checkBrother(root.right, x, y);
            }
        } else if (root.left != null) {
            return checkBrother(root.left, x, y);
        } else if (root.right != null){
            return checkBrother(root.right, x, y);
        }
        return false;
    }
}