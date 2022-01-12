package sectioin1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Hash {

    public static void main(String[] args) {
       // System.out.println(twosum(new int[]{13, 7, 5, 1, 3, 2}, 10));;
        //System.out.println(findFirstUniqueCharacter("nocodeprogram"));

        System.out.println(somorphicStrings("aaaccd","xxweea"));
    }

    /**
     * find the index where the sum for two numbers is 10
     * use : hash table
     * @param arr
     */
    public static String twosum(int[] arr, int sum) {

        Hashtable<Integer,Integer> hashtable = new Hashtable();
        for(int i= 0 ;i<arr.length ; i++){
            hashtable.put(arr[i],i);
        }

        for(int i= 0 ;i<arr.length ; i++){
            int ret = sum - arr[i];
            Object value =  hashtable.get(ret);
            if(value == null) {
            } else {
               return "index : " + i + " " + (int) value;
            }
        }
        return null;

    }

    /**
     * find first unique character
     *
     */
    public static int findFirstUniqueCharacter(String data) {
        char[] arr = data.toCharArray();

        Map<Character,Integer> hashTable = new Hashtable<>();
        for(int i= 0;i<arr.length ; i++) {
            if (hashTable.get(arr[i]) == null) {
                hashTable.put(arr[i],1);
            } else {
                int intVal = hashTable.get(arr[i]);
                hashTable.replace(arr[i],++intVal);
            }
        }
/*
        Iterator<Map.Entry<Character, Integer>> entries =  hashTable.entrySet().iterator();
        while(entries.hasNext()) {
            Map.Entry<Character, Integer> entry = entries.next();
            System.out.println("key : " + entry.getKey() + ", value : "+ entry.getValue());
        }*/

        for(int i=0 ;i <arr.length ; i++) {
            if(hashTable.get(arr[i]) == 1 ) {
                return i;
            }
        }
        return -1;
    }

    /**
     * somorpic Strings
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean somorphicStrings(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Map<Character, Character> hashTable = new Hashtable<>();
        for(int i =0; i<char1.length ; i++) {
            if(hashTable.get(char1[i]) == null) {
                hashTable.put(char1[i], char2[i]);
            } else {
                if(hashTable.get(char1[i]) != char2[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}




















































