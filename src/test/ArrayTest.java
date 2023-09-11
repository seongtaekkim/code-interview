import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 데이터: integer 배열
 * 목표: 같은 숫자가 있는 지 여부 검색
 * 1. nested for 문으로 모든 숫자를 비교
 * 2. 퀵정렬 정렬 후, for문으로 비교
 * 3. set으로 for문 검사
 *
 */
class ArrayTest {
    private Integer[] intArr;

    @BeforeEach
    void data() {
        intArr = new Integer[] {5,4,3,2,1};
    }
    @Test
    void test() {
        System.out.println(array1());
        System.out.println(array2());
        System.out.println(array3());
    }

    /**
     * 시간 O(n2), 공간 O(1)
     * @return
     */
    private boolean array1() {
        for (int i = 0; i < intArr.length - 1  ; i++) {
            for (int j = i+1 ; j < intArr.length ; j++) {
                 if (intArr[i] == intArr[j])
                     return false;
            }
        }
        return true;
    }

    /**
     * O(nlogn), O(logn)
     */
    private boolean array2() {
        Arrays.sort(intArr);
        for (int i = 0; i < intArr.length - 1  ; i++) {
            if (intArr[i] == intArr[i + 1])
                return false;
        }
        return true;
    }

    /**
     * O(n), O(n)
     */
    private boolean array3() {
        Set<Integer> set = new HashSet<>();

        for(Integer i : intArr) {
            if (set.contains(i)) {
                return false;
            } else {
                set.add(i);
            }
        }
        return true;
    }

}