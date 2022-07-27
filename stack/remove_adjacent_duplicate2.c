#include "stack.h"


// a b b c b b c d e f
/*
 * remove adjacent duplicates with k
 * k개만큼 인접해있는 같은 알파벳을 제거하여 출력하는 함수이다.
 * 제거 후 다시 k개만큼 인접한 알파벳도 제거한다.
 * 알파벳을 쌓는 스택과 인접알파벳 개수를 쌓는 스택 2개를 운용하여 O(n) 성능이 나옴.
 * -> 로직 간단하게 개선이 필요함..
 */
int	main(void)
{
	//char	*input = "abbcbbcdef";
	char	*input = "abbcddde";
	//char	*input = "aab";
	int k = 3;
	int	ret = 1;
	int		index;
	t_node	*node;
	
	index = 0;
	t_node	head;
	t_node	tail;
	t_node	head2;
	t_node	tail2;

	// 초기화..
	(&head)->next = &tail;
	(&tail)->prev = &head;
	
	while (input[index])
	{
		node = top(&head, &tail);
		if (((&head)->next != &tail) && *(char*)(node->data) == input[index])
		{
			node = top(&head2, &tail2);
			ret = *(int *)(node->data);
			if (k == ret + 1)
			{
				while (ret)
				{
					pop(&head, &tail);
					ret--;
				}
				pop(&head2, &tail2);
			}
			else
			{
				push(&head, &tail, &input[index]);
				ret += 1;
				node->data = &ret;
			}
		}
		else
		{
			int ret = 1;
			push(&head, &tail, &input[index]);
			push(&head2, &tail2, &ret);
		}
		index++;
	}
	show_r(&head, &tail);
	//show_d_r(&head2, &tail2);
}
