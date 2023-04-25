package _00_intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindUniqueNumber {
    public static void main(String[] args) {
        FindUniqueNumber findUniqueNumber = new FindUniqueNumber();
        System.out.println(findUniqueNumber.solution1(new int[]{1,2,2,1,3}) == 1);
        System.out.println(findUniqueNumber.solution2(new int[]{1,2,2,1}) == 1);
        System.out.println(findUniqueNumber.solution3(new int[]{3,4,3,1,4}) == 1);

    }

    private int solution1(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            if (list.contains(num)) {
                list.remove((Integer)num);
            } else {
                list.add(num);
            }
        }
        return (list.size());
    }

    private int solution2(int[] numbers) {
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int num : numbers) {
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
        }

        for (int num : numbers) {
            if (numberMap.get(num) == 1) {
                return (1);
            }
        }
        return (0);
    }

    private int solution3(int[] numbers) {
        int uniqueNum = 0;
        for (int num : numbers) {
            uniqueNum ^= num;
        }
        return (uniqueNum);
    }
}