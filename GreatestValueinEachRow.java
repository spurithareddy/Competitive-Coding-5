// Time Complexity : O(n)
// Space Complexity : O(n) - For Queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//level order travversal and finding the max at every single level and storing in queue

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>();
        // root is null then return empty arraylist
        if (root == null)
            return res;
        q.add(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            max = Integer.MIN_VALUE;
            int size = q.size();
            //adding the children of each node in this level
            for (int i = 0; i < size; i++) {
                root = q.poll();
                max = Math.max(max, root.val);
                if (root.left != null)
                    q.add(root.left);
                if (root.right != null)
                    q.add(root.right);
            }
            res.add(max);
        }
        return res;

    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) - For Stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//dfs using pre order traversal and rewriting max values each time


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode root, int level, List<Integer> res) {

        if (root == null) {
            return;
        }
        //no max at that level
        if (res.size() == level) {
            res.add(level, root.val);
        } 
        // overwrite max
        else {
            if (res.get(level) < root.val) {
                res.set(level, root.val);
            }
        }
        // left child
        dfs(root.left, level + 1, res);
        //right child
        dfs(root.right, level + 1, res);
    }
}