package Binary_trees;

class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    ArrayList<Integer> boundaryTraversal(Node root) {
        if (root == null) return ans;
        if (!leaf(root))
            ans.add(root.data);
        leftTraversal(root.left);
        addLeaves(root);
        rightTraversal(root.right);

        return ans;
    }

    boolean leaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    void leftTraversal(Node root) {
        while (root != null) {
            if (!leaf(root))
                ans.add(root.data);

            if (root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    void addLeaves(Node node) {
        if (node == null) return;

        if (leaf(node)) {
            ans.add(node.data);
            return;
        }

        addLeaves(node.left);
        addLeaves(node.right);
    }

    void rightTraversal(Node root) {
        Stack<Integer> st = new Stack<>();

        while (root != null) {
            if (!leaf(root))
                st.push(root.data);

            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }

        while (!st.isEmpty())
            ans.add(st.pop());
    }
}

