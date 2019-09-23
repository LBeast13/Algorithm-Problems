/**
 * PROBLEM 5.5 : Debugger
 * 
 * Explain what the following code does : ((n & (n-1)) == 0)
 * 
 */
public class Problem5_5{

    public static void main(String[] args){

        // Input
        int n = 8;

        // Output
        System.out.println(problem(n));

    }

    /**
     * SOLUTION :
     * 
     * This code returns true if n and n-1 have no bit set to one in common.
     * In other words, it returns true if n has only one bit set to one, that is,
     * n is a power of 2.
     * 
     * @param n The number
     * @return true if n is a power of 2
     */
    public static boolean problem(int n){
        return ((n & (n-1)) == 0);
    }
}