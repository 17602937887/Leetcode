package Feb22th;

public class isUnivalTree965 {
    // 直接判断 所有的子节点是否和父节点的值一样 如果不一样 直接返回false, 否则继续递归;
    public static boolean check(TreeNode root, int val){
        if(root == null)
            return true;
        if(root.val == val){
            return check(root.left, val) && check(root.right, val);
        } else {
            return false;
        }
    }
    public boolean isUnivalTree(TreeNode root) {
        return check(root, root.val);
    }
}
