/**
 * PROBLEM 1.7 : Rotate Matrix
 * 
 * Given an image represented by an NxN matrix, where each pixel in the
 * image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place ?
 */
public class Problem1_7 {

    public static void main(String[] args){

        long[][] matrix ={{10, 11, 12, 13},
                          {14, 15, 16, 17},
                          {18, 19, 20, 21},
                          {22, 23, 24, 25}};

        long[][] matrix2 ={{10, 11, 12, 13, 14},
                           {15, 16, 17, 18, 19},
                           {20, 21, 22, 23, 24},
                           {25, 26, 27, 28, 29},
                           {30, 31, 32, 33, 34}};

        long[][] rotated = rotate(matrix);

        display(rotated);
    }

    /**
     * SOLUTION
     * 
     * Complexity : O(n^2)
     * 
     * The only data structure that we can use is the matrix.
     * As a result, the idea is to visualize the matrix as several
     * layers representing squares.
     *   ______
     *  |  __  | For example here we have two layers.
     *  | |__| |
     *  |______|
     * 
     * Then, we will simply iterate the different layers and for each
     * one we are going to swap the pixels of :
     *  - the top to the right
     *  - the right to the bottom
     *  - the bottom to the left
     *  - the left to the top
     * 
     * Make sure to keep track of the boundaries of the current layers
     * and also of the offset for the current pixel in the edge.
     * 
     * @param matrix The matrix to rotate
     * @return the rotated matrix
     */
    public static long[][] rotate(long[][] matrix){
        int n = matrix[0].length;

        // We are going from the outside to the inside of the matrix
        for(int layer=0; layer<n/2; layer++){

            // The boundaries of the current layer
            int first = layer;
            int last = n - (layer + 1);

            // Swap each edge of the layer to the next edge
            for(int j=layer; j<last; j++){

                // The offset for the current pixel 
                int offset = j - first;

                // Save the values of the pixels that will be swapped
                long pixelTop = matrix[first][j];
                long pixelRight = matrix[j][last];
                long pixelBottom = matrix[last][last-offset];
                long pixelLeft = matrix[last-offset][first];

                // Swap Top to Right
                matrix[j][last] = pixelTop;

                // Swap Right to Bottom
                matrix[last][last-offset] = pixelRight;

                // Swap Bottom to Left
                matrix[last-offset][first] = pixelBottom;

                // Swap Left to Top
                matrix[first][j] = pixelLeft;
            }
        }

        return matrix;
    }

    /**
     * Display the matrix in the console.
     * @param matrix the matrix to display
     */
    public static void display(long[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}