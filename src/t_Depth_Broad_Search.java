import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Search {

    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(TreeNode left, TreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    // 广度优先遍历
    public void BroardFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(nodeHead);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data + " ");

            if (null != node.left) {
                queue.add(node.left);
            }

            if (null != node.right) {
                queue.add(node.right);
            }
        }
    }

    // 深度优先遍历
    public void DepthFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(nodeHead);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.data + "");

            if (node.right != null){
                stack.push(node.right);
            }

            if (node.left != null){
                stack.push(node.left);
            }
        }

    }
}

class Depth_Broad_Search {
    public static void main(String[] args) {
        Search.TreeNode head = new Search.TreeNode(1);
        Search.TreeNode second = new Search.TreeNode(2);
        Search.TreeNode three = new Search.TreeNode(3);
        Search.TreeNode four = new Search.TreeNode(4);
        Search.TreeNode five = new Search.TreeNode(5);
        Search.TreeNode six = new Search.TreeNode(6);
        Search.TreeNode seven = new Search.TreeNode(7);
        head.setRight(three);
        head.setLeft(second);
        second.setRight(five);
        second.setLeft(four);
        three.setRight(seven);
        three.setLeft(six);

        System.out.println("广度优先遍历结果：");
        new Search().BroardFirstSearch(head);

        System.out.println("深度优先遍历结果：");
        new Search().DepthFirstSearch(head);
    }
}
