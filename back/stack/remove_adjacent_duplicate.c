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
	}
	show_r(&head, &tail);
}
