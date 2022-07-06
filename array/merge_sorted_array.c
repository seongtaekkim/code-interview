#include <stdio.h>

/*
 * 배열 두개를 하나로 합치는데, 큰 배열쪽으로 오름차순하여 합쳐라. (새로운 메모리 x)
 * time : O(n+m), space : O(1)
 */
void	merge_sorted_array(int *arr1, int size1, int *arr2, int size2)
{
	int	pivot1;
	int	pivot2;
	int	insertIdx;

	insertIdx = size1 - 1;
	pivot1 = size1 - size2 - 1;
	pivot2 = size2 - 1;
	while (size1 > 0)
	{
		if (arr1[pivot1] > arr2[pivot2])
			arr1[insertIdx] = arr1[pivot1--];
		else
			arr1[insertIdx] = arr2[pivot2--];
		insertIdx--;
		size1--;
	}
}

int	main(void)
{
	int arr1[] = {1,3,5,0,0,0};
	int arr2[] = {2,4,8};
	merge_sorted_array(arr1, 6, arr2, 3);
	
	int	index = 0;
	while (index < 6)
		printf("%d ",arr1[index++]);
}
