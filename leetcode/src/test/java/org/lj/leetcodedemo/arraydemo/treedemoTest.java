package org.lj.leetcodedemo.arraydemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class treedemoTest {

    @Test
    public void inorderTraversal() {

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        root.left.left = new TreeNode(4);

        treedemo demo =new treedemo();


        demo.inorderTraversal(root);
    }
}