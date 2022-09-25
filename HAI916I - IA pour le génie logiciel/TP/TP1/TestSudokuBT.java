public class TestSudokuBT {



    private SudokuBT bt ;
    private SudokuPPC ppc;

    @Test
    void executionTimeTest() {        
        long startTime = System.nanoTime();
        SudokuBT.main(null);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.


    }
}
