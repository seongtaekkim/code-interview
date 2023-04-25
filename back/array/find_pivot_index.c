#include <stdio.h>

/*
 * 1. 배열의 모든 수 합계 구함.
 * 2. 피봇(index)을 진행시켜서 왼쪽값과 오른쪽 값이 같을 때 리턴 O(n) 
 */
int	find_pivot_index(int *arr, int length)
{
	int	sum;
	int	index;
	int	lsum;

	index = 0;
	sum = 0;
	lsum = 0;
	while (index < length)
		sum += arr[index++];
	index = 0;
	while (index < length)
	{
		sum -= arr[index];
		if (index > 0)
			lsum += arr[index - 1];
		if (sum == lsum)
			return (index);
		index++;
	}
	return (-1);
}

int	main(void)
{
	int	arr[] = {1,8,2,9,2,3,6};
	printf("pivot is %d\n",find_pivot_index(arr, 7));
	return (0);
}
