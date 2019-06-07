import java.util.Hashtable;
import java.util.Set;;

/**
 * PROBLEM 2 : Given two strings, write a method to decide if one is a permutation of the other
 */
public class Problem2{

    public static void main(String[] args) {

        String str1 = "aafbcg";
        String str2 = "bgcaaf";

        if(isPermut(str1, str2))
            System.out.println("They are permutations");
        else
            System.out.println("They are NOT permutations");
    }

    public static boolean isPermut(String str1, String str2){

        if(str1.length() != str2.length())
            return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Hashtable <String, Integer> countMap = new Hashtable<>();

        int prevCount = 0;
        String curr1 = "";
        String curr2 = "";

        for(int i=0; i<chars1.length; i++){
            curr1 = Character.toString(chars1[i]);
            curr2 = Character.toString(chars2[i]);

            if(countMap.containsKey(curr1)){
                prevCount = countMap.get(curr1);
                countMap.put(curr1, prevCount + 1);
            } else {
                countMap.put(curr1, 1);
            }

            if(countMap.containsKey(curr2)){
                prevCount = countMap.get(curr2);
                countMap.put(curr2, prevCount - 1);
            } else {
                countMap.put(curr2, -1);
            }
        }

        Set <String> keys = countMap.keySet(); 
        for(String key : keys){
            if(countMap.get(key) != 0)
                return false;
        }

        return true;
    }
}