
package datastructure;

public class Array {

    public static void main(StringAlgo[] args) {

        // System.out.println(binarySearch());
        //int[] ret = moveZeros(new int[]{0,0,9,5,0,0,7,6,3,0,0});

        //System.out.println(findPivotIndex(new int[]{1,2,3,1,2}));
        //arrPrint(mergeSortedArray(new int[]{5,6,7,0,0,0}, 3, new int[]{1,2,3}, 3));
        System.out.println(findPeakElement(new int[]{1, 3, 2, 4, 5, 7, 6}));
    }


/**
     * 정렬된 배열에 특정값 위치를 검색하는 함수.
     * O(logn)
     *
     * @return 배열 인덱스
     */

    public static int binarySearch() {

        Integer[] arr = new Integer[]{1, 3, 5, 6, 7, 15, 20};

        int left = 0;
        int right = arr.length - 1;
        int pivot = 0;
        int searchVal = 9;

        while (left <= right) {

            pivot = (left + right) / 2;
            if (arr[pivot] == searchVal) {
                return pivot;
            } else if (arr[pivot] < searchVal) {
                left = pivot + 1;
            } else if (arr[pivot] > searchVal) {
                right = pivot - 1;
            }
        }

        return -1;
    }


/**
     * 배열안의 zero를 모두 뒤쪽으로 이동시키는 문제
     * 조건 - zero 이외의 숫자 순서는 미변경 되어야 한다.
     *
     * @param arr
     * @return
     */

    public static int[] moveZeros(int[] arr) {
        //{0,5,0,7,6,3}

        int zeroIdx = 0;

        for (int idx = 0; idx < arr.length; idx++) {
            arrPrint(arr);

            if (arr[idx] != 0) {
                // if(arr[zeroIdx] == 0) {
                arr[zeroIdx] = arr[idx];
                arr[idx] = 0;
                zeroIdx++;
                //zeroIdx = idx;
                // }

            } else {
                //if(arr[zeroIdx] != 0) {
                //    zeroIdx = idx;
                //}
                //continue;
            }
        }


        return arr;
    }

    public static void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


/**
     * 왼쪽 배열합과 오른쪽배열 합이같은 피봇을 구하라.
     * - 해당문제는 슬라이딩 개념을 생각해서 풀어야 함.
     * - 해당 인덱스가 없으면 -1을 리턴.
     *
     * @param arr
     * @return
     */

    public static int findPivotIndex(int[] arr) {
        //1 2 3 1 2
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }
        int pastPivotNum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum = leftSum + pastPivotNum;
            rightSum = rightSum - arr[i];

            System.out.println("left : " + leftSum + "  right : " + rightSum);
            if (leftSum == rightSum) {
                return i;
            }
            pastPivotNum = arr[i];
        }

        return -1;
    }



/**
     * 0,1,2 숫자가 중복으로 배열에 존재할때, 같은숫자끼리 모아주는 기능
     * - 0,1,2 순서대로 정렬해준다.
     * 1안) 일반적인 sort 정렬로 풀면 O(nlogn) 으로 풀수 있음
     * 2안)
     *
     * @param arr
     * @return
     */

    public static int[] sortColors(int arr[]) {


        return null;
    }


/**
     * 정렬된 배열두개와 각각의 크기가 주어질 때, 두개의 배열을 하나로 합치는 문제
     * 조건1-두 배열중 하나는, 합쳤을 때의 크기만큼 늘어나 있는 상태.
     *
     * @param num1
     * @param n
     * @param num2
     * @param m
     * @return
     */

    public static int[] mergeSortedArray(int[] num1, int n, int[] num2, int m) {

        int num1Idx = n - 1;
        int num2Idx = m - 1;
        int wIdx = num1.length - 1;

        if (num2Idx <= 0) {
            return num1;
        }
        while (num1Idx >= 0 && num2Idx >= 0) {
            if (num1[num1Idx] > num2[num2Idx]) {
                num1[wIdx] = num1[num1Idx];
                wIdx--;
                num1Idx--;
            } else {
                num1[wIdx] = num2[num2Idx];
                wIdx--;
                num2Idx--;
            }
        }
        while (num2Idx >= 0) {
            num1[wIdx] = num2[num2Idx];
            wIdx--;
            num2Idx--;
        }
        return num1;
    }


/**
     * 강의제목 - 코딩 테스트,초급, find peak element
     * 배열 값 중 양쪽 값보다 큰 경우를 peak element 라고 할때, peak element 한개를 찾으시오.
     * solution 1) 모든값을 양옆 값과 비교하여 peak element를 검색한다. - O(n)
     * 2) binary search하여 peark element를 검색한다. - O(logn)
     * - 이차원 그래프를 그려서 아이디어를 얻을 수 있다.
     * 조건 1) 해당 문제는 peak element 한개를 검색하는 문제이다.
     * (모든 peak element를 검색하기 위해선 O(n)이 필요함)
     *
     * @param arr
     * @return
     */

    public static int findPeakElement(int[] arr) {
        // [1,3,2,4,5,7,6]

        int left = 0;
        int right = arr.length - 1;

        if (arr.length < 1) {
            return -1;
        }
        while (left < right) {
            int pivot = (left + right) / 2;
            int num = arr[pivot];
            int nextNum = arr[pivot + 1];

            if (num < nextNum) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        return left;
    }



/**
     * data : [[1,5],[3,7],[10,15],[8,16]]
     * return : [[1,7],[8,16]]
     * 위와 같은 interval 형태의 데이터가 주어졌을 때, 겹치는 범위는 모두 merge하여 보시오.
     * solution 1) interval를 순회하면서 존재하는 merge를 모두 체크하는 방식 - O(n^2)
     * 2) interval을 정렬한 후, 존재하는 merge를 모두 체크하는 방식 - O(nlogn)
     *
     * @param arr
     * @return
     */

    public static int mergeInterval(int[] arr) {
        return -1;
    }

}

























