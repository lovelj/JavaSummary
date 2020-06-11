package org.lj.leetcodedemo.arraydemo;

public class TreeNode {

    public  int val;
    public  TreeNode left;
    public  TreeNode right;
    public TreeNode(int v){
        val = v;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
    public  TreeNode(){}

}
