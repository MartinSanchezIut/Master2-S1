package me.martin.tp1IAGL;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SudokuBT {

    int n;
    int s;
    int[][] grid;

    public int foundSolutions ;

    public SudokuBT(int n) {
        this.n = n;
        this.s = (int) Math.sqrt(n);
        this.grid = new int[n][n];
        foundSolutions = 0;
    }

    private boolean solutionChecker() {
        boolean[] tabValeur = new boolean[n + 1];

        for (int k = 1; k < n + 1; k++) {
            tabValeur[k] = false;
        }

        int valueH;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                valueH = this.grid[i][j];
                if (tabValeur[valueH]) {
                    return false;
                } else {
                    tabValeur[valueH] = true;
                }
            }
            for (int k = 1; k < n + 1; k++) {
                tabValeur[k] = false;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                valueH = this.grid[i][j];
                if (tabValeur[valueH]) {
                    return false;
                } else {
                    tabValeur[valueH] = true;
                }

            }
            for (int k = 1; k < n + 1; k++) {
                tabValeur[k] = false;
            }
        }

        for (int i = 0; i < n; i += s) {
            for (int j = 0; j < n; j += s) {

                for (int k = i; k < i + s; k++) {
                    for (int l = j; l < j + s; l++) {
                        valueH = this.grid[k][l];
                        if (tabValeur[valueH]) {
                            return false;
                        } else {
                            tabValeur[valueH] = true;
                        }
                    }
                }

                for (int k = 1; k < n + 1; k++) {
                    tabValeur[k] = false;
                }
            }
        }
        return true;
    }

    private void generateSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.grid[i][j] = (int) (Math.random() * n + 1);
            }
        }
    }

    private int[] nextIJ(int i, int j) {
        if (i == n - 1 && j == n - 1) {
            return new int[]{-1, -1};
        }
        if (j == n - 1) {
            return new int[]{i + 1, 0};
        }
        return new int[]{i, j + 1};
    }

    public boolean findSolution(int i, int j) {
        int[] update;

        if (i == -1 && j == -1) {
            if (solutionChecker()) {
                System.out.println(this);
                return true;
            } else {
                return false;
            }
        }
        for (int k = 1; k < n + 1; k++) {
            this.grid[i][j] = k;
            update = nextIJ(i, j);
            if (findSolution(update[0], update[1])) {
                return true;
            }
        }
        this.grid[i][j] = 0;
        return false;
    }

    public boolean findSolutionAll(int i, int j) {
        int[] update;

        if (i == -1 && j == -1) {
            if (solutionChecker()) {
                System.out.println(this);
                foundSolutions++;
                return false;
            } else {
                return false;
            }
        }
        for (int k = 1; k < n + 1; k++) {
            this.grid[i][j] = k;
            update = nextIJ(i, j);
            if (findSolutionAll(update[0], update[1])) {
                return true;
            }
        }

        this.grid[i][j] = 0;
        return false;
        }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "\n" + Arrays.toString(this.grid[i]);
        }
        return str + "\n";
    }

    public static void main (String args[]){
        SudokuBT test = new SudokuBT(4);
        test.findSolution(0, 0);
    }
    }
