package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    // instance variables
    private WeightedQuickUnionUF unionSet;
    private int setDimension;
    private int numOfOpen;
    private int openStatusPos;
    private int topPos;
    private int bottomPos;

    // constructor
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        // three extra slot store three status.
        // 1.open
        // 2.connected to top
        // 3.connected to bottom

        if (N < 0) {
            throw new IllegalArgumentException();
        }

        setDimension = N;
        openStatusPos = setDimension * setDimension;
        topPos = openStatusPos + 1;
        bottomPos = openStatusPos + 2;
        unionSet = new WeightedQuickUnionUF(openStatusPos + 3);
        numOfOpen = 0;
        for (int i = 0; i < setDimension; i++) {
            unionSet.union(i, topPos);
            unionSet.union(i + setDimension * (setDimension - 1), bottomPos);
        }
    }

    // validate input
    private void isLegalInput(int x, int y) {
        if (y < 0 || y > setDimension - 1 || x < 0 || x > setDimension - 1) {
            throw new IndexOutOfBoundsException ();
        }
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        isLegalInput(row, col);
        int pos1D = xyTo1D(row, col);
        unionSet.union(pos1D, openStatusPos);
        numOfOpen++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isLegalInput(row, col);
        int pos1D = xyTo1D(row, col);
        return unionSet.connected(pos1D, openStatusPos);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOfOpen;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        isLegalInput(row, col);
        int pos1D = xyTo1D(row, col);
        return unionSet.connected(pos1D, topPos);
    }


    // does the system percolate?
    public boolean percolates() {
        return unionSet.connected(topPos,bottomPos);
    }



    // convert 2D to 1D
    public int xyTo1D(int row, int col) {
        isLegalInput(row, col);
        return setDimension * row + col;
    }


    // use for unit testing (not required, but keep
    // this here for the autograder)
    public static void main(String[] args) {


    }
}

