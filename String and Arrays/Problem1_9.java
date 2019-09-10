/**
 * PROBLEM 1.9 : String Rotation
 * 
 * Assume you have a method isSubstring which checks if one
 * word is a substring of another. 
 * Given two strings s1 and s2, write code to check if s2 is
 * a string rotation of s1 using only one call to isSubstring.
 * 
 * EXAMPLE :
 * "waterbottle" is a rotation of "erbottlewat"
 */
public class Problem1_9{

    public static void main(String[] args){
        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        if(isRotate(str1, str2))
            System.out.println("It is a Rotation");
        else
            System.out.println("It is NOT a Rotation");
    }

    /**
     * SOLUTION 
     * 
     * Runtime Complexity : O(N) assuming that we have O(N) complexity
     * for the isSubstring method
     * 
     * The point is to see that in a rotation we cut the string in 
     * two parts :
     *  str1 = xy = waterbottle
     *  str2 = yx = erbottlewat
     * So :
     *  x = wat
     *  y = erbottle
     * Then we can see that if we concatenate one of the string with
     * itself, if we have a rotation then the other string will obviously
     * be a substring of the concatenation :
     * str1 + str1 --> waterbottlewaterbottle
     * str2 -->           erbottlewat
     * 
     * Note : I use a isSubstring method just to be able to test my solution.
     * It has a bad runtime complexity of O(N*M) where N and M are the length
     * of the different strings that can be improved to O(N)
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isRotate(String str1, String str2){

        if(str1.length() != str2.length()) 
            return false;

        String str1Concat = str1 + str1;
        
        return isSubstring(str2, str1Concat);
    }

    /**
     * Runtime Complexity : O(m*n) with m and n the length of s1 and s2
     * 
     * We could definetely improve this complexity but it is not the point 
     * in this problem, however you can improve it if you like challenges ! 
     * 
     * @param s1 The first string
     * @param s2 The second string
     * @return true if s1 is a substring of s2, false otherwise
     */
    public static boolean isSubstring(String s1, String s2) 
    { 
        int length1 = s1.length(); 
        int length2 = s2.length(); 
      
        for (int i=0; i<=length2-length1; i++) { 
            int j; 
      
            //For current index i, check for pattern match 
            for (j=0; j<length1; j++) 
                if (s2.charAt(i+j) != s1.charAt(j)) 
                    break; 
      
            if (j == length1) return true; 
        } 
        return false; 
    } 
}