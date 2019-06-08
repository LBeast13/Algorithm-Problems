import java.util.Hashtable;
import java.util.Set;

public class Problem4 {

    public static void main(String [] args){

        char[] str = "Tact Co".toCharArray();

        if(isPalindromePermut(str))
            System.out.println("It is a palindrome permutation");
        else
            System.out.println("It is NOT a palindrome permutation");
    }


    public static boolean isPalindromePermut(char[] str){

        Hashtable<Character, Integer> countMap = new Hashtable<>();
        int oddCount = 0;

        for(char c: str){
            if(c != ' '){
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