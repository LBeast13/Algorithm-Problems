import java.util.Hashtable;
import java.util.Set;

/**
 * PROBLEM 1.4 : Palindrome Permutation
 * 
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwars and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * 
 * EXAMPLE
 * Input : Tact Coa
 * Output : True (permutations: "taco cat", "atco cta" ...)
 */
public class Problem1_4 {

    public static void main(String [] args){

        char[] str = "Tact Coa".toCharArray();  // The string to be checked

        if(isPalindromePermut(str))
            System.out.println("It is a palindrome permutation");
        else
            System.out.println("It is NOT a palindrome permutation");
    }


    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(n)
     * 
     * The first thing to have in mind is DON'T COMPUTE ALL PERMUTATIONS !
     * Indeed that would be a O(n!) complexity what is awful.
     * So the idea is to ask ourself what are the characteristics of a 
     * palindrome ? 
     * We can see that when we have a even length for a string, the number
     * of occurences of each character is also even. 
     * For a string with an odd length, this is also true except for one
     * character which will have an odd number of occurences.
     * We only have to iterate the string one time in order to count the 
     * characters with an odd number of occurences.
     * If the count is lower or equal to 1 then it is a palindrome permutation.
     * 
     * @param str The string to be checked
     * @return True if it is a palindrome permutation, false otherwise.
     */
    public static boolean isPalindromePermut(char[] str){

        Hashtable<Character, Integer> countMap = new Hashtable<>();
        int oddCount = 0;

        for(char c: str){
            if(c != ' '){   // We check if it is not a blank space
                c = Character.toLowerCase(c);

                if(countMap.containsKey(c))
                    countMap.put(c, countMap.get(c) + 1);
                else
                    countMap.put(c,1);

                oddCount = countMap.get(c) % 2 == 1 ? oddCount+1 : oddCount-1;
            }
        }
        
        return oddCount <= 1;
    }
}