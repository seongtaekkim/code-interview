package sectioin1;

import java.util.Hashtable;

public class Hash {

    public static void main(String[] args) {
        System.out.println(twosum(new int[]{13, 7, 5, 1, 3, 2}, 10));;
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
}
