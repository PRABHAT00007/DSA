class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] children = new ArrayList[n];
        List<Integer>[] newChildren = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
            newChildren[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] prev = new int[n];
        int[] newParent = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(0);

        while (!st.isEmpty()) {
            int val = st.pop();
            int node = val / 2;
            int c = s.charAt(node) - 'a';

            if (val % 2 == 0) {
                prev[node] = last[c];

                newParent[node] = (prev[node] != -1)
                        ? prev[node] : parent[node];

                last[c] = node;

                st.push(node * 2 + 1);

                for (int child : children[node]) {
                    st.push(child * 2);
                }

            } else {
                last[c] = prev[node];
            }
        }

        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        int[] order = new int[n];
        int idx = 0;

        st.push(0);

        while (!st.isEmpty()) {
            int node = st.pop();
            order[idx++] = node;

            for (int child : newChildren[node]) {
                st.push(child);
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
