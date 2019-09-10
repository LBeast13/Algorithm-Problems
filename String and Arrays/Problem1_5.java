/**
 * PROBLEM 1.5 : One Away
 * 
 * There are three types of edits that can be performed on strings :
 *  - Insert a character
 *  - Remove a character
 *  - Replace a character
 * Given two strings, write a function to check if they are one edit
 * (or zero edits) away.
 * 
 * EXAMPLE :
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class Problem1_5{

    public static void main(String[] args){

        char[] word1 = "pale".toCharArray();
        char[] word2 = "bake".toCharArray();

        if(isEdit(word1, word2))
            System.out.println("It is an edition");
        else
            System.out.println("It is NOT an edition");
    }

    /**
     * SOLUTION 
     * 
     * Runtime Complexity : O(n)
     * 
     * We can first think about what the three edition types mean :
     *  - replacement : both strings are same length and are equals
     * except for one character. We can just use a boolean value as 
     * a flag for differences in the comparision.
     *  - insertion & removal : nearly the same, it is a question
     * of point of view (we had a character from the first to get the 
     * second or we remove a character from the second to get the first).
     * Using two different indexes for the comparision in this case help
     * us to check the single insertion/deletion by comparing both indexes.
     * 
     * @param str1 The first string
     * @param str2 The second string
     * @return true if the strings are one edit away, false otherwise
     */
    public static boolean isEdit(char[] str1, char[] str2){

        if(str1.length == str2.length)  
            return isReplacement(str1,str2);

        else if (str1.length > str2.length)
            return isInsertRemove(str1, str2);

        else if (str1.length < str2.length)
            return isInsertRemove(str2, str1);

        return false;
    }

    /**
     * The Replacement test method.
     * @param str1 The first string
     * @param str2 The second string
     * @return true if we have one/zero replacement, false otherwise
     */
    public static boolean isReplacement(char[] str1, char[] str2){
        
        boolean difference = false; // The flag
        
        for(int i=0; i<str1.length; i++){
            if(str1[i] != str2[i]){
                if(difference)  // True if we have already found a difference
                    return false;

                difference = true;  // First difference found
            }
        }

        return true;
    }
    
    /**
     * Insert/Remove test method.
     * 
     * @param bigStr The biggest string
     * @param smallStr Thesmallest string
     * @return true if we have one removal/insertion, false otherwise
     */
    public static boolean isInsertRemove(char[] bigStr, char[] smallStr){
        
        // Length check
        if(bigStr.length - smallStr.length > 1)
            return false;

        int idxSmall = 0;

        for(int idxBig=0; idxBig<smallStr.length; idxBig++){

            if(bigStr[idxBig] != smallStr[idxSmall])
                idxSmall--;

            if(idxBig - idxSmall > 1)  // True if we found more than 1 difference
                return false;

            idxSmall ++;
        }

        return true;
    }
}