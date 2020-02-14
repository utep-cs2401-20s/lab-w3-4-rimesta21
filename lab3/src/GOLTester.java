import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GOLTester {
    @Test
    public void neighborTest1(){
        boolean[][] play = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        GameOfLife test = new GameOfLife(play);
        int row = 0, col = 0;
        assertEquals(0,test.neighbor(row,col));
        // Test Passed. I check the corner to check whether I'd get an out of bounds error
    }

    @Test
    public void neighborTest2(){
        boolean[][] play = new boolean[6][6];
        play[2][2] = play[2][3] = play[2][4] = true;
        play[3][1] = play[3][2] = play[3][3] = true;
        GameOfLife test = new GameOfLife(play);
        int row = 2, col = 5;
        assertEquals(1,test.neighbor(row,col));
        /* Test Passed. I checked the right edge of the board to check for an out of bounds error and to make sure it
        it counts it's neighbor */
    }

    @Test
    public void neighborTest3(){
        boolean[][] play = new boolean[6][6];
        play[1][1] = play[1][2] = play[2][1] = play[2][2] = true;
        play[3][3] = play[3][4] = play[4][3] = play[4][4] = true;
        GameOfLife test = new GameOfLife(play);
        int row = 5, col = 1;
        assertEquals(0,test.neighbor(row,col));
        /* Test Passed. I checked the bottom edge of the board to make sure the method does not return an
         out of bounds */
    }

    @Test
    public void neighborTest4(){
        boolean[][] play = new boolean[18][18];

        play[2][5] = play[3][4] = play[3][5] = play[3][6] = true;
        play[4][3] = play[4][5] = play[4][7] = true;
        play[5][3] = play[5][5] = play[5][7] = true;
        play[7][5] = play[6][4] = play[6][5] = play[6][6] = true;

        play[10][5] = play[11][4] = play[11][5] = play[11][6] = true;
        play[12][3] = play[12][5] = play[12][7] = true;
        play[13][3] = play[13][5] = play[13][7] = true;
        play[15][5] = play[14][4] = play[14][5] = play[14][6] = true;

        GameOfLife test = new GameOfLife(play);
        int row = 4, col = 4;
        assertEquals(6,test.neighbor(row,col));
        /* Test Passed. I checked the middle of the board to make sure the method counts correctly (especially when
        * it's surrounded by a lot of neighbors) */
    }

    @Test
    public void neighborTest5(){
        boolean[][] play = {
                {true, true},
                {true, false}
        };

        GameOfLife test = new GameOfLife(play);
        int row = 1, col = 1;
        assertEquals(3,test.neighbor(row,col));
        /* Test Passed. I checked a 2x2 to see if the method counts all of its neighbors (which in this case is all
        of the cells next to it) while at the same time not getting an out of bounds error */
    }

    @Test
    public void oneStepTest1() {
        boolean[][] play = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        GameOfLife test = new GameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[5][5];
        expected[1][2] = expected[2][2] = expected[3][2] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /* Test passed. I'm not sure if this is the best way to test it but my rationale is if you test every single
        value of expected against what one step is giving, you could find if one of the cells is wrong. If one of the
        cells is wrong then it should fail and the method isn't working correctly
         */
    }

    @Test
    public void oneStepTest2() {
        boolean[][] play = new boolean[6][6];
        play[2][2] = play[2][3] = play[2][4] = true;
        play[3][1] = play[3][2] = play[3][3] = true;

        GameOfLife test = new GameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[6][6];
        expected[1][3] = expected[2][1] = expected[2][4] = expected[3][1] = expected[3][4] = expected[4][2] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        //Test passed
    }

    @Test
    public void oneStepTest3() {
        boolean[][] play = new boolean[6][6];
        play[1][1] = play[1][2] = play[2][1] = play[2][2] = true;
        play[3][3] = play[3][4] = play[4][3] = play[4][4] = true;

        GameOfLife test = new GameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[6][6];
        expected[1][2] = expected[1][1] = expected[2][1] = expected[3][4] = expected[4][3] = expected[4][4] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        //Test passed
    }

    @Test
    public void oneStepTest4() {
        boolean[][] play = new boolean[18][18];

        play[2][5] = play[3][4] = play[3][5] = play[3][6] = true;
        play[4][3] = play[4][5] = play[4][7] = true;
        play[5][3] = play[5][5] = play[5][7] = true;
        play[7][5] = play[6][4] = play[6][5] = play[6][6] = true;

        play[10][5] = play[11][4] = play[11][5] = play[11][6] = true;
        play[12][3] = play[12][5] = play[12][7] = true;
        play[13][3] = play[13][5] = play[13][7] = true;
        play[15][5] = play[14][4] = play[14][5] = play[14][6] = true;

        GameOfLife test = new GameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[18][18];

        expected[2][4] = expected[2][5] = expected[2][6] = true;
        expected[4][3] = expected[4][7] = true;
        expected[5][3] = expected[5][7] = true;
        expected[7][5] = expected[7][4] = expected[7][6] = true;

        expected[10][5] = expected[10][4] = expected[10][6] =  true;
        expected[12][3] = expected[12][7] = true;
        expected[13][3] = expected[13][7] = true;
        expected[15][5] = expected[15][4] = expected[15][6] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        //Test passed
    }

    @Test
    public void oneStepTest5() {
        boolean[][] play = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        GameOfLife test = new GameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = {
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /*Test passed. I chose this board because I was curious to see how the method would handle an extreme like
        the array having all the same values. I believe this would be an edge case.
         */
    }

    @Test
    public void evolutionTest1(){
        boolean[][] play = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        GameOfLife test = new GameOfLife(play);
        test.evolution(14);
        boolean[][] board = test.getBoard();

        boolean[][] expected = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. Here I tested evolution with a relative high number (14) to make sure that it worked
         */
    }

    @Test
    public void evolutionTest2(){
        boolean[][] play = new boolean[6][6];
        play[2][2] = play[2][3] = play[2][4] = true;
        play[3][1] = play[3][2] = play[3][3] = true;

        GameOfLife test = new GameOfLife(play);
        test.evolution(8);
        boolean[][] board = test.getBoard();

        boolean[][] expected = play;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. Here I tested evolution with a relative high number (8) to make sure that it worked but this
        time on a different board
         */
    }

    @Test
    public void evolutionTest3(){
        boolean[][] play = new boolean[6][6];
        play[1][1] = play[1][2] = play[2][1] = play[2][2] = true;
        play[3][3] = play[3][4] = play[4][3] = play[4][4] = true;

        GameOfLife test = new GameOfLife(play);
        test.evolution(7);
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[6][6];
        expected[1][2] = expected[1][1] = expected[2][1] = expected[3][4] = expected[4][3] = expected[4][4] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. Here I tested evolution with a relative high number (7) but this time I tested it will an odd
         number of evolutions to see if it didn't revert back to it's starting board.
         */
    }

    @Test
    public void evolutionTest4(){
        boolean[][] play = new boolean[18][18];

        play[2][5] = play[3][4] = play[3][5] = play[3][6] = true;
        play[4][3] = play[4][5] = play[4][7] = true;
        play[5][3] = play[5][5] = play[5][7] = true;
        play[7][5] = play[6][4] = play[6][5] = play[6][6] = true;

        play[10][5] = play[11][4] = play[11][5] = play[11][6] = true;
        play[12][3] = play[12][5] = play[12][7] = true;
        play[13][3] = play[13][5] = play[13][7] = true;
        play[15][5] = play[14][4] = play[14][5] = play[14][6] = true;

        GameOfLife test = new GameOfLife(play);
        test.evolution(4);
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[18][18];

        expected[2][5] = expected[3][4] = expected[3][5] = expected[3][6] = true;
        expected[6][4] = expected[6][5] = expected[6][6] = true;

        expected[8][4] = expected[8][6] = true;
        expected[9][4] = expected [9][6] = true;

        expected[11][4] = expected[11][5] = expected[11][6] =  true;
        expected[14][4] = expected[14][5] = expected[14][6] = true;
        expected[15][5] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. This test was actually very fascinating because unlike the other boards, this board actually changes
        quite quite a lot through evolutions. I did this test on a low number because it is a more complex geometry and
        solving for expected would take a long time for higher iterations. I'm really happy my code was able to
        evolve correctly with this board.
         */
    }

    @Test
    public void EvolutionTest5() {
        boolean[][] play = {
                {false, true, true},
                {true, false, true},
                {true, true, false},
        };

        GameOfLife test = new GameOfLife(play);
        test.evolution(0);
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[3][3];

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /*Test passed. Here I was curious if we don't evolve for any steps whether evolution would do nothing
        and keep the initialized board from the constructor
         */
    }

    //This is where Torus testing starts

    @Test
    public void TorusNeighborTest1(){
        boolean[][] play = {
                {false, false, false, false, true},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {true, false, false, false, true}
        };
        TorusGameOfLife test = new TorusGameOfLife(play);
        int row = 0, col = 0;
        assertEquals(3,test.neighbor(row,col));
        /* Test Passed. I changed the board just a little bit so that I could check that the torus version does
        actually wrap around correctly
         */
    }

    @Test
    public void TorusNeighborTest2(){
        boolean[][] play = new boolean[6][6];
        play[2][2] = play[2][3] = play[2][4] = true;
        play[3][1] = play[3][2] = play[3][3] = true;
        play[5][2] = play[5][3] = true;
        TorusGameOfLife test = new TorusGameOfLife(play);
        int row = 0, col = 2;
        assertEquals(2,test.neighbor(row,col));
        /* Test Passed. Again I modified the board here to make sure that the top of the board wraps around to the bottom
        and counts its neighbors */
    }

    @Test
    public void TorusNeighborTest3(){
        boolean[][] play = new boolean[6][6];
        play[1][1] = play[1][2] = play[2][1] = play[2][2] = true;
        play[3][3] = play[3][4] = play[4][3] = play[4][4] = true;
        play[0][0] = play[0][5] = play[4][0] = true;
        TorusGameOfLife test = new TorusGameOfLife(play);
        int row = 5, col = 5;
        assertEquals(4,test.neighbor(row,col));
        /* Test Passed. I checked the bottom corner and modified the board to make sure the method wraps around and folds
         correctly */
    }

    @Test
    public void TorusNeighborTest4(){
        boolean[][] play = new boolean[18][18];

        play[2][5] = play[3][4] = play[3][5] = play[3][6] = true;
        play[4][3] = play[4][5] = play[4][7] = true;
        play[5][3] = play[5][5] = play[5][7] = true;
        play[7][5] = play[6][4] = play[6][5] = play[6][6] = true;

        play[10][5] = play[11][4] = play[11][5] = play[11][6] = true;
        play[12][3] = play[12][5] = play[12][7] = true;
        play[13][3] = play[13][5] = play[13][7] = true;
        play[15][5] = play[14][4] = play[14][5] = play[14][6] = true;

        TorusGameOfLife test = new TorusGameOfLife(play);
        int row = 4, col = 4;
        assertEquals(6,test.neighbor(row,col));
        /* Test Passed. Here I didn't change anything so that I could make sure that the Torus version did not mess with
         the normal neighbor method. The Torus and nonTorus boards should perform the same on the inside of the board
          the only thing that changes is how the boarders are counted*/
    }

    @Test
    public void TorusNeighborTest5(){
        boolean[][] play = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        TorusGameOfLife test = new TorusGameOfLife(play);
        int row = 2, col = 0;
        assertEquals(8,test.neighbor(row,col));
        /* Test Passed. Here I was wondering if the method would recognize that all of the cells are it's neighbors
        even though it is on the bottom left corner and only "touching" three cells*/
    }

    @Test
    public void TorusOneStepTest1() {
        boolean[][] play = {
                {false, false, false, false, false},
                {false, false, false, false, true},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {true, false, false, false, true}
        };

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[5][5];
        expected[0][0] = expected[1][2] = expected[2][2] = expected[3][2] = expected[2][3] = true;
        expected[1][3] = expected[3][4] = expected[3][0] = expected[3][3] = expected[0][4] = true;
        expected[3][1] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /* Test passed. I made small modifications to this board to see how corners affect the Torus board and I was quite
        surprised on how much it changes the board.
         */
    }

    @Test
    public void TorusOneStepTest2() {
        boolean[][] play = new boolean[6][6];
        play[2][2] = play[2][3] = play[2][4] = true;
        play[3][1] = play[3][2] = play[3][3] = true;
        play[0][0] = play[0][1] = play[0][2] = true;

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[6][6];
        expected[2][1] = expected[2][4] = expected[3][1] = expected[3][4] = expected[4][2] = true;
        expected[0][1] = expected[5][1] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        //Test passed. Checked that the top boarder wraps around.
    }

    @Test
    public void TorusOneStepTest3() {
        boolean[][] play = new boolean[6][6];
        play[1][1] = play[1][2] = play[2][1] = play[2][2] = true;
        play[3][3] = play[3][4] = play[4][3] = play[4][4] = true;
        play[5][0] = play[0][5] = play[5][1] = true;

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[6][6];
        expected[1][2] = expected[1][1] = expected[2][1] = expected[3][4] = expected[4][3] = expected[4][4] = true;
        expected[1][0] = expected[4][5] = expected[5][5] = expected[5][0] = expected[4][2] = true;
        expected[0][2] = expected[5][4] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /*Test passed. It is very cool to see that by only changing three cells to alive increases the number of alive
        cells in the next step by quite a lot.
         */

    }

    @Test
    public void TorusOneStepTest4() {
        boolean[][] play = new boolean[18][18];

        play[0][0] = true;

        play[2][5] = play[3][4] = play[3][5] = play[3][6] = true;
        play[4][3] = play[4][5] = play[4][7] = true;
        play[5][3] = play[5][5] = play[5][7] = true;
        play[7][5] = play[6][4] = play[6][5] = play[6][6] = true;

        play[10][5] = play[11][4] = play[11][5] = play[11][6] = true;
        play[12][3] = play[12][5] = play[12][7] = true;
        play[13][3] = play[13][5] = play[13][7] = true;
        play[15][5] = play[14][4] = play[14][5] = play[14][6] = true;

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[18][18];

        expected[2][4] = expected[2][5] = expected[2][6] = true;
        expected[4][3] = expected[4][7] = true;
        expected[5][3] = expected[5][7] = true;
        expected[7][5] = expected[7][4] = expected[7][6] = true;

        expected[10][5] = expected[10][4] = expected[10][6] =  true;
        expected[12][3] = expected[12][7] = true;
        expected[13][3] = expected[13][7] = true;
        expected[15][5] = expected[15][4] = expected[15][6] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /*Test passed. This might seem like a trivial test case but I wanted to make sure that the Torus game of Life
        doesn't affect the outcome if there are no boarder cells alive. This test shows that for OneStep the Torus and
        regular versions can have the same outcome.
         */
    }

    @Test
    public void TorusOneStepTest5() {
        boolean[][] play = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.oneStep();
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[3][3];

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /*Test passed. I chose this board because I was curious to see how the method would handle an extreme like
        the array having all the same values. I believe this would be an edge case. In this case everyone is everyone's
        neighbor because it is a Torus and everyone died
         */
    }

    @Test
    public void TorusEvolutionTest1(){
        boolean[][] play = {
                {true, false, false, false, false, true, true, false},
                {true, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, true, true, true, false, false},
                {false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, true, true}
        };

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.evolution(4);
        boolean[][] board = test.getBoard();

        boolean[][] expected = {
                {false, true, false, false, true, true, false, false},
                {true, false, false, false, false, false, true, false},
                {true, false, false, false, false, false, true, true},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false},
                {true, false, false, false, true, true, true, false},
                {false, true, false, false, false, false, false, false},
                {false, true, false, false, true, true, false, true,}
        };

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. Here I expanded the original version of this board to see if I were to put alive cells around
         the boarder where normally they would just die, would they have an impact now. And they did!
         */
    }

    @Test
    public void TorusEvolutionTest2(){
        boolean[][] play = new boolean[8][8];
        play[2][2] = play[2][3] = play[2][4] = true;
        play[3][1] = play[3][2] = play[3][3] = true;

        play[0][6] = play[0][7] = play[7][5] = play[7][0] = play[7][6] = play[6][0] = true;

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.evolution(4);
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[8][8];

        expected[0][5] = expected[0][6] = expected[0][7] = true;
        expected[3][1] = expected[3][2] = true;
        expected[6][5] = expected[6][6] = expected[6][7] = true;
        expected[7][0] = expected[7][5] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. Same Rationale as the other one. Expanded game board and added small entries that normal would
        have no impact but now it did
         */
    }

    @Test
    public void TorusEvolutionTest3(){
        boolean[][] play = new boolean[7][7];
        play[1][1] = play[1][2] = play[2][1] = play[2][2] = true;
        play[3][3] = play[3][4] = play[4][3] = play[4][4] = true;
        play[0][6] = play[6][0] = play[0][5] = true;

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.evolution(4);
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[7][7];
        expected[0][0] = expected[0][5] = expected[0][6] = true;
        expected[1][2] = expected[1][3] = expected[1][5] = true;
        expected[2][0] = expected[3][0] = expected[3][1] = expected[3][4] = true;
        expected[4][3] = expected[4][4] = expected[6][6] = true;


        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. Here I only changed three inputs and it changed everything. I think it is safe to say that the
        Torus works.
         */
    }

    @Test
    public void TorusEvolutionTest4(){
        boolean[][] play = new boolean[18][18];

        play[2][5] = play[3][4] = play[3][5] = play[3][6] = true;
        play[4][3] = play[4][5] = play[4][7] = true;
        play[5][3] = play[5][5] = play[5][7] = true;
        play[7][5] = play[6][4] = play[6][5] = play[6][6] = true;

        play[10][5] = play[11][4] = play[11][5] = play[11][6] = true;
        play[12][3] = play[12][5] = play[12][7] = true;
        play[13][3] = play[13][5] = play[13][7] = true;
        play[15][5] = play[14][4] = play[14][5] = play[14][6] = true;

        play[0][17] = play[16][17] = play[17][0] = true;

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.evolution(4);
        boolean[][] board = test.getBoard();

        boolean[][] expected = new boolean[18][18];

        expected[2][5] = expected[3][4] = expected[3][5] = expected[3][6] = true;
        expected[6][4] = expected[6][5] = expected[6][6] = true;

        expected[8][4] = expected[8][6] = true;
        expected[9][4] = expected [9][6] = true;

        expected[11][4] = expected[11][5] = expected[11][6] =  true;
        expected[14][4] = expected[14][5] = expected[14][6] = true;
        expected[15][5] = true;

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j],board[i][j]);
            }
        }
        /* Test Passed. This time I only added inputs that would still be counted but not affect the original game board.
        Just to make sure that Torus and the regular game board can still have the same outcome
         */
    }

    @Test
    public void TorusEvolutionTest5() {
        boolean[][] play = {
                {true, false, true, true, false},
                {false, false, false, false, false},
                {true, false, false, false, true},
                {false, false, false, false, true},
                {true, false, true, false, false},
        };

        TorusGameOfLife test = new TorusGameOfLife(play);
        test.evolution(4);
        boolean[][] board = test.getBoard();

        boolean[][] expected ={
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, false, false},
                {true, false, false, false, false},
                {false, true, true, false, false},
        };

        for(int i = 0; i < play.length; i++){
            for(int j = 0; j < play[i].length; j++){
                assertEquals(expected[i][j], board[i][j]);
            }
        }
        /*Test passed. For my final test I wanted to show how only having border entries would give an actual result
        as opposed to nothing byt false
         */
    }

}
