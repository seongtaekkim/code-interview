import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
 * 예) hello => olleh
 */
class Array2Test {
    private String data;

    @BeforeEach
    void data() {
        data = "hello";
    }

    /**
     * 시간 O(n)
     * 공간 O(n)
     */
    @Test
    void solution1() {
        char[] result = new char[data.length()];
        for (int i = data.length() ; i > 0 ; i--) {
            result[data.length() - i] = data.charAt(i - 1);
        }
        System.out.println(new String(result));
        System.out.println(String.valueOf(result));
        System.out.println();
    }

    /**
     * 시간 O(n)
     * 공간 O(1)
     * - tochararray 비용 제외함
     */
    @Test
    void solution2() {
        char[] charArray = data.toCharArray();
        for (int i = 0 ; i < charArray.length / 2 ; i++) {
            char tmp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = tmp;
        }
        System.out.println(new String(charArray));
    }

}