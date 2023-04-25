package _01_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.solution1(new int[] { 1,2,3,4,1,5}));
        System.out.println(containsDuplicate.solution2(new int[] { 1,2,3,4,1,5}));
        System.out.println(containsDuplicate.solution3(new int[] { 1,2,3,4,1,5}));
    }

    private boolean solution1(int[] numbers) {
        for (int i = 0 ; i < numbers.length ; ++i) {
            for (int j = i + 1 ; j < numbers.length ; ++j) {
                if (numbers[i] == numbers[j])
                    return (true);
            }
        }
        return (false);
    }

    private boolean solution2(int[] numbers) {
        Arrays.sort(numbers); // O(nlogn), O(logn)
        for (int i = 0 ; i < numbers.length -1 ; ++i) {
            if (numbers[i] == numbers[i+1]) {
                return (true);
            }
        }
        return (false);
    }

    private boolean solution3(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num : numbers) {
            if (numberSet.contains(num)) {
                return (true);
            } else {
                numberSet.add(num);
            }
        }
        return (false);
    }
}