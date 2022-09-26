public class TestSudokuBT {

/*
    Idées :
        Combien de solutions en 5sec
        Qui va le plus vite
        Premier a 30 solutions

        Meme chose en faisant varier la taille





        Model.with(contrainte).post()
                              .unpost()

        getSolver().solve return true si il y a une solution
        mettre dans un while pour recup toute les solutions


        lire un csv si 0 case vide

        model.arithm(rows[0][0], "=" , 8).post();

 */

    private SudokuBT bt ;
    private SudokuPPC ppc;

    @Test
    void whoIsFasterForSize(int size) throws ParseException {
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
    void whoIsFasterForSizeFrom4To8() throws ParseException {
       // whoIsFasterForSize(4);
        whoIsFasterForSize(5);
       // whoIsFasterForSize(6);
       // whoIsFasterForSize(7);
       // whoIsFasterForSize(8);
    }
}
