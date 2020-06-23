    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */
    class Solution {
        TreeNode pre;
        public TreeNode convertBiNode(TreeNode root) {

            pre = new TreeNode(0);
            TreeNode header = pre;
            travel(root);
            return header.right;
        }

        public void travel(TreeNode root) {
            if (root == null) return;
            
            travel(root.left);
            pre.right = root;
            root.left = null;
            pre = pre.right;
            travel(root.right);
        }
    }
    /**
        /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */
    class Solution {
        TreeNode pre;
        public TreeNode convertBiNode(TreeNode root) {

            pre = new TreeNode(0);
            TreeNode header = pre;
            travel(root);
            return header.right;
        }

        public void travel(TreeNode root) {
            if (root == null) return;
            
            travel(root.left);
            pre.right = root;
            root.left = null;
            pre = pre.right;
            travel(root.right);
        }
    }
    /**