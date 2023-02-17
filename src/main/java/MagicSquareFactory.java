
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        // if the size is an even number, throw exception
        if (size % 2 == 0) throw new RuntimeException("Number can only be ODD!");

        // initialize number 1 position
        int row = 0;
        int col = size / 2;
        square.placeValue(col, row, 1);
        // intialize variable for size squared + 1 to iterate through
        int numSquared = (size * size) + 1;

        // iterate through numbers of size * size
        for (int num = 2; num < numSquared; num++) {

            // condition 3:
            // fundamental movements
            col++;
            row--;

            // condition 1:
            // if both row and col is out of bounds
            // row == -1
            // col == size
            if (row == -1 && col == size) {
                // go back one col
                col--;
                // go down 2 rows
                row += 2;

            } else {    // if it's not both conditions

                // if JUST row is out of bounds
                if (row == -1) {
                    // set row to the last row == size - 1
                    row = size - 1;
                }
                // if JUST col is out of bounds
                if (col == size) {
                    // set col to first col == 0
                    col = 0;
                }

            }

            // condition 2:
            // if there's a number in that position
            // square.readValue(col, row) != 0
            if (square.readValue(col, row) != 0) {
                // go down 2 rows
                row += 2;
                // go back 1 column;
                col--;
            }
            // set numbers' positions
            square.placeValue(col, row, num);

        }

        return square;
    }

}

// conditions:
// if moves outside of box -- jump to opposite edge
// if on right, move to left
// if on top, move to bottom
// if a num is already there, go one row down -- same column
/* ----------------------------------------------------------------------------- */
// check if square if odd (we want odd)
// then iterate over square to add numbers in
// when it's the first number, put it in the median top row (middle of top row)
// then implement condition:

// - place first number in the median first row
// -

// lastly, check if diagonal, row, and column sums are SAME
//if (square.readValue(row, col) > 0) {
//
//        square.placeValue(row + 1, col, i);
//
//        }