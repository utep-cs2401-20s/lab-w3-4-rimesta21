public class TorusGameOfLife extends GameOfLife {
    TorusGameOfLife() {}

    TorusGameOfLife(int s){
        size = s;
    }

    TorusGameOfLife(boolean[][] Arr) {
        size = Arr.length;
        board = new boolean[size][size];
        previous = new boolean[size][size];
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++){
                previous[i][j] = Arr[i][j];
            }
        }
    }


    @Override
    int neighbor(int row, int col) {
        int j, k;
        int count = 0, tempk = 0, tempj =0;
        for(k = -1; k < 2; k++) {
            for(j = -1; j < 2; j++) {
                tempj = j;
                tempk = k;
                if((col + j) < 0) {
                    j++;
                    j = (previous[0].length - 1) ;
                }

                if((row + k) < 0) {
                    k++;
                    k = (previous.length-1) ;
                }

                if(k == 0 && j == 0) {
                    j++; tempj++;
                }

                if((row + k) == previous.length ) {
                    k = -previous.length +1;
                }

                if((col+j) == previous[0].length) {
                    j = -previous[0].length + 1;
                }

                if(previous[row + k][col + j]) {
                    count++;
                }
                j = tempj;
                k = tempk;
            }
        }
        return count;
    }
}
