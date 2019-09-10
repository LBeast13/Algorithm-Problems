import java.util.Arrays;
import java.util.Hashtable;

/**
 * PROBLEM 1.1 : Is Unique 
 * 
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additionnal data structures?
 */
class Problem1_1{

    public static void main(String[] args) {
        
        String str = "anvbser";    //The string to be checked

        // Change with hasUniqueCharSol2 to test the other solution 
        if(hasUniqueCharSol1(str))
            System.out.println("The word '" + str + "' has UNIQUE characters");

        else 
            System.out.println("The word '" + str + "' has DUPLICATE characters");
    }

    /**
     * SOLUTION 1 : Using another data structure (Hashtable)
     * 
     * Runtime Complexity = O(n)
     * 
     * After parsing the String to a char array, we iterate the array
     * and we map each character as a key of the hashtable.
     * When the key is already present in the hashtable, that means the string
     * contains duplicates.
     * 
     * @param str The string to be checked
     * @return false if the string contains duplicate characters, true otherwise.
     */
    public static boolean hasUniqueCharSol1(String str){

        char[] charArr = str.toCharArray();
        Hashtable<String,Integer> map = new Hashtable<>();

        for(char c: charArr){
            String currChar = Character.toString(c);

            if(!map.containsKey(currChar))
                map.put(currChar, 1);
            
            else
                return false;
        }
        return true;
    }

    /**
     * SOLUTION 2 : No use of others data structures
     * 
     * Complexity : O(nlog(n))
     * 
     * This time we first sort the string and then we iterate
     * it comparing the current character with the next one.
     * If they are equals, then the string contains duplicates.
     * 
     * @param str The string to be checked
     * @return false if the string contains duplicate characters, true otherwise.
     */
    public static boolean hasUniqueCharSol2(String str){
        
        char [] sortedStr = sortStr(str);

        for(int i=0; i<sortedStr.length - 1; i++){
            if(sortedStr[i] == sortedStr[i+1])
                return false;
        }
        return true;
    }

    /**
     * The sorting method.
     * 
     * Complexity : O(nlog(n))
     * 
     * @param str The string to be sorted. 
     * @return The sorted char array.
     */
    public static char [] sortStr(String str){
       
        char [] sorted = str.toCharArray();
        Arrays.sort(sorted);

        return sorted;
    }
}