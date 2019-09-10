import java.util.Hashtable;
import java.util.Set;;

/**
 * PROBLEM 1.2 : Check Permutation 
 * 
 * Given two strings, write a method to decide if one is a permutation of the other
 */
public class Problem1_2{

    public static void main(String[] args) {

        // The strings to be compared
        String str1 = "aafbcj";
        String str2 = "bagcaf";

        if(isPermut(str1, str2))
            System.out.println("They are permutations");
        else
            System.out.println("They are NOT permutations");
    }

    /**
     * SOLUTION 
     * 
     * Runtime Complexity : O(n)
     * 
     * First of all, the strings must be the same length.
     * WThen we can use a Hashtable which map each character to an integer value.
     * For each character in the FIRST string we INCREMENT his value.
     * For each character in the SECOND string we DECREMENT his value.
     * If the strings are permutations of each other, then all values must
     * be equal to zero.
     * 
     * Besides, we could solve the problem without using a Hastable simply
     * by sorting both strings and then the two strings must be equals.
     * However the complexity of this solution is less optimal because of the
     * sorting bottleneck O(nlog(n))
     * 
     * @param str1 The first string
     * @param str2 The second string
     * @return false if the first string is not a permutation of the second,
     * return true otherwise
     */
    public static boolean isPermut(String str1, String str2){

        if(str1.length() != str2.length())
            return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Hashtable <String, Integer> countMap = new Hashtable<>();

        // Declarations for the loop
        int prevCount = 0;
        String curr1 = "";
        String curr2 = "";

        for(int i=0; i<chars1.length; i++){
            curr1 = Character.toString(chars1[i]);
            curr2 = Character.toString(chars2[i]);

            // Add 1 for the character of the first string
            if(countMap.containsKey(curr1)){
                prevCount = countMap.get(curr1);
                countMap.put(curr1, prevCount + 1);
            } else 
                countMap.put(curr1, 1);
        
            // Remove 1 for the character of the second string
            if(countMap.containsKey(curr2)){
                prevCount = countMap.get(curr2);
                countMap.put(curr2, prevCount - 1);
            } else 
                countMap.put(curr2, -1);
        }

        Set <String> keys = countMap.keySet(); 

        // Check if all counts equal 0
        for(String key : keys){
            if(countMap.get(key) != 0)
                return false;
        }

        return true;
    }
}