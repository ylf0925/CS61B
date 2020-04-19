package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdStats;


public class PercolationStats {

    private int numOfExp;
    private double[] inducedfillRatio;

    // perform T independent
    // experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        numOfExp = T;
        inducedfillRatio = new double[T];
        for (int j = 0; j < numOfExp; j++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int randomOpenX = StdRandom.uniform(0, N);
                int randomOpenY = StdRandom.uniform(0, N);
                if (!p.isOpen(randomOpenX, randomOpenY)) {
                    p.open(randomOpenX, randomOpenY);
                }
            }
            double fillRatio = (double) p.numberOfOpenSites() / (N * N);
            inducedfillRatio[j] = fillRatio;
        }
    }


    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(inducedfillRatio);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(inducedfillRatio);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        double mu = mean();
        double sigma = stddev();
        return mu - 1.96 * sigma / Math.sqrt(numOfExp);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        double mu = mean();
        double sigma = stddev();
        return mu + 1.96 * sigma / Math.sqrt(numOfExp);
    }

}

