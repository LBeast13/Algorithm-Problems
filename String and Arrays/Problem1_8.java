/**
 * PROBLEM 1.8 : Zero Matrix
 * 
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
public class Problem1_8{

    public static void main(String[] args){

        long[][] matrix ={{3, 1, 2, 3},
                          {4, 5, 6, 7},
                          {8, 9, 0, 1},
                          {2, 3, 4, 5},
                          {6, 7, 8, 9}};

        matrix = zeroMatrix(matrix);

        display(matrix);
    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(n*m)
     * 
     * We have to keep in mind that we can't nullify an entire 
     * column and row as soon as we find a zero in the matrix.
     * Why ? Because it is possible that this row/column contains
     * other zero that we don't have discovered yet !
     * The idea is to realize that we do not have to remember the
     * exact position of the 0s in the matrix. Indeed we just want
     * to know if that column/row contains a 0.
     * 
     * So when we find a 0 at index matrix[i][j], we store a zero:
     *  - in the first row at position j : matrix[0][j]
     *  - in the first column at position i : matrix[i][0]
     * 
     * When we finish to iterate the matrix we just iterate the first
     * column and the first row to now which row(s)/column(s) we have
     * to nullify.
     * 
     * Tip : We also waive two flags in the first matrix iteration
     * in order to know if the first row/column contains a zero.
     * Then we don't have no forget this row/column at the end of the 
     * algorithm.
     * 
     * @param matrix The matrix to format
     * @return the formatted matrix
     */
    public static long[][] zeroMatrix(long[][] matrix){
        boolean foundZero = false;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        int n = matrix[0].length;
        int m = matrix.length;

        // Check for 0s in the matrix and store row/col position
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                    foundZero = true;

                    if(row == 0) firstRowZero = true;
                    if(col == 0) firstColZero = true;
                }

            }
        }

        // Early finish if no 0 was found
        if(!foundZero) return matrix;

        // Nullify the specified columns
        for(int col=1; col<n; col++){
            if(matrix[0][col] == 0) 
                matrix = setZeroCol(matrix, m, col);
        }

        // Nullify the specified rows
        for(int row=1; row<n; row++){
            if(matrix[row][0] == 0) 
                matrix = setZeroRow(matrix, n, row);
        }

        // Nullify the first row if it contains a 0 in the original matrix
        if(firstRowZero) matrix = setZeroRow(matrix, n, 0);

        // Nullify the first column if it contains a 0 in the original matrix
        if(firstColZero) matrix = setZeroCol(matrix, m, 0);

        return matrix;
    }

    /**
     * Set all the specified column of the matrix to 0
     * 
     * @param matrix The matrix to apply the transformation
     * @param height The height of the matrix (M)
     * @param col The col index we want to nullify
     * @return The formatted matrix
     */
    public static long[][] setZeroCol(long[][] matrix, int height, int col){
        for(int row=1; row<height; row++){
            matrix[row][col] = 0;
        }
        return matrix;
    }

    /**
     * Set all the specified row of the matrix to 0
     * 
     * @param matrix The matrix to apply the transformation
     * @param width The width of the matrix (N)
     * @param row The row index we want to nullify
     * @return The formatted matrix
     */
    public static long[][] setZeroRow(long[][] matrix, int width, int row){
        for(int col=1; col<width; col++){
            matrix[row][col] = 0;
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