#include <stdio.h>

/*
 * 양쪽 숫자보다 큰 경우 인덱스를 리턴 (2개이상일 경우 아무거나)
 * 방법1 : 배열을 순회하면서 찾는다. O(n)
 * 방법2 : binary search 하며 찾는다 O(logn) -> 이거로 풀었음
 */
int	find_peak_element(int *arr, int size)
{
	int	left;
	int	right;
	int	pivot;
	
	left = 0;
	right = size - 1;
	while (left < right)
	{
		pivot = (left + right) / 2;
		if (arr[pivot] < arr[pivot + 1])
			left = pivot + 1;
		else
			right = pivot;
	}
	return left;
}

int	main(void)
{
	int	arr[] = {1, 3, 2, 4, 5, 7, 6};
	printf("%d \n", find_peak_element(arr, 7));
}
