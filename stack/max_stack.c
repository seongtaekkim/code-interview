#include <stdio.h>
#include <stdlib.h>

typedef struct s_node
{
	struct s_node	*next;
	struct s_node	*prev;
	void		*data;
	int		max_idx;
}	t_node;

void	push(t_node *top, t_node *bottom, void *data)
{
	t_node *node;
	node = (t_node *)malloc(sizeof(t_node));
	node->data = data;
	if (!top->next)
	{
		node->next = bottom;
		bottom->prev = node;
		top->next = node;
		node->prev = top;
	}
	else
	{
		node->next = top->next;
		node->prev = top;
		top->next = node;
		(node->next)->prev = node;
	}
}

void	pop(t_node *top, t_node *bottom)
{
	t_node *node;
	node = top->next;
	if (top == bottom)
		return ;
	top->next = node->next;
	(node->next)->prev = top;
	free(node);
}

t_node	*topf(t_node *top, t_node *bottom)
{
	t_node	*node;
	node = top->next;
	if (node != NULL && node != bottom)
		return (node);
	return (NULL);
}

void	show(t_node *top, t_node *bottom)
{
	t_node *node;
	node = top->next;
	
	while (node != NULL && node != bottom)
	{
		printf("%c ",*(char *)node->data);
		node = node->next;
	}
	printf("\n");
}



int	main(void)
{
	t_node top;
	t_node bottom;
	t_node max_top;
	t_node max_bottom;
	int	input[] = {1,3,3,2,2,5,1};

	push(&top, &bottom, &input);
	show(&top, &bottom);
		

}
