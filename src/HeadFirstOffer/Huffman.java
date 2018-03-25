package HeadFirstOffer;

import java.util.*;

public class Huffman {
    public TreeNode constructHuffman(char[] chars, int[] frequent){
        Queue<TreeNode> Q = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                if (o1.weight == o2.weight){
                    if (o1.original && o2.original) return 0;
                    if (o1.original && !o2.original) return 1;
                    else return -1;
                }
                return o1.weight - o2.weight;
            }
        });
        for (int i = 0; i < chars.length; i++){
            Q.offer(new TreeNode(null, null, chars[i] + "", frequent[i]));
        }
        while (Q.size() > 1){
            TreeNode n1 = Q.poll();
            TreeNode n2 = Q.poll();
            TreeNode n3 = new TreeNode(n1, n2, n1.weight + n2.weight + "", n1.weight + n2.weight);
            n3.original = false;
            Q.offer(n3);
        }
        List<Integer> list = new ArrayList();
        dfs(Q.peek(), list);
        return Q.poll();
    }
    public void dfs(TreeNode root, List<Integer> path){
        if (root == null) return;
//        System.out.println(root.val + " " + root.weight);
        if (root.lc == null && root.rc == null){
            System.out.println(root.val);
            System.out.println(path.toString());
            path.remove(path.size() - 1);
            return;
        }
        if (root.lc != null){
            path.add(0);
            dfs(root.lc, path);
        }
        if (root.rc != null){
            path.add(1);
            dfs(root.rc, path);
        }
        if (!path.isEmpty()){
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Huffman h = new Huffman();
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        int[] weights = new int[]{5, 4, 3, 2, 1};
        h.constructHuffman(chars, weights);
    }
}
class TreeNode{
    TreeNode lc, rc;
    boolean original; // false为新建节点 frue是原生节点
    String val;
    int weight;

    public TreeNode(TreeNode lc, TreeNode rc, String val, int weight) {
        this.lc = lc;
        this.rc = rc;
        this.val = val;
        this.weight = weight;
    }
    public TreeNode(TreeNode lc, TreeNode rc, int val) {
        this.lc = lc;
        this.rc = rc;
        this.val = val + "";
    }
}
