
package sectioin1;

public class Sorting {

    public static void main(String[] args) {

        //arrPrint(bubbleSorting(new int[]{9,3,5,7,1}));

       /*arrPrint(bubbleSorting(new String[][]{{"7","a"}
                                                ,{"5","a"}
                                                ,{"5","b"}
                                                ,{"7","b"}
                                                ,{"3","c"}}));*/


        //arrPrint(selectionSorting(new int[]{9,3,5,7,1}));
        //arrPrint(mergeSort(new int[]{7,3,1,5,6,4,2}));
        /*int[] arr = quickSelect(new int[]{3, 5, 9, 1, 2, 4, 7}, 2);
        arrPrint(arr);
        System.out.println(arr[arr.length - 1 -1]);*/
        //System.out.println(quickSelect(new int[]{3, 5, 9, 1, 2, 4, 7}, 2));

        int[] quickArr = new int[]{3, 5, 9, 1, 2, 4, 7};
        quickSort(quickArr,0, quickArr.length-1);
        arrPrint(quickArr);
    }


/**
     * bubbleSorting - 숫자정렬
     * O(n^2)
     * stable한 정렬방법이다.
     * stable정렬 - 같은 숫자에 대한 순서가 변경되지 않는다.
     *
     * @return 배열 인덱스
     */

    public static int[] bubbleSorting(int[] arr) {
        // [9,3,5,7,1]

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = min;
                    arr[i] = tmp;
                    min = tmp;
                }
            }
        }
        return arr;
    }


/**
     * bubbleSorting = [숫자][문자] 정렬 (stable-test)
     * O(n^2)
     * stable한 정렬방법이다.
     * stable정렬 - 같은 숫자에 대한 순서가 변경되지 않는다.
     *
     * @return 배열 인덱스
     */

    public static String[][] bubbleSorting(String[][] arr) {
        // (7,'a'),(5,'a'),(5,'b'),(7,'b'),(3,'c')]
        int sortTargetIdx = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            String min = arr[i][sortTargetIdx];
            for (int j = i + 1; j < arr.length; j++) {
                try {

                    if(Integer.parseInt(min) > Integer.parseInt(arr[j][sortTargetIdx])) {
                        String tmp = arr[j][sortTargetIdx];
                        arr[j][sortTargetIdx] = min;
                        arr[i][sortTargetIdx] = tmp;
                        min = tmp;
                    }

                } catch (NumberFormatException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }
        return arr;
    }


/**
     * insertion sort
     * O(n^2)
     * stable 한 정렬이다.
     *
     * @param arr
     * @return
     */

    public static int[] insertionSorting(int[] arr) {
        //[9 3 5 7 1]

        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];
            for (int j = 0; j < i; j++) {
                if (data < arr[j]) {
                    int tmp = arr[j];

                    for (int k = i - 1; k > j; k--) {
                        arr[k + 1] = arr[k];
                    }
                    arr[j] = data;
                    data = tmp;
                    break;
                }
            }
        }

        return arr;
    }


/**
     * selection sort
     * O(n^2)
     * not stable
     * 배열순서대로 입력될 데이터를 선택하는 정렬이다.
     *
     * @param arr
     * @return
     */

    public static int[] selectionSorting(int[] arr) {
        //[9 3 5 7 1]
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }
            arr[idx] = arr[i];
            arr[i] = min;
        }
        return arr;
    }


/**
     * merge sort
     * O(nlogn)
     * 배열을 최소단위로 쪼갠 후, 오름차순으로 다시 합친다.
     *
     * @param arr
     * @return
     */

    public static int[] mergeSort(int[] arr) {

        if (arr.length == 1)
            return arr;

        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = 0; i < arr.length - mid; i++) {
            System.out.println(i);
            rightArr[i] = arr[mid + i];
        }
        int[] sortedLeftArr = mergeSort(leftArr);
        int[] sortedRightArr = mergeSort(rightArr);
        // 다음로직

        return arr;
    }


