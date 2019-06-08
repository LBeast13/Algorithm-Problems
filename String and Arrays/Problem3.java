/**
 * PROBLEM 3 : URLify 
 * 
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end
 * to hold the additional characters, and that you are given the "true"
 * length of the string.
 * 
 * (Note : if implementing in Java, use a character array)
 * 
 * EXAMPLE :
 * Input : "Mr John Smith"
 * Output : "Mr%20John%Smith"
 */
public class Problem3{

    public static void main(String[] args){

        char[] str = "Mr John Smith       ".toCharArray();
        int trueSize = getTrueSize(str);

        System.out.println(replaceSpaces(str,trueSize));
    }

    /**
     * SOLUTION 
     *  
     * Runtime Complexity : O(n)
     * 
     * The idea is to iterate the char array from the end in order to use
     * the blank spaces in the end as a buffer.
     * We first count the spaces within the "true" string to compute the
     * number of extra characters that will be added and set the end of the 
     * array.
     * Then we edit the string in the second iteration : when we see a space, 
     * we replace it with %20, if there is no space, we copy the original 
     * character.
     * 
     * @param str the char array to be formatted 
     * @param trueSize the "true" size of the string
     * @return the formatted string
     */
    public static char[] replaceSpaces(char[] str, int trueSize){
        
        int spaceCount = 0;

        // Count the spaces in the string
        for(int i=0; i<trueSize; i++){
            if(str[i] == ' ')
                spaceCount++;
        }

        // Set the length needed for the new formated string
        int idx = trueSize + 2*spaceCount;
        if(trueSize < str.length) 
            str[trueSize] = '\0';

        // Edit the string
        for(int i=trueSize-1; i>=0; i--){
            if(str[i] == ' '){
                str[idx - 1] = '0';
                str[idx - 2] = '2';
                str[idx - 3] = '%';
                idx = idx-3;
            } else{
                str[idx - 1] = str[i];
                idx--;
            }
        }

        return str;
    }


    /**
     * A method to simplify the input but it is not required for solving
     * the problem.
     * 
     * @param str the char array for the input
     * @return the "true" length of the string
     */
    public static int getTrueSize(char[] str){
        int size = 0;
        int consecSpaceCount = 0;
        int idx = 0;

        while(consecSpaceCount != 2){
            if(str[idx] == ' '){
                consecSpaceCount++;
            } else 
                consecSpaceCount = 0;

            idx++;
            size++;
        }

        return size-2;
    }
}