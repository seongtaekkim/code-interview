package _2023113;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 10814 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 */
public class _21_10814 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());

            User[] users = new User[num];
            for (int i=0 ; i<num ; i++) {
                String[] line = br.readLine().split(" ");
                users[i] = new User(Integer.parseInt(line[0]), line[1]);
            }

            Arrays.sort(users, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o1.getAge() - o2.getAge();
                }
            });
            for (User p : users)
                bw.write(p.toString() + "\n");
            bw.flush();
        }
    }
}

class User {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.age + " " + this.name;
    }
}
