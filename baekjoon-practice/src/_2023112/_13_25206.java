package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 25206 너의 평점은
 * https://www.acmicpc.net/problem/25206
 */
public class _13_25206 {
    public static void main(String[] args) {

        float credit = 0.0F;
        float score = 0.0F;
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String read;
            while((read = br.readLine()) != null) {
                if (read == null) break ;
                String[] info = read.split(" ");
                if ("P".equals(info[2]))
                    continue;
                float curCredit = Float.parseFloat(info[1]);
                String str = info[2];

                if ("A+".equals(str)) score += (4.5F * curCredit);
                else if ("A0".equals(str)) score += (4.0F * curCredit);
                else if ("B+".equals(str)) score += (3.5F * curCredit);
                else if ("B0".equals(str)) score += (3.0F * curCredit);
                else if ("C+".equals(str)) score += (2.5F * curCredit);
                else if ("C0".equals(str)) score += (2.0F * curCredit);
                else if ("D+".equals(str)) score += (1.5F * curCredit);
                else if ("D0".equals(str)) score += (1.0F * curCredit);
                else if ("F".equals(str)) score += 0.0F;

                credit += curCredit;
            }

            System.out.printf("%.6f", score / credit);
        } catch (IOException e) {
            // TODO
        }
    }
}
