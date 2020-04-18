package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {


    // instance variables
    private WeightedQuickUnionUF unionSet;
    private int setDimension;
    private int numOfOpen;

    // constructor
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        setDimension = N;
        unionSet = new WeightedQuickUnionUF(setDimension * setDimension + 1);
        numOfOpen = 0;
    }

    // validate input
    private void isLegalInput(int x, int y) {
        if (y < 0 || y > setDimension - 1 || x < 0 || x > setDimension - 1) {
            throw new IllegalArgumentException();
        }
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        isLegalInput(row, col);
        int pos1D = xyTo1D(row, col);
        unionSet.union(pos1D, setDimension * setDimension);
        numOfOpen++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isLegalInput(row, col);
        int pos1D = xyTo1D(row, col);
        return unionSet.connected(pos1D, setDimension * setDimension);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOfOpen;
    }

   /* // is the site (row, col) full?
    public boolean isFull(int row, int col) {

    }


    // does the system percolate?
    public boolean percolates() {

    }


    // use for unit testing (not required, but keep
    // this here for the autograder)
    public static void main(String[] args) {


    }*/

    // convert 2D to 1D
    public int xyTo1D(int row, int col) {
        isLegalInput(row, col);
        return setDimension * row + col;
    }


}

