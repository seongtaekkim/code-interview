package _01_arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortByArray {

    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("keesun");

        SortByArray sortByArray = new SortByArray();
        System.out.println(Arrays.toString(sortByArray.solution(new int[]{2, 4, 1, 5, 6, 9})));
    }

    /**
     * TODO 1부터 100 까지의 숫자 중에 50개의 랜덤한 숫자가 들어있는 배열이 있다.
     *  이 배열을 O(n)의 시간 복잡도로 정렬하라.
     *  시간 O(n), 공간(n)
     * @param numbers
     * @return
     */
    private int[] solution(int[] numbers) {
        boolean arr[] = new boolean[100];
        for (int i = 0 ; i < numbers.length ; ++i) {
            arr[numbers[i]] = true;
        }

        int ret[] = new int[numbers.length];
        int idx = 0;
        for (int i = 0 ; i < arr.length ; ++i) {
            if (arr[i] == true) {
                ret[idx++] = i;
            }
        }

        return ret;
    }

}
