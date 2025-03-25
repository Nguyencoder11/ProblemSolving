package com.tutorial.solving.String.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null)
            return;

        path += node.val;

        // check if it's a leaf node
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            path += "->";
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }

    private TreeNode stringToTreeNode(String data) {
        if (data == null || data.length() <= 2)
            return null;

        data = data.substring(1, data.length() - 1);
        if (data.isEmpty())
            return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (!nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreePaths solution = new BinaryTreePaths();

        String[] rootTC = {
                "[1,2,3,null,5]",
                "[1]"
        };

        for (int i = 0; i < rootTC.length; i++) {
            TreeNode root = solution.stringToTreeNode(rootTC[i]);
            List<String> result = solution.binaryTreePaths(root);

            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: root = " + rootTC[i]);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
