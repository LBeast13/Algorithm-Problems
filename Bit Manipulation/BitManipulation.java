/**
 * This class provide simple bit operation on integers like :
 * <ul>
 *      <li>Get the ith bit</li>
 *      <li>Set the ith bit</li>
 *      <li>Clear the ith bit</li>
 *      <li>Clear all the bits from the most significant bit through the ith bit (left clear)</li>
 *      <li>Clear all the bits from the ith bit through 0 (right clear)</li>
 *      <li>Update the ith bit with the specified value (0 or 1)</li>
 * </ul>
 */
public class BitManipulation{

    public static void main(String[] args){

        // Inputs
        int bits = 18; //10010
        int bitPos = 2; // The bit number (first bit is number 0);
        boolean bitIs1 = true;
        System.out.println("Initial value : " + bits + " = " + Integer.toBinaryString(bits) +"\n");

        // Functions
        int bitValue = getBit(bits, bitPos) ? 1 : 0;
        int bitsSet = setBit(bits, bitPos);
        int bitCleared = clearBit(bits, bitPos);
        int leftBitsCleared = clearAllLeftBits(bits, bitPos);
        int rightBitsCleared = clearAllRightBits(bits, bitPos);
        int updatedBit = updateBit(bits, bitPos, bitIs1);

        // Outputs
        System.out.println("The bit value at position " + bitPos + " is : " + bitValue);
        System.out.println("The value after setting the " + bitPos + " bit to one : " + Integer.toBinaryString(bitsSet));
        System.out.println("The value after clearing the " + bitPos + " bit : " + Integer.toBinaryString(bitCleared));
        System.out.println("The value after left clearing from the " + bitPos + " bit : " + Integer.toBinaryString(leftBitsCleared));
        System.out.println("The value after right clearing from the " + bitPos + " bit : " + Integer.toBinaryString(rightBitsCleared));
        System.out.println("The value after the update of the " + bitPos + " bit : " + Integer.toBinaryString(updatedBit));
    }

    /**
     * Return the bit value at the specified position.
     * @param num The value 
     * @param i The bit position
     * @return true if the bit value at position i is 1, return false otherwise
     */
    public static boolean getBit(int num, int i){
        int mask = (1 << i); // Init a mask of the type 000100
        return ((num & mask) != 0);
    }

    /**
     * Set the bit at position i to 1.
     * @param num The value
     * @param i The bit position
     * @return The initial value with the modified bit.
     */
    public static int setBit(int num, int i){
        int mask = (1 << i); // Init a mask of the type 111011
        return num | mask;
    }

    /**
     * Clear the bit at the specified position.
     * @param num The value
     * @param i The bit position
     * @return The initial value withthe cleared bit at position i
     */
    public static int clearBit(int num, int i){
        int mask = ~(1 << i);
        return num & mask;
    }

    /**
     * Clear All the Bits from the most significant bit through i (inclusive)
     * @param num The value
     * @param i The bit position
     * @return The value which has been left cleared
     */
    public static int clearAllLeftBits(int num, int i){
        int mask = (1 << i) - 1;
        return num & mask; 
    }

    /**
     * Clear All the Bits from i (inclusive) through 0 
     * @param num The value
     * @param i The bit position
     * @return The value which has been right cleared
     */
    public static int clearAllRightBits(int num, int i){
        int mask = (-1 << (i + 1));
        return num & mask; 
    }

    /**
     * Update the ith bit value.
     * @param num The initial value
     * @param i The bit position
     * @param bitIs1 The new value 
     * @return The initial value with the updated ith bit
     */
    public static int updateBit(int num, int i, boolean bitIs1){
        int value = (bitIs1) ? 1 : 0;
        int mask = ~(1 << i);
        return (mask & num) | (value << i);
    }
}