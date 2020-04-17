
import org.junit.Test;

import static org.junit.Assert.*;


public class TestUnionFind {
    @Test
    public void testUnionCreation() {
        UnionFind unionSet = new UnionFind(10);
        unionSet.find(4);
        assertEquals(4, unionSet.find(4));
        unionSet.union(0, 1);
        unionSet.connected(0, 1);
        unionSet.union(2, 3);
        unionSet.union(4, 5);
        unionSet.union(6, 7);
        unionSet.union(8, 9);
        assertTrue(unionSet.connected(4, 5));
        assertFalse(unionSet.connected(4, 0));
        unionSet.union(1, 3);
        unionSet.union(3, 9);
        assertTrue(unionSet.connected(1, 9));
        unionSet.union(5, 7);
        assertTrue(unionSet.connected(5, 7));
    }
}
