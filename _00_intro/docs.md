## Intro

numbers라는 int형 배열이 있다. 해당 배열에 들어있는 숫자들은 오직 한 숫자를 제외하고는 모두 두번 씩 들어있다.
오직 한 번만 등장하는 숫자를 찾는 코드를 작성해라.

### solution1
- list를 만들고 배열에 있는 숫자를 순회하면서 해당 숫자가 List에 들어있는지 확인한다.
- list에 있으면 remove하고 없으면 insert한다.
- 결과적으로 list에는 유일한 숫자만 있고 해당 숫자를 리턴한다.
~~~
private int solution1(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int num : numbers) {
        if (list.contains(num)) {
            list.remove((Integer)num);
        } else {
            list.add(num);
        }
    }
    return (list.get(0));
}
~~~
- 시간 O(n2), 공간 O(n)


### solution2
- HashMap을 사용해서 배열에 들어있는 숫자를 키, 숫자의 등장 횟수를 값으로 저장한다.
- 숫자의 등장 횟수가 1인 키 값을 찾아 리턴한다.
~~~
private int solution2(int[] numbers) {
    HashMap<Integer, Integer> numberMap = new HashMap<>();
    for (int num : numbers) {
        numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
    }

    for (int num : numbers) {
        if (numberMap.get(num) == 1) {
            return (num);
        }
    }
    return (0);
}
~~~
- 시간 O(n), 공간 O(n)

### solution3
- XOR 활용 (bitwise operate)
- 3^3 => 0
- 3^0 => 3
- 1^2^2^1 => 0
- 3,4,3,1,4 => 1
~~~
private int solution3(int[] numbers) {
    int uniqueNum = 0;
    for (int num : numbers) {
        uniqueNum ^= num;
    }
    return (uniqueNum);
}
~~~
- 시간 O(n), 공간 O(1)