package _01_arrays;


/**
 * TODO 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
 *  예) hello => olleh
 *  예) happy new year => reay wen yppah
 */
public class ReverseStringSolution {

    public static void main(String[] args) {
        ReverseStringSolution reverseString = new ReverseStringSolution();
        System.out.println(reverseString.solution1("Hello".toCharArray()));
        System.out.println(reverseString.solution2("happy new year".toCharArray()));
    }

    private char[] solution1(char[] message) {
        char[] reversedMessage = new char[message.length];

        for (int i = message.length - 1 ; i >= 0 ; i--) {
            reversedMessage[message.length - 1 - i] = message[i];
        }
        return reversedMessage;
    }

    // h e l l o
    // he l lo
    // 4 - 0 = 4
    // 4 - 1 = 3
    private char[] solution2(char[] message) {
        for (int i = 0 ; i < message.length/2 ; i++) {
            char temp = message[i];
            message[i] = message[message.length - 1 - i];
            message[message.length - 1 - i] = temp;
        }
        return message;
    }

    /**
     * stringBuilder 를 적용해서 풀어보자.
     * @param message
     * @return
     */
    private char[] solution3(char[] message) {
        return null;
    }

    }
