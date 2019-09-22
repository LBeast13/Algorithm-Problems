/**
 * PROBLEM 5.1 : Insertion
 * 
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not, for example, have j = 3 and i = 2, because M could not fully fit 
 * between bit 3 and bit 2.
 * 
 * EXAMPLE
 * 
 * Input:  N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 * 
 */
public class Problem5_1{
    public static void main(String[] args){

        // Inputs
        int n = 1024;
        int m = 19;
        int i = 2;
        int j = 6;
        System.out.println("N = " + Integer.toBinaryString(n));
        System.out.println("M = " + Integer.toBinaryString(m));
        System.out.println("i (start) = " + i + " ; j (end) = " + j + "\n");

        // Output
        int output = insertInto(n, m, i, j);
        System.out.println("Output = " + Integer.toBinaryString(output));
    }

    /**
     * SOLUTION
     * 
     * To solve this problem you have three main steps :
     *      1. Clear the bits between i and j in N.
     *      2. Left Shift M
     *      3. Merge N and M.
     * To clear the bits in N we need a mask with ones at the beginning and at 
     * the end, and zeros in the middle (for example : 11100000011). To build such a mask
     * we create two masks :
     *      - beginning with ones and finishing with zeros (111000000000)
     *      - beginning with zeros and ending with ones (00000000001111)
     * Then we only have to merge them and we have our final mask to clear N.
     * The other steps are easy and the code speak for itself.
     * 
     * @param n The first number
     * @param m The second number we want to insert
     * @param i The starting bit position
     * @param j The ending bit position
     * @return The N number with M inserted into it.
     */
    public static int insertInto(int n, int m, int i, int j){
        n = clearBitsInterval(n, i, j);
        m = (m << i); 
        return n + m;
    }

    /**
     * 
     * @param n The number containing the bits to clear
     * @param i The starting bit position for the removal
     * @param j The ending bit position for the removal
     * @return The initial number with the bits between i and j set to zero.
     */
    public static int clearBitsInterval(int n, int i, int j){
        int mask1 = (-1 << j+1);    // Mask of type 11100000
        int mask2 = (1 << i) - 1;   // Mask of type 00000011
        return (mask1 + mask2) & n; // Merge the masks (11100011) and use it to clear N
    }
}