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
	int *ret = (int *)malloc(sizeof(int) * (size_l + size_r));
	while ( id_l < size_l && id_r < size_r)
	{
		//rintf("idl : %d, sizel : %d, idr : %d, sizer : %d\n",id_l,size_l,id_r,size_r);
		show(ret, size_l+size_r);
		if (id_l == (size_l - 1))
		{
			ret[index] = arr[id_r++];
			index++;
			continue;
		}
		if (id_r == (size_r - 1))
		{
			ret[index] = arr[id_l++];
			index++;
			continue;
		}
		if (arr[id_l] > arr[id_r])
			ret[index] = arr[id_r++];
		else
			ret[index] = arr[id_l++];
		index++;
	}
	index = 0;
	while (index < (size_l + size_r))
	{
		arr[index] = ret[index];
		index++;
	}
}

int	main(void)
{
	int	arr[] = {7,3,1,5,6,4,2};
	merge_sort(arr,7,0,6);
	for(int i =0 ; i<7 ; i++)
		printf("%d ",arr[i]);
	}
