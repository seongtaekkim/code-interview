package _2023122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 7568 덩치
 * https://www.acmicpc.net/problem/7568
 * 6
 * 55 181
 * 54 181
 * 56 181
 * 55 179
 * 56 182
 * 54 190
 *
 * 단순한 누적순위가 아니라
 * 나보다 덩치카 큰 사람에 대한 누적순위 이다.
 */
public class _7568 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            List<Person> list = new ArrayList<>();
            for (int i=0 ; i<N ; i++) {
                String[] line = br.readLine().split(" ");
                list.add(new Person(Integer.parseInt(line[0]), Integer.parseInt(line[1]), i));
            }

            Collections.sort(list);
            list.get(0).setRank(1);
            int rank;
            for (int i=1; i<list.size() ; i++) {
                Person person = list.get(i);
                rank = 1;
                for (int j=0; j<i ; j++) {
                    Person tmp = list.get(j);
                    if (tmp.getWeight() > person.getWeight() && tmp.getHeight() > person.getHeight()) rank++;
                }
                person.setRank(rank);
            }
            list.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if (o1.getIndex() > o2.getIndex())
                        return 1;
                    else if (o1.getIndex() == o2.getIndex())
                        return 0;
                    return -1;
                }
            });
            for (Person p : list)
                System.out.print(p.getRank() + " ");

        } catch (IOException e) {
            // TODO
        }
    }
}

class Person implements Comparable<Person> {
    private int weight;
    private int height;
    private int rank;
    private int index;

    public int getIndex() {
        return index;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public Person(int weight, int height, int index) {
        this.weight = weight;
        this.height = height;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Person{" +
                "weight=" + weight +
                ", height=" + height +
                ", rank=" + rank +
                ", index=" + index +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (o.weight > this.weight) {
            return 1;
        } else if (o.weight == this.weight) {
            if (o.height > this.height)
                return 0;
            return -1;
        } else {
            return -1;
        }
    }

}