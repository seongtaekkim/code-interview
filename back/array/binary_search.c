#include <stdio.h>

int	arr_length(int *arr)
{
	int	length = 0;
	while (arr[length] != '\0')
		length++;
	return (length);
}

int	binary_search(int *arr, int target)
{
	int	pivot = 0;
	int	right;
	int	left = 0;
	right = arr_length(arr) -1;
	while (right >= left)
	{
		pivot = (left+right) / 2;
		if (arr[pivot] == target)
			return (pivot);
		else
		{
			if (arr[pivot] > target)
				right = pivot - 1;
			else
				left = pivot + 1;
		}
	}
	return (-1);
}

int	main(void)
{
	int	arr[7] = {1,2,3,4,5,6};
	int	arr2[6] = {1,2,3,4,5};
	printf("1th : %d\n",binary_search(arr,0));
	printf("2th : %d\n",binary_search(arr2,5));
	return (0);
}

