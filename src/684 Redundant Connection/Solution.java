class Solution {
    int MAX_EDGE_VAL = 1001;

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }

    class DSU {
        int[] parent;
        int[] weight;

        public DSU(int size) {
            parent = new int[size];
            weight = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return false;
            }

            if (weight[rootx] < weight[rooty]) {
                parent[rootx] = rooty;
            } else if (weight[rootx] > weight[rooty]) {
                parent[rooty] = rootx;
            } else {
                parent[rootx] = rooty;
                weight[rooty]++;
            }
            return true;
        }
    }
}