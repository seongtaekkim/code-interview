## 배열퀴즈

숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는 지 확인하는 함수를 작성해라.
중복된 숫자가 있다면 true, 없다면 false

ex) 1 2 3 4 5 6 => false
    1 1 2 2 3 1 => true


### solution1
- 순회를 두번하면서 모두 비교.
~~~
private boolean solution1(int[] numbers) {
    for (int i = 0 ; i < numbers.length ; ++i) {
        for (int j = i + 1 ; j < numbers.length ; ++j) {
            if (numbers[i] == numbers[j])
                return (true);
        }
    }
    return (false);
}
~~~
- 시간 O(n2), 공간 O(1)



### solution2
- 정렬 이후에 순회
~~~
private boolean solution2(int[] numbers) {
    Arrays.sort(numbers);
    for (int i = 0 ; i < numbers.length -1 ; ++i) {
        if (numbers[i] == numbers[i+1]) {
            return (true);
        }
    }
    return (false);
}
~~~
- 시간 O(nlogn), 공간 O(logn)

### solution3
- set 을 이용하여 순회
~~~
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
~~~
- 시간 O(n), 공간 O(n)