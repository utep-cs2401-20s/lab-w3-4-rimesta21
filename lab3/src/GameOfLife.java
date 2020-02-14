public class GameOfLife {
    int size;
    boolean[][] board;
    boolean[][] previous;

    GameOfLife() {}

    GameOfLife(int s) {
        size = s;
    }

    GameOfLife(boolean[][] Arr) {
        size = Arr.length;
        board = new boolean[size][size];
        previous = new boolean[size][size];
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++){
                previous[i][j] = Arr[i][j];
            }
        }
    }

    boolean[][] getBoard(){
        return board;
    }

    int neighbor(int row, int col) {
        int j, k;
        int count = 0;
            for(k = -1; k < 2; k++) {
                for(j = -1; j < 2; j++) {
                    if((col + j) < 0) {
                        j++;
                    }

                    if((row + k) < 0) {
                        k++;
                    }

                    if(k == 0 && j == 0) {
                        j++;
                    }


                    if((row + k) == previous.length ) {
                        k = 2;
                        break;
                    }

                    if((col+j) == previous[0].length) {
                        break;
                    }

                    if(previous[row + k][col + j]) {
                         count++;

                     }
                }
        }

        return count;
    }

    void oneStep() {
        int alive = 0;
        for(int i = 0; i < previous.length; i++) {
            for(int j = 0; j < previous[i].length;j++){
                alive = neighbor(i,j);
                if(previous[i][j]){
                    if(alive < 2 || alive > 3) {
                        board[i][j] = false;
                    } else {
                        // had to do this because board is initially all false so you have to set the true values
                        board[i][j] = true;
                    }
                } else {
                    if(alive == 3) {
                        board[i][j] = true;
                    }
                }

            }
        }
    }

    void evolution(int n) {
        for(int i = 0;i < n; i++ ){
            oneStep();
            printBoards();
            for (int j = 0; j < previous.length; j++){
                for (int k = 0; k < previous[j].length; k++){
                    previous[j][k] = board[j][k];
                }
            }
        }
    }

    void printBoards(){
        System.out.println("Previous");
        for (int i = 0; i< previous.length; i++) {
            for (int j = 0; j < previous[i].length; j++) {
                System.out.print(previous[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Board");
        for (int i = 0; i< previous.length; i++) {
            for (int j = 0; j < previous[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
