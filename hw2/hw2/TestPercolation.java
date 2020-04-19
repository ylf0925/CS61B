package hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPercolation {

    @Test
    public void testGerneation() {
        Percolation p = new Percolation(5);
        assertEquals(13,p.xyTo1D(2,2));
        p.open(2, 2);
        p.open(1, 2);
        assertTrue(p.isOpen(2,2));
        p.open(0, 2);
        p.open(3, 2);
        assertTrue(p.isFull(3,2));
        p.open(4, 2);
        assertTrue(p.percolates());
        p.open(4, 0);
        p.open(3, 0);
        p.open(2, 0);
        assertFalse(p.isFull(2,0));
    }
}
