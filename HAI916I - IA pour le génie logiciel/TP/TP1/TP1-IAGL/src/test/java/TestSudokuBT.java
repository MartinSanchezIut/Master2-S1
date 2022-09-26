import me.martin.tp1IAGL.SudokuBT;
import me.martin.tp1IAGL.SudokuPPC;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestSudokuBT {

/*
    Idées :
        Combien de solutions en 5sec
        Qui va le plus vite
        Premier a 30 solutions

        Meme chose en faisant varier la taille







        getSolver().solve return true si il y a une solution
        mettre dans un while pour recup toute les solutions





        lire un csv si 0 case vide

        model.arithm(rows[0][0], "=" , 8).post();
                                         .unpost()
 */

    private SudokuBT bt ;
    private SudokuPPC ppc;

    public void compareAlgorithForSize(int size) throws org.apache.commons.cli.ParseException {
        long startTime = System.nanoTime();


        SudokuBT test = new SudokuBT(size);
        test.findSolution(0, 0);


        long endTime = System.nanoTime();

        long durationBT = (endTime - startTime);  //divide by 1000000 to get milliseconds.

        startTime = System.nanoTime();
        SudokuPPC.PPC(size, false, null);
        endTime = System.nanoTime();

        long durationPPC = (endTime - startTime);  //divide by 1000000 to get milliseconds.

        System.out.println("-----------------------------------------");
        System.out.println("BT duration : " + durationBT);
        System.out.println("PPC duration : " + durationPPC);
        if (durationBT > durationPPC) {
            System.out.println("Faster : PPC");
        }else {
            System.out.println("Faster : BT");
        }

        System.out.println("-----------------------------------------");

        assertTrue(true);
        //System.out.println(duration);
    }

    @Test
    public void whoIsFaster() throws org.apache.commons.cli.ParseException {
        compareAlgorithForSize(4);
    }
}
