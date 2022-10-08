import me.martin.tp1IAGL.SudokuBT;
import me.martin.tp1IAGL.SudokuPPC;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestSudoku {

/*
    Idées :
        Combien de solutions en 5sec
        Qui va le plus vite
        Premier a 30 solutions

        Meme chose en faisant varier la taille




// taille n du tableau, notion de temps, nombre de solution trouver par algo
//premier qui arrive a 100 solutions
//celui qui trouve le plus de solution

 */

    private SudokuBT bt ;
    private SudokuPPC ppc;


    /*
              Execution time testing
     */

    @Test
    public void firstToFinishForSize4() throws ParseException {
        long startTime = System.nanoTime();
        SudokuBT test = new SudokuBT(4);
        test.findSolution(0, 0);
        long endTime = System.nanoTime();

        long durationBT = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        SudokuPPC.solvePPC(4, false, null);
        endTime = System.nanoTime();

        long durationPPC = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        System.out.println("-----------------------------------------");
        System.out.println("BT duration : " + durationBT);
        System.out.println("PPC duration : " + durationPPC);
        if (durationBT > durationPPC) { System.out.println("Faster : PPC");
        }else {                         System.out.println("Faster : BT"); }
        System.out.println("-----------------------------------------");

        assertTrue(true);
    }

    @Test
    public void firstToFinishForSize9() throws ParseException {
        long startTime = System.nanoTime();
        SudokuBT test = new SudokuBT(9);
        test.findSolution(0, 0);
        long endTime = System.nanoTime();

        long durationBT = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        SudokuPPC.solvePPC(9, false, null);
        endTime = System.nanoTime();

        long durationPPC = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        System.out.println("-----------------------------------------");
        System.out.println("BT duration : " + durationBT);
        System.out.println("PPC duration : " + durationPPC);
        if (durationBT > durationPPC) { System.out.println("Faster : PPC");
        }else {                         System.out.println("Faster : BT"); }
        System.out.println("-----------------------------------------");

        assertTrue(true);
    }

    @Test
    public void firstToFinishForSize16() throws ParseException {
        long startTime = System.nanoTime();
        SudokuBT test = new SudokuBT(16);
        test.findSolution(0, 0);
        long endTime = System.nanoTime();

        long durationBT = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        SudokuPPC.solvePPC(16, false, null);
        endTime = System.nanoTime();

        long durationPPC = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        System.out.println("-----------------------------------------");
        System.out.println("BT duration : " + durationBT);
        System.out.println("PPC duration : " + durationPPC);
        if (durationBT > durationPPC) { System.out.println("Faster : PPC");
        }else {                         System.out.println("Faster : BT"); }
        System.out.println("-----------------------------------------");

        assertTrue(true);
    }



    @Test
    public void allSolutionsForSize4() throws ParseException {
        long startTime = System.nanoTime();
        SudokuBT test = new SudokuBT(4);
        test.findSolutionAll(0, 0);
        long endTime = System.nanoTime();

        long durationBT = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        SudokuPPC.solveAllPPC(4, false, null);
        endTime = System.nanoTime();

        long durationPPC = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        System.out.println("-----------------------------------------");
        System.out.println("BT duration : " + durationBT);
        System.out.println("PPC duration : " + durationPPC);
        if (durationBT > durationPPC) { System.out.println("Faster : PPC");
        }else {                         System.out.println("Faster : BT"); }
        System.out.println("-----------------------------------------");

        assertTrue(true);
    }

    @Test
    public void allSolutionsForSize9() throws ParseException {
        long startTime = System.nanoTime();
        SudokuBT test = new SudokuBT(9);
        test.findSolutionAll(0, 0);
        long endTime = System.nanoTime();

        long durationBT = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        SudokuPPC.solveAllPPC(9, false, null);
        endTime = System.nanoTime();

        long durationPPC = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        System.out.println("-----------------------------------------");
        System.out.println("BT duration : " + durationBT);
        System.out.println("PPC duration : " + durationPPC);
        if (durationBT > durationPPC) { System.out.println("Faster : PPC");
        }else {                         System.out.println("Faster : BT"); }
        System.out.println("-----------------------------------------");

        assertTrue(true);
    }

    @Test
    public void allSolutionsForSize16() throws ParseException {
        long startTime = System.nanoTime();
        SudokuBT test = new SudokuBT(16);
        test.findSolutionAll(0, 0);
        long endTime = System.nanoTime();

        long durationBT = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        startTime = System.nanoTime();
        SudokuPPC.solveAllPPC(16, false, null);
        endTime = System.nanoTime();

        long durationPPC = (endTime - startTime);  //divide by 1000000 to get milliseconds.


        System.out.println("-----------------------------------------");
        System.out.println("BT duration : " + durationBT);
        System.out.println("PPC duration : " + durationPPC);
        if (durationBT > durationPPC) { System.out.println("Faster : PPC");
        }else {                         System.out.println("Faster : BT"); }
        System.out.println("-----------------------------------------");

        assertTrue(true);
    }
}
