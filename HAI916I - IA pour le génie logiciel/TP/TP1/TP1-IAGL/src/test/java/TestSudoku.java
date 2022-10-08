import me.martin.tp1IAGL.SudokuBT;
import me.martin.tp1IAGL.SudokuPPC;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import static me.martin.tp1IAGL.SudokuPPC.getPPC;
import static org.junit.Assert.assertTrue;


public class TestSudoku {

/*
    Idées :
        Premier a 100 solution
        nombre de solution trouver par algo

 */

    private SudokuBT bt ;
    private SudokuPPC ppc;



    @Test
    public void findTheMostOfSolutions() throws ParseException {
        SudokuBT test = new SudokuBT(4);
        test.findSolutionAll(0, 0);
        int countbt = test.foundSolutions ;

        SudokuPPC ppc = SudokuPPC.getPPC(4, null) ;
        int countppc = ppc.getxSolutions(false, -1);

        System.out.println("-----------------------------------------");
        System.out.println("BT solutions : " + countbt);
        System.out.println("PPC solutions : " + countppc);
        if (countbt > countppc) { System.out.println("More solutions : PPC");
        }else {                         System.out.println("More solutions : BT"); }
        System.out.println("-----------------------------------------");

        assertTrue(true);
    }

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
