package _202311;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 27866 문자와 문자열
 * https://www.acmicpc.net/problem/27866
 */
public class _27866 {
    public static void main(String[] args) {

        String str;
        String index;
        try (InputStream is = System.in;
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)) {
            str = br.readLine();
            index = br.readLine();
            System.out.print(str.charAt(Integer.parseInt(index) - 1));
        }  catch (NumberFormatException e) {

        }  catch (Exception e) {
        }
    }
}
