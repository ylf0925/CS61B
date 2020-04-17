
import java.util.LinkedList;
import java.util.List;

public class UnionFind {
    // TODO - Add instance variables?
    private int[] pmap;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        pmap = new int[n];
        for (int i = 0; i < n; i += 1) {
            pmap[i] = -1;
        }
    }


    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex > pmap.length - 1 || vertex < 0) {
            throw new IllegalArgumentException();
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        validate(v1);
        return -parent(find(v1));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        validate(v1);
        return pmap[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        // TODO
        int root1 = find(v1);
        int root2 = find(v2);

        int size1 = -parent(root1);
        int size2 = -parent(root2);

        if (size1 >= size2) {
            pmap[root2] = root1;
            pmap[root1] = -(size1+size2);
        } else {
            pmap[root1] = root2;
            pmap[root2] = -(size1+size2);
        }

    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        validate(vertex);
        int curr = vertex;
        int hangSize = 0;
        List<Integer> stack = new LinkedList<Integer>();
        while (pmap[curr] >= 0) {
            stack.add(curr);
            curr = pmap[curr];
            hangSize++;
        }
        while (!stack.isEmpty()) {
            int hanger = stack.remove(stack.size() - 1);
            pmap[hanger] = curr;
        }
        return curr;
    }
}

