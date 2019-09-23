/**
 * PROBLEM 5.3 : Flip Bit to Win
 * 
 * You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could create.
 * 
 * EXAMPLE :
 * Input : 1175 (11011101111)
 * Output : 8
 */

 public class Problem5_3{
     public static void main(String[] args){

        // Input
        int input = 8;

        // Output
        int output = maxOnesLength(input);

        System.out.println("Input : " + input + " (" + Integer.toBinaryString(input) + ")");
        System.out.println("Max length with one flip : " + output);
     }

     /**
      * SOLUTION :
      *
      * To solve this, I used the algorithm to convert a decimal number in a 
      * binary number, that is repeat these step until we have a result equal to 0 :
      *     - divide the number by 2
      *     - the rest of the division is one of the bit
      *     - divide the result by 2 and so on
      * For each step we update the current Max and keeping track of the flip number
      * to reset this max.
      * 
      * @param num the number
      * @return the max consecutive one numbers using one flip
      */
     public static int maxOnesLength(int num){
         int rest;
         int flipCount = 0;
         int maxOnes = -1;
         int currMaxOnes = 0;
         int tempMaxOnes = 0;

         while(num != 0){
             rest = num % 2;
             num = num / 2;

             if(rest == 1){     // Current bit is 1
                 currMaxOnes++;

                 // Keep track of the right ones for the next reset of currMaxOnes
                 tempMaxOnes = (flipCount == 1) ? tempMaxOnes + 1 : tempMaxOnes;

             } else if (rest == 0){     // Current bit is 0
                 if (flipCount == 0){
                    currMaxOnes++;
                    flipCount++;
                    tempMaxOnes = 1;
                 } else {   // One flip already done so reset currMaxOnes
                    
                    // Update the max
                    maxOnes = (currMaxOnes > maxOnes) ? currMaxOnes : maxOnes;
                    currMaxOnes = tempMaxOnes;
                    tempMaxOnes = 0;
                    flipCount = 1;
                 }
             }
         }

         return maxOnes;
     }
 }