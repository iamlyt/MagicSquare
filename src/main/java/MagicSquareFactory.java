
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        // if the size is an even number, throw exception
        if (size % 2 == 0) throw new RuntimeException("Number can only be ODD!");
        // implement the creation of a magic square with the Siamese method algorithm here

        // -- loop the amount of numbers that will exist in square
        // -- size * size
        int numbersInSquare = size * size;
        
        for (int i = 1; i < numbersInSquare; i++) {
            // conditions:
            // if moves outside of box -- jump to opposite edge
            // if on right, move to left
            // if on top, move to bottom
        }

        return square;
    }

}

// check if square if odd (we want odd)
// then iterate over square to add numbers in
// when it's the first number, put it in the median top row (middle of top row)
// then implement condition:

// - place first number in the median first row
// -

// lastly, check if diagonal, row, and column sums are SAME
