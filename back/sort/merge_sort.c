#include <stdio.h>

#include <stdlib.h>

void	show(int *arr, int size)
{
	int index;

	index = 0;
	while (index < size)
		printf("%d ",arr[index++]);
	printf("\n");
}

void	swap(int *a, int *b)
{
	int	tmp;
	tmp = *a;
	*a = *b;
	*b= tmp;
}

void	merge_sort(int *arr, int size, int left, int right)
{
	int	pivot;
	if (size <= 1)
		return ;
	pivot = (right + left) / 2 + (right + left) % 2;
	int size_l = pivot - left;
	int size_r = right - pivot + 1;
	merge_sort(arr, size_l, left, pivot - 1);
	merge_sort(arr, size_r, pivot, right);
	printf("left : %d, right : %d\n", left, right);

	int id_l = left;
	int id_r = pivot;
	int index = 0;
	while (index < size_l + size_r)
	{
		//rintf("idl : %d, sizel : %d, idr : %d, sizer : %d\n",id_l,size_l,id_r,size_r);
		while (arr[id_r] > arr[id_l])
		{
			id_l++;
			index++;
		}
		while (arr[id_l] > arr[id_r])
		{
			swap(&arr[id_l], &arr[id_r]);
			id_l++;
			index++;
		}
		while (id_l == size_l && id_r < size_r)
		{
			if (index == id_r)
				id_r++;
			while(arr[index] > arr[id_r])
			{
				swap(&arr[index], &arr[id_r]);
				index++;
				id_r++;
			}
		}

			
	}
}

int	main(void)
{
	int	arr[] = {7,3,1,5,6,4,2};
	merge_sort(arr,7,0,6);
	for(int i =0 ; i<7 ; i++)
		printf("%d ",arr[i]);
	}
