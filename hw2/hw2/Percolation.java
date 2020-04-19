package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufTopOnly;
    private int dimension;
    private boolean[][] grid;
    private int topPos;
    private int bottomPos;
    private int numOfOpen;

    // constructor
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        dimension = N;
        uf = new WeightedQuickUnionUF(N * N + 2);
        ufTopOnly = new WeightedQuickUnionUF(N * N + 1);
        grid = new boolean[N][N];
        topPos = 0;
        bottomPos = N * N + 1;
    }

    // convert 2D to 1D
    private int xyTo1D(int row, int col) {
        return dimension * row + col + 1;
    }

    // validate input
    private void isLegalInput(int x, int y) {
        if (y < 0 || y > dimension - 1 || x < 0 || x > dimension - 1) {
            throw new IndexOutOfBoundsException();
        }
    }


    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        isLegalInput(row, col);
        // index inbound
        int center = xyTo1D(row, col);
        if (!isOpen(row, col)) {
            grid[row][col] = true;
            numOfOpen++;
        }
        if (row == 0) {
            uf.union(center, topPos);
            ufTopOnly.union(center, topPos);
        }
        if (row == dimension - 1) {
            uf.union(center, bottomPos);
        }
        if (row > 0 && isOpen(row - 1, col)) {
            int up = xyTo1D(row - 1, col);
            uf.union(center, up);
            ufTopOnly.union(center, up);
        }
        if (row < dimension - 1 && isOpen(row + 1, col)) {
            int down = xyTo1D(row + 1, col);
            uf.union(center, down);
            ufTopOnly.union(center, down);
        }
        if (col > 0 && isOpen(row, col - 1)) {
            int left = xyTo1D(row, col - 1);
            uf.union(center, left);
            ufTopOnly.union(center, left);
        }
        if (col < dimension - 1 && isOpen(row, col + 1)) {
            int right = xyTo1D(row, col + 1);
            uf.union(center, right);
            ufTopOnly.union(center, right);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isLegalInput(row, col);
        return grid[row][col];
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOfOpen;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        isLegalInput(row, col);
        int pos1D = xyTo1D(row, col);
        return ufTopOnly.connected(topPos, pos1D);
    }


    // does the system percolate?
    public boolean percolates() {
        return uf.connected(topPos, bottomPos);
    }


    // use for unit testing (not required, but keep
    // this here for the autograder)
    public static void main(String[] args) {


    }
}

