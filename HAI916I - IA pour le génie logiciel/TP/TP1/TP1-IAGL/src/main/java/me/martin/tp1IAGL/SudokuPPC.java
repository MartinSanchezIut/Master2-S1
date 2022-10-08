package me.martin.tp1IAGL;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.chocosolver.solver.search.strategy.Search.minDomLBSearch;
import static org.chocosolver.util.tools.ArrayUtils.append;

public class SudokuPPC {

    static String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    static int n;
    static int s;
    private static int instance;
    private static long timeout = 3600000; // one hour

    IntVar[][] rows, cols, shapes;

    Model model;

    public static void main(String[] args) throws ParseException, IOException {
        final Options options = configParameters();
        final CommandLineParser parser = new DefaultParser();
        final CommandLine line = parser.parse(options, args);

        boolean helpMode = line.hasOption("help"); // args.length == 0
        if (helpMode) {
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("sudoku", options, true);
            System.exit(0);
        }
        instance = 16;
        // Check arguments and options
        for (Option opt : line.getOptions()) {
            checkOption(line, opt.getLongOpt());
        }

        n = instance;
        s = (int) Math.sqrt(n);

        SudokuPPC ppc = new SudokuPPC() ;
        ppc.buildModel();
        ppc.addConstraintFromFile("src\\main\\resources\\figure3.csv");

        ppc.model.getSolver().solve();

        ppc.printGrid();

        ppc.model.getSolver().printStatistics();

    }

    public static void solvePPC(int size, boolean showStats, String[] args) throws ParseException {
        final Options options = configParameters();
        final CommandLineParser parser = new DefaultParser();
        final CommandLine line = parser.parse(options, args);

        boolean helpMode = line.hasOption("help"); // args.length == 0
        if (helpMode) {
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("sudoku", options, true);
            System.exit(0);
        }
        instance = size;
        // Check arguments and options
        for (Option opt : line.getOptions()) {
            checkOption(line, opt.getLongOpt());
        }

        n = instance;
        s = (int) Math.sqrt(n);

        new SudokuPPC().solve(showStats);   // Potentielle erreur
    }
    public static void solveAllPPC(int size, boolean showStats, String[] args) throws ParseException {
        final Options options = configParameters();
        final CommandLineParser parser = new DefaultParser();
        final CommandLine line = parser.parse(options, args);

        boolean helpMode = line.hasOption("help"); // args.length == 0
        if (helpMode) {
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("sudoku", options, true);
            System.exit(0);
        }
        instance = size;
        // Check arguments and options
        for (Option opt : line.getOptions()) {
            checkOption(line, opt.getLongOpt());
        }

        n = instance;
        s = (int) Math.sqrt(n);

        new SudokuPPC().getxSolutions(showStats, -1);   // Potentielle erreur
    }

    public void addConstraintFromFile(String filepath) {
        try{
            FileInputStream fileInput = new FileInputStream(filepath);
            Scanner sc = new Scanner(fileInput);

            int line = 0 ;
            while(sc.hasNextLine()) {
                String[] row = sc.nextLine().replace(" ", "").split(",") ;

                for (int i = 0; i < row.length; i++) {
                   /* if (Integer.parseInt(row[i], row.length) != 0) {
                        model.arithm(rows[line][i], "=" , Integer.parseInt(row[i], row.length)).post();
                    }*/

                    if (! row[i].equalsIgnoreCase("0")) {
                        model.arithm(rows[line][i], "=" , Integer.parseInt(row[i], 35)).post();
                    }

                }

                line++;
            }

            sc.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retourne un certain nombre de solutions
     * @param printStatistics
     * @param numberOfSolution Nombre de solutions (<0 = toutes les solutions)
     */
    public void getxSolutions(boolean printStatistics, int numberOfSolution) {
        buildModel();
        if (numberOfSolution <= 0) {
            while (model.getSolver().solve()){
                printGrid();
                if (printStatistics) {        model.getSolver().printStatistics(); }
            }
        }else {
            for (int i = 0; i  <  numberOfSolution; i++) {
                model.getSolver().solve();
                printGrid();
                if (printStatistics) {        model.getSolver().printStatistics(); }
            }
        }
    }
    public void solve(boolean printStatistics) {

        buildModel();

        //model.getSolver().
        model.getSolver().solve();

        printGrid();

        if (printStatistics) {        model.getSolver().printStatistics(); }

    }

    public void printGrid() {
        String a;
        a = "┌───";
        String b;
        b = "├───";
        String c;
        c = "─┬────┐";
        String d;
        d = "─┼────┤";
        String e;
        e = "─┬───";
        String f;
        f = "─┼───";
        String g;
        g = "└────┴─";
        String h;
        h = "───┘";
        String k;
        k = "───┴─";
        String esp = " ";

        for (int i = 0; i < n; i++) {

            for (int line = 0; line < n; line++) {
                if (line == 0) {
                    System.out.print(i == 0 ? a : b);
                } else if (line == n - 1) {
                    System.out.print(i == 0 ? c : d);
                } else {
                    System.out.print(i == 0 ? e : f);
                }
            }
            System.out.println("");
            System.out.print("│ ");
            for (int j = 0; j < n; j++) {
                int val = rows[i][j].getValue();
                if (val > 9)
                    System.out.print(esp + alphabet[val-9-1] + " │ ");
                else
                    System.out.print(esp + rows[i][j].getValue() + " │ ");

                /*
                if (rows[i][j].getValue() > 9)
                    System.out.print(rows[i][j].getValue() + " │ ");
                else
                    System.out.print(esp + rows[i][j].getValue() + " │ ");
                */
            }

            if (i == n - 1) {
                System.out.println("");
                for (int line = 0; line < n; line++) {
                    System.out.print(line == 0 ? g : (line == n - 1 ? h : k));
                }
            }
            System.out.println("");
        }
    }

    public void buildModel() {
        model = new Model();

        rows = new IntVar[n][n];
        cols = new IntVar[n][n];
        shapes = new IntVar[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rows[i][j] = model.intVar("c_" + i + "_" + j, 1, n, false);
                cols[j][i] = rows[i][j];
            }
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < s; k++) {
                    for (int l = 0; l < s; l++) {
                        shapes[j + k * s][i + (l * s)] = rows[l + k * s][i + j * s];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            model.allDifferent(rows[i]).post();
            model.allDifferent(cols[i]).post();
            model.allDifferent(shapes[i]).post();

        }
    }

    // Check all parameters values
    public static void checkOption(CommandLine line, String option) {

        switch (option) {
            case "inst":
                instance = Integer.parseInt(line.getOptionValue(option));
                break;
            case "timeout":
                timeout = Long.parseLong(line.getOptionValue(option));
                break;
            default: {
                System.err.println("Bad parameter: " + option);
                System.exit(2);
            }

        }

    }

    // Add options here
    private static Options configParameters() {

        final Option helpFileOption = Option.builder("h").longOpt("help").desc("Display help message").build();

        final Option instOption = Option.builder("i").longOpt("instance").hasArg(true).argName("sudoku instance")
                .desc("sudoku instance size").required(false).build();

        final Option limitOption = Option.builder("t").longOpt("timeout").hasArg(true).argName("timeout in ms")
                .desc("Set the timeout limit to the specified time").required(false).build();

        // Create the options list
        final Options options = new Options();
        options.addOption(instOption);
        options.addOption(limitOption);
        options.addOption(helpFileOption);

        return options;
    }

    public void configureSearch() {
        model.getSolver().setSearch(minDomLBSearch(append(rows)));

    }
}

