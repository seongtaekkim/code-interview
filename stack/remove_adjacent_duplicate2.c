#include "stack.h"


// a b b c b b c d e f
int	main(void)
{
	char	*input = "abbcbbcdef";
	int		index;
	t_node	*node;
	
	index = 0;
	t_node	head;
	t_node	tail;
	t_node	head2;
	t_node	tail2;
//(void)argv;
//(void)argc;
	/*if (argc != 2 )
	{
		printf("please confirm argument value\n");
		return (0);
	}*/
	
	//int k = 2;
	while (input[index])
	{
		node = top(&head, &tail);
		if (((&head)->next != NULL) && ((&head2)->next != NULL) && *(char*)(node->data) == input[index])
		{	
			node = top(&head2, &tail2);
			int ret = *(int *)(node->data) + 1;
			node->data = &ret;
			push(&head2, &tail2, node->data);
		}
		if ((&head2->next != NULL))
		{
		}
		else
		{
		}
		push(&head, &tail, &input[index]);
		index++;
	}
	/*
	while (input[index])
	{
		node = top(&head, &tail);
		if ((&head)->next != NULL && *(char *)(node->data) == input[index])
		{
			pop(&head, &tail);
		}
		else	
			push(&head, &tail, &input[index]);
		index++;
	}*/
	show_r(&head, &tail);
	printf("\n");
	show_d_r(&head2, &tail2);
}
