package hw2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPercolation {

    @Test
    public void testGerneation() {
        Percolation p = new Percolation(5);
        assertEquals(p.xyTo1D(2, 2), 12);
        assertEquals(p.xyTo1D(4, 4), 24);
        p.open(2,2);
        p.open(1,2);
        assertTrue(p.isOpen(1,2));
    }
}
