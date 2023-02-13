import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    // 1. returns list of sums of every row of the (magic) square
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumsOfRows = new ArrayList<>();

        for (int[] row : square) {
            int sum = 0;
            for (int col : row) {
                sum += col;
            }
            sumsOfRows.add(sum);
        }
        return sumsOfRows;

//        // alternative:
//        ArrayList<Integer> sumsOfRows = new ArrayList<>();
//
//        // iterate over the rows within the array of array
//        for (int row = 0; row < square.length; row++) {
//            int sum = 0;
//            // iterate the array within that array
//            for (int column = 0; column < square[row].length; column++) {
//                // while it's on the current row,
//                // add the value in that row
//                sum += square[row][column];
//            }
//            // add sums of rows to the arraylist
//            sumsOfRows.add(sum);
//        }
//        return sums;
    }

    // 2. returns a list that contains sums of every column of the magic square
    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sumOfColumns = new ArrayList<>();

        for (int row = 0; row < square.length; row++) {
            int sum = 0;
            for (int col = 0; col < square[row].length; col++) {

                int value = square[col][row];
                sum += value;
                System.out.println("value: " + value);
            }
            sumOfColumns.add(sum);
        }
        return sumOfColumns;
    }

    // 3. returns a list with the sums of the diagonals of the magic square
    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumOfDiagonals = new ArrayList<>();
        int sum1 = 0;
        int sum2 = 0;
        int size = square.length;

//        for (int row = 0; row < size; row++) {
//
//            for (int col = 0; col < square[row].length; col++) {
//                // first diagonal is the same row/col
//                if (row == col) {
//                    sum1 += square[row][col];
//                }
//                // if row + col index is equal to
//                // length - 1 index
//                // add row|col
//                if ((row + col) == (size - 1)) {
//                    // second diagonal is one less of the column length
//                    sum2 += square[row][col];
//                }
//
//            }
//            sumOfDiagonals.add(sum1);
//            sumOfDiagonals.add(sum2);
//        }

        for (int row = 0; row < square.length; row++) {
            sum1 += square[row][row];
            sum2 += square[row][size - (row + 1)];
        }
        sumOfDiagonals.add(sum1);
        sumOfDiagonals.add(sum2);
        return sumOfDiagonals;
    }


    /* ---------------------------------------------------------------- */

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
