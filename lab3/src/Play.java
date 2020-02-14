public class Play {
    public static void main (String[] args) {
        boolean[][] play = {
                {true, false, true, true, false},
                {false, false, false, false, false},
                {true, false, false, false, true},
                {false, false, false, false, true},
                {true, false, true, false, false},
        };

        TorusGameOfLife test = new TorusGameOfLife(play);
       test.evolution(4);
       // test.oneStep();
        boolean[][] board = test.getBoard();

        /*
        for (int i = 0; i< play.length; i++) {
            for (int j = 0; j < play[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        } */
    }
}