/**
     * quick select
     * n번째로 큰 숫자를 찾는 자료구조
     * worst : O(n^2), best avr : O(n)
     * 랜덤한 위치에 피봇을 설정한뒤 파티셔닝하여 검색한다.
     *
     * @param arr
     * @return
     */

    public static int[] quickSelect(int[] arr, int k) {
        // 1. 피봇 랜덤선택
        // 2. 피봇과 마지막 항목 swap
        // 3.
        System.out.println("================================================ quick start");
        int pivot = (int) (Math.random() * (arr.length - 1));

        int leftIdx = 0;
        int rightIdx = arr.length - 2;
        int kIndex = k-1;
        int tmpIdx = -1;

        arrPrint(arr);
        System.out.println("pivot : " + pivot);

        arr = swap(arr, pivot, arr.length-1);
        pivot = arr.length-1;

        arrPrint(arr);

        System.out.println("while start ====================");
        while (rightIdx > leftIdx) {
            System.out.println("left :" + leftIdx + " right : " + rightIdx+ " pivot : " + pivot);
            while(arr[leftIdx] < arr[pivot] || arr[rightIdx] > arr[pivot]) {
                if (arr[leftIdx] < arr[pivot]) {
                    leftIdx++;
                }
                if (arr[rightIdx] > arr[pivot]) {
                    rightIdx--;
                }
                if(rightIdx == 0 ) {
                    break;
                }
                if(leftIdx == arr.length-1) {
                    break;
                }
            }

            if(rightIdx > leftIdx)
                arr = swap(arr, leftIdx, rightIdx);
            arrPrint(arr);
        }
        System.out.println("while end ========================");

        arr = swap(arr, leftIdx, pivot);
        tmpIdx = pivot;
        pivot = leftIdx;
        leftIdx = tmpIdx;

        arrPrint(arr);


        System.out.println("=====================================");

        if(arr.length-1 == pivot) {
            arr = quickSelect(arr, k);
        }
        if((arr.length - (pivot+1)) == kIndex) {
            return arr;
        } else if((arr.length - (pivot+1)) > kIndex) {
            arr = makeArr(arr,pivot,"r");
            arr = quickSelect(arr, k);
        } else {
            arr = makeArr(arr,pivot,"l");
            arr = quickSelect(arr, k);
        }
        /*if (kIndex > pivot) {
            arr = makeArr(arr,pivot,"r");
            arr = quickSelect(arr, k);
        } else if(kIndex < pivot) {
            arr = makeArr(arr,pivot,"l");
            arr = quickSelect(arr, k);
        } else {
            return arr;
        }*/
        System.out.println("================================================ quickSelect end " + arr.length + " pivot : " + pivot);
        return arr;
    }


    /**
     * quick sort
     * worst : O(n^2), best avr : O(n)
     *
     * @param arr
     * @return
     */

    public static int[] quickSort(int[] arr, int startIndex, int endIndex) {

        System.out.println("================================================ quick start");

        if(endIndex-startIndex <1 )
            return arr;

        int pivot = (int) (startIndex + Math.random() * (endIndex -startIndex));

        int leftIdx = startIndex;
        int rightIdx = endIndex-1;
        int tmpIdx = -1;

        arrPrint(arr);
        System.out.println("pivot : " + pivot);

        swap(arr, pivot, endIndex);
        pivot = endIndex;

        arrPrint(arr);

        System.out.println("while start ====================");
        while (rightIdx >= leftIdx) {
            if (arr[leftIdx] < arr[pivot]) {
                leftIdx++;
            }
            if (arr[rightIdx] > arr[pivot]) {
                rightIdx--;
            }
            if(rightIdx==0) {
                break;
            }
            if(rightIdx < leftIdx) {
                break;
            }
            if(arr[leftIdx] > arr[pivot] && arr[rightIdx] < arr[pivot]) {
                swap(arr,leftIdx,rightIdx);
                arrPrint(arr);
            }
        }
        System.out.println("while end ======================== left : " + leftIdx + " right : " + rightIdx);

        arr = swap(arr, leftIdx, pivot);
        arrPrint(arr);

        quickSort(arr,startIndex,leftIdx-1); // left sort
        quickSort(arr,leftIdx+1,endIndex); // right sort

        System.out.println("================================================ quicksort end " + arr.length + " pivot : " + pivot);
        return arr;
    }

    private static int[] makeArr(int[] arr, int pivot, String direction) {
        int length = -1;
        int[] ret = null;
        if("r".equals(direction)) {
            length = arr.length - (pivot +1);
            ret = new int [length];
            for(int i=pivot+1 ;i<arr.length; i++) {
                ret[i-(pivot+1)] = arr[i];
            }


        } else {
            length = pivot ;
            ret = new int [length];
            for(int i=0 ;i<pivot ; i++) {
                ret[i] = arr[i];
            }
        }
        System.out.print("makeArr : ");
        arrPrint(ret);
        return ret;
    }

    public static int[] swap(int[] arr, int idx1, int idx2) {

        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
        return arr;
    }


    /**
     * arrPrint
     *
     * @param arr
     */
    public static void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * arrPrint
     *
     * @param arr
     */
    public static void arrPrint(StringAlgo[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.print(" ");
        }
    }
}
























