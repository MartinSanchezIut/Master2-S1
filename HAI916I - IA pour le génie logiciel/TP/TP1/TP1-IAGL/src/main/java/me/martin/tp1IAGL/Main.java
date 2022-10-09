package me.martin.tp1IAGL;

import org.apache.commons.cli.ParseException;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in)  ;

        do {
            System.out.println("\n\n\n");
            printOptions();
            int choise = sc.nextInt();
            int taille = 4;
            String file = "";
            switch (choise) {
                case (1):
                    System.out.println("Taille du sudoku ?");
                    taille = sc.nextInt();
                    System.out.println("Backtrack pour taille "+ taille +" : ");
                    solveWithBT(taille);
                    break;
                case (2):
                    System.out.println("Taille du sudoku ?");
                    taille = sc.nextInt();
                    System.out.println("PPC pour taille " + taille +" : ");
                    solveWithPPC(4, false);
                    break;
                case (3):
                    System.out.println("Taille du sudoku ?");
                    taille = sc.nextInt();
                    System.out.println("Backtrack pour taille "+ taille +" : ");
                    solveAllWithBT(taille);
                    break;
                case (4):
                    System.out.println("Taille du sudoku ?");
                    taille = sc.nextInt();
                    System.out.println("PPC pour taille " + taille +" : ");
                    solveAllWithPPC(4, false);
                    break;
                case (5):
                    System.out.println("Taille du sudoku ?");
                    taille = sc.nextInt();
                    System.out.println("Fichier ?");
                    file = sc.nextLine();
                    if (file.equalsIgnoreCase( "")) { taille = 16;  file = "src\\main\\resources\\figure3.csv"; }

                    System.out.println("Resoudre depuis le fichier : " + file );
                    solveWithPPCfromCSV(file, taille, false);
                    break;
                case (6):
                    System.out.println("Taille du sudoku ?");
                    taille = sc.nextInt();
                    System.out.println("Fichier ?");
                    file = sc.nextLine();
                    if (file.equalsIgnoreCase( "")) { taille = 9;  file = "src\\main\\resources\\figure4.csv"; }

                    System.out.println("Greater than sudoku pour le fichier " + file );
                    solveGreaterThanSudoku(file, taille, false);
                    break;
                default:
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
            }

        }while (true) ;
    }


    public static void printOptions() {
        System.out.println("0 : Exit");
        System.out.println("1 : Solve BT");
        System.out.println("2 : Solve PPC");
        System.out.println("3 : SolveAll BT");
        System.out.println("4 : SolveAll PPC");
        System.out.println("5 : Solve PPC from file");
        System.out.println("6 : Solve Greater Than Sudoku");
    }


    public static void solveGreaterThanSudoku (String path, int size, boolean showStats) throws ParseException {
        SudokuPPC ppc = SudokuPPC.getPPC(size, null) ;
        ppc.createGTSudokuConstraint(path);
        ppc.solve(showStats);
    }


    public static void solveWithPPCfromCSV (String path, int size, boolean showStats) throws ParseException {
        SudokuPPC ppc = SudokuPPC.getPPC(size, null) ;
        ppc.addConstraintFromFile(path);
        ppc.solve(showStats);
    }


    public static void solveWithPPC (int size, boolean showStats) throws ParseException {
        SudokuPPC.solvePPC(size, showStats, null);
    }
    public static void solveAllWithPPC (int size, boolean showStats) throws ParseException {
        SudokuPPC.solveAllPPC(size, showStats, null);
    }

    public static void solveWithBT (int size){
        SudokuBT test = new SudokuBT(size);
        test.findSolution(0, 0);
    }
    public static void solveAllWithBT (int size){
        SudokuBT test = new SudokuBT(size);
        test.findSolutionAll(0, 0);
    }
}
