/**
 * PROBLEM 5.2 : Binary to String
 * 
 * Given a real number between 0 and 1 (eg., 0.72) that is passed in as a double,
 * print the binary representation. If the number cannot be represented accurately 
 * in binary with at most 32 characters print "ERROR."
 */
public class Problem5_2{

    public static void main(String[] args){

        // Input
        double input = 0.375;

        // Output
        printBinaryRepresentation(input);
    }

    /**
     * SOLUTION
     * 
     * To tranform a real number into his binary representation I will show
     * you a simple algorithm with an example :
     * Initial number = 0.375
     *      0.375 * 2 = 0 + 0.75
     *      0.75  * 2 = 1 + 0.5
     *      0.5   * 2 = 1 + 0
     * We take the decimal parts of each step of the algorithm and here we 
     * have our binary representation of 0.375 : .011
     * 
     * @param num The real number in decimal representation
     */
    public static void printBinaryRepresentation(double num){

        int count = 0;  // The characters count
        int decPart;    // The decimal part after each iteration

        StringBuilder res = new StringBuilder();
        res.append("Binary representation : .");

        // while the decimal part is not equal to zero
        while(num != 0){
            count++;

            num = num * 2;
            decPart = (int) num;    // Get the decimal part representing a bit (0 or 1)
            num = (decPart == 1) ? num - 1 : num;   // Get the fraction part for the next iteration

            if(count > 32){ // More than 32 characters used
                res = new StringBuilder();
                res.append("ERROR");
                break;
            } else {
                res.append(decPart);
            }
        }

        System.out.println(res.toString());
    }
}