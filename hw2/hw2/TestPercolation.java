package hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPercolation {

    @Test
    public void testGerneation() {
        Percolation p = new Percolation(5);
        assertEquals(p.xyTo1D(2, 2), 12);
        assertEquals(p.xyTo1D(4, 4), 24);
        p.open(2, 2);
        p.open(1, 2);
        assertTrue(p.isOpen(1, 2));
        assertEquals(p.numberOfOpenSites(), 2);
        p.open(0, 2);
        p.open(3, 2);
        assertTrue(p.isOpen(3, 2));
        assertFalse(p.percolates());
        p.open(4,2);
        assertTrue(p.percolates());
        p.open(2,4);
        assertFalse(p.isFull(2,4));

    }
}
