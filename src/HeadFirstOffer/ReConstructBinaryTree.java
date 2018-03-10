package HeadFirstOffer;



public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0)
            return null;
        return constructCore(pre,0, pre.length-1, in,0, in.length-1);
    }

    public TreeNode constructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn){
            return null;
        }

        int rootValue = pre[startPre];
        TreeNode root = new TreeNode(rootValue);
        for (int i = startIn; i <= endIn; i ++){
            if (in[i] == pre[startPre]) {
                root.left = constructCore(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = constructCore(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " " );
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);

    }
    public void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public static void main(String[] args){
        int[] pre = {1, 2, 4, 3, 5, 6, 7};
        int[] in = {2, 4, 1, 6, 5, 7, 3};
        ReConstructBinaryTree s = new ReConstructBinaryTree();
        TreeNode root = s.reConstructBinaryTree(pre, in);
        s.preOrder(root);
        System.out.println();
        s.inOrder(root);
        System.out.println();
        s.postOrder(root);
    }

    //Definition for binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}