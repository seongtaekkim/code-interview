#include <stdio.h>

/*
 * 1. count array 생성
 * 2. count array를 참고하여 결과배열 재구성
 * 3. O(n)
 */
void	dutch_flag_problem(int *arr, int length)
{
	int	cnt[4] = {0,};
	int	index = 1;

	index = 0;
	while (index < length)
	{
		cnt[arr[index]]++;
		index++;
	}
	index = 0;
	while (cnt[0] > 0)
	{
		arr[index++] = 0;
		cnt[0]--;
	}
	while (cnt[1] > 0)
	{
		arr[index++] = 1;
		cnt[1]--;
	}
	while (cnt[2] > 0)
	{
		arr[index++] = 2;
		cnt[2]--;
	}
}

void	swap(int *a, int *b)
{
	int	tmp;
	tmp = *a;
	*a = *b;
	*b = tmp;
}

void	show(int *arr, int length)
{
	int	index;

	index = 0;
	while (index < length)
	{
		printf("%d ",arr[index++]);
	}
	printf("\n");
}

/*
 * in-place swap로 풀이
 * 1. 0과 2를 partition 하는 pivot 2개를 만든다.
 * 2. index가 증가하며 0,1,2를 파티션에 맞게 swap한다.
 * 3. O(n)
 */
void	dutch_flag_problem2(int *arr, int length)
{
	int	pivot1 = 0, pivot2 = length - 1 , index = 0;

	while (index < pivot2)
	{
		if (arr[index] == 0)
		{
			swap(&arr[index], &arr[pivot1]);
			pivot1++;
			index++;
		}
		else if (arr[index] == 2)
		{
			swap(&arr[index], &arr[pivot2]);
			pivot2--;
		}
		else
			index++;
	}
}

/*
 * 이미 알고있는 숫자를 오름차순 정렬
 */
int	main(void)
{
	int	arr[] = {1,0,2,2,0,1,2,1,0};
	dutch_flag_problem2(arr, 9);
	show(arr, 9);
	return (0);
}
