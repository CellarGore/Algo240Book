package com.salar.algo240book.chapter1;

public class UnionFind {
    private int[] id;   // access to component id (site-indexed)
    private int[] sz;   // size of component for roots (site-indexed)
    private int count;  // number of components

    /* Methods */

    // Constructor
    public UnionFind(int N) {
        this.count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return quickFind(p) == quickFind(q);
    }

    // TODO make separate implementations private and build an abstraction so only one (hidden)
    // implementation is being used, I can switch all this in code

    /* Algorithm One: Quick-find
        Maintain the invariant that the connected components all have the same id[i] value
     */
    private int quickFind(int p) { return 0; }

    // Dynamic connectivity with a quickFind can be a quadratic-time process
    void quickFindUnion(int p, int q) {
        int pID = id[p];
        int qID = id[q];

        // Nothing to do if p and q are in the same component already
        if (pID == qID) return;

        // Rename p's component to q's name
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }

    /* Algorithm Two: Quick-union
        Each id[i] element is a link to another site
        A site with a link to itself is the root.

        Technically in this case our id array is a parent-link representation of a forest of trees
     */
    private int quickUnionFind(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    void quickUnionWeighted(int p, int q) {
        // give p and q the same root
        int pRoot = quickUnionFind(p);
        int qRoot = quickUnionFind(q);
        if (pRoot == qRoot) return;

        // So when someone now comes to pRoot they will see that pRoot is no longer a root
        // and that it redirects to qRoot (which would be a root) This is akin to extending the
        // link chain that reached pRoot by one (to reach qRoot at the end)

        // So this is actually just tree structure lol
        // id[pRoot] = qRoot;
        // Obsoleted by the weighted union approach

        // Make smaller root point to larger one

        if (sz[pRoot] < sz[qRoot]) { id[pRoot] = qRoot; sz[qRoot] += sz[pRoot]; }
        else                       { id[qRoot] = pRoot; sz[pRoot] += sz[qRoot]; }

        count--;
    }

}
