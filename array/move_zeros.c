#include <stdio.h>


void	swap(int *a, int *b)
{
	int	tmp;
	tmp = *a;
	*a = *b;
	*b = tmp;
}

void	move_zeros(int *arr, int length)
{
	int	index1; // only 0
	int	index2; // except 0
	
	index1 = 0;
	index2 = 0;
	while (index2 < length)
	{
		if (arr[index2] != 0 && arr[index1] == 0)
			swap(&arr[index1], &arr[index2]);
		if (arr[index1] != 0)
			index1++;
		index2++;
	}
	while (index1 < length)
		arr[index1++] = 0;
}

void	print_arr(int arr[], int length)
{
	int	index;

	index = 0;
	while (index < length)
	{
		printf("%d ",arr[index++]);
	}
	printf("\n");
}

int	main(void)
{
	int arr[7] = {0,5,0,7,6,3};
	print_arr(arr, 6);
	move_zeros(arr, 6);
	print_arr(arr, 6);
	return (0);
}
