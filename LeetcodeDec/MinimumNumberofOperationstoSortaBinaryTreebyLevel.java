class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int swaps = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeSet<Integer> s = new TreeSet<>();
            Map<Integer, Integer> m = new HashMap<>();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                s.add(node.val);
                l.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            int index = 0;
            for (int i : s) {
                m.put(i, index);
                index++;
            }
            int i = 0;
            while (i < l.size()) {
                int value = l.get(i);
                int idx = m.get(value);
                if(i != idx){
                    Collections.swap(l,idx,i);
                    swaps++;
                }else{
                    i++;
                }
            }
        }
        return swaps;
    }
}