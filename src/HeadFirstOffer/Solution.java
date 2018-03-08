package HeadFirstOffer;



public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int rootValue = pre[0];
        TreeNode root = new TreeNode(rootValue);
        return new TreeNode(1);
    }

    public TreeNode constructCore(int startPre, int endPre, int startIn, int endIn){

        return new TreeNode(0);
    }


    //Definition for binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}