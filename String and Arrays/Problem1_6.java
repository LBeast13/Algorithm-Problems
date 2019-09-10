/**
 * PROBLEM 1.6 : String Compression
 * 
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string.
 * 
 * EXAMPLE :
 * Input : aabcccccaaa
 * Output : a2b1c5a3
 */
public class Problem1_6{

    public static void main(String[] args){

        String str = "aabcaaagggg";  // The string to be compressed

        System.out.println(str + " --> Compression --> " + compress(str));
    }

    /**
     * SOLUTION 
     * 
     * Runtime Complexity : O(n)
     * 
     * The idea is to iterate the string to count the consecutive characters
     * and also check if the next character is the same.
     * We could do this with a string concatenation but it shows very bad 
     * performance because for each iteration, it would copy the content of 
     * the string and create a new one.
     * To avoid that performance problem I used the StringBuilder class.
     * 
     * Improvements : we could compute the length of the compressed string to
     * avoid to build an useless string. However, the runtime complexity would
     * still be O(n)
     * 
     * @param str the String to compress
     * @return the compressed string or the original string if the compression
     * is not efficient enough
     */
    public static String compress(String str){

        StringBuilder compressed = new StringBuilder();
        int countConsec = 0;

        for(int i=0; i< str.length(); i++){
            countConsec++;

            if(i >= str.length()-1 || str.charAt(i) != str.charAt(i+1)){
                compressed.append(str.charAt(i));
                compressed.append(countConsec);
                countConsec = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}