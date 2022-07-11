#include <stdio.h>

void	swap(int *a, int *b)
{
	int	tmp;
	tmp = *a;
	*a = *b;
	*b = tmp;
}
void	show(int *arr, int size)
{
	int	index;

	index = 0;
	while (index < size)
		printf("%d ", arr[index++]);
	printf("\n");
}

void	quick_sort(int *arr, int lidx, int ridx)
{
	int	pivot;
	int	left;
	int	right;
	int	size;

	size = (ridx - lidx + 1);
	if (size <= 1)
		return ;
	if (size == 2)
	{
		if (arr[lidx] > arr[ridx])
			swap(&arr[lidx], &arr[ridx]);
		return ;
	}
	pivot = (lidx + ridx) / 2;
	swap(&arr[pivot], &arr[ridx]);	
	right = ridx - 1;
	left = lidx;
	while (left <= right && right > 0 && left < ridx)
	{
		while (arr[ridx] >= arr[left] && left < ridx)
			left++;
		while (arr[ridx] <= arr[right] && right > 0)
			right--;
		if (left < right)
			swap(&arr[left], &arr[right]);
	}
	swap(&arr[ridx], &arr[left]);
	show(arr, 6);
	quick_sort(arr, lidx, left - 1);
	quick_sort(arr, left + 1, ridx);
}

int	main(void)
{
	int	arr[] = {7,3,4,2,5,1};
	quick_sort(arr,0,5);
	show(arr, 6);
}
