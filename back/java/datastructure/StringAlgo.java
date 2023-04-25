package datastructure;

public class StringAlgo {
    public static void main(String[] args) {
        //System.out.println(palindrome(new String[]{"a", "b", "c", "c", "b", "a"}));

        printArr(addString(new int[]{1,9, 9, 9}, new int[]{8,7,9, 2, 3}));

    }


    /**
     * KMP 알고리즘
     * O(n)
     * 비교할 배열에 반복되는 값에 인덱스르 붙여서 비교함
     * 아직 정리가 안됨..
     *
     * @param arr
     * @param subArr
     * @return
     */
    public int[] StringMatchingKMP(int arr[], int subArr[]) {
        return null;
    }

    /**
     * Rolling Hash
     * O(n)
     * hash값을 비교하여 찾아냄.
     * String Hash 를 구하려면 O(n) 이 필요한데, 아래에 대안이 나와있다.
     * sliding window trick을 써야합니다.
     * 이 트릭에는, 윈도우에 새로 알파벳이 들어오기전에 윈도우값의 자리수를 올려서 더함과 동시에, 빠지는 알파벳도 자릿수를 곱해줘서 빼주는 방법.  이경우는 substring의 길이가 길어지면 64bit제한을 넘어서게 되는 단점이 잇습니다.
     * 그럴때는 각 알파벳의 헤시값을 슬라이딩 윈도우가 변할때마다 bit rotation을 해서 전체 XOR을 하는 방법.  그렇게 되면 윈도우에서 빠지는 방법은 그 알파벳의 hash값을 자릿수만큼 rotation씨킨뒤 다시 XOR을 시켜주면 됩니다.
     * ## 할거
     * ## String Hash 구하는 법
     * ## sliding window trick 이해
     *
     * @param arr
     * @param subArr
     * @return
     */
    public int[] StringMatchingRollingHash(int arr[], int subArr[]) {
        return null;
    }


    /**
     * Palindrome
     * 순서대로 읽어도, 거꾸로읽어도 같은지 판별
     * 문자가 같은지를 판별하므로, 타 문자는 배제하고 함 (?)
     *
     * @param arr
     * @return
     */
    public static Boolean palindrome(String[] arr) {

        if (arr.length < 1) {
            return false;
        }
        // a b c c b a
        // a b c b a
        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while (leftIdx < rightIdx) {
            if (arr[leftIdx] == arr[rightIdx]) {
                leftIdx++;
                rightIdx--;
            } else {
                return false;
            }
        }

        return true;
    }


    /**
     * Palindrome 2
     * 주어진 배열에서 최대 1개 문자를 제외했을 때, palindrome이 가능한가 ?
     *
     * @param arr
     * @return
     */
    public Boolean palindrome2(StringAlgo arr[]) {

        if (arr.length < 1) {
            return false;
        }


        return false;
    }

    /**
     * add string
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int[] addString(int[] num1, int[] num2) {


        int carry = 0;
        int bCarry = 0;
        int sum = 0;
        if (num1.length < num2.length) {
            num1 = sizeupArr(num1, num2.length);
        } else if(num1.length > num2.length) {
            num2 = sizeupArr(num2, num1.length);
        }
        int firstIdx = num1.length-1;
        int lastIdx = num2.length-1;

        int[] sumArr = new int[num1.length > num2.length ? num1.length : num2.length];
        int idx = 0;

        while (firstIdx >= 0 || lastIdx >= 0) {
            carry = 0;
            sum = 0;

            sum = (num1[firstIdx] + num2[lastIdx]) % 10 + bCarry;
            carry = (num1[firstIdx] + num2[lastIdx]) / 10;

            if (sum > 10) {
                carry += 1;
                sum = sum % 10;
            }
            sumArr[idx++] = sum;
            bCarry = carry;
            firstIdx--;
            lastIdx--;

        }
        int[] result = null;
        if (carry == 1) {
            result = new int[sumArr.length + 1];
            for (int i = 0; i < sumArr.length; i++) {
                result[i] = sumArr[i];
            }
            result[sumArr.length] = 1;
            result = reverseArr(result);
        } else {
            result = reverseArr(sumArr);
        }
        return result;
    }

    public static int[] sizeupArr(int[] arr, int n) {
        int[] ret = new int[n];
        for(int i=0; i<(n-arr.length) ; i++) {
            ret[i] = 0;
        }
        for(int i=(n-arr.length); i<n ; i++) {
            ret[i] = arr[arr.length-n+i];
        }
        return ret;
    }

    /**
     * reverse arr
     * @param arr
     * @return
     */
    public static int[] reverseArr(int[] arr) {
        int[] ret = new int[arr.length];
        for(int i = 0 ; i<arr.length ; i++) {
            ret[ret.length-1-i] = arr[i];
        }
        return ret;
    }

    /**
     * print int arr
     *
     * @param arr
     */
    public static void printArr(int[] arr) {
        System.out.println("print arr start =============================================");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("print arr end =============================================");
    }
}

