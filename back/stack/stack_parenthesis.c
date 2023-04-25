#include <stdio.h>
#include <stdlib.h>

typedef struct s_node
{
	struct s_node	*next;
	struct s_node	*prev;
	void			*data;
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
	const char	bracketOpn[4] = "{[(\0";
	const char	bracketCls[4] = "}])\0";
	char	input;
	char	input2;
	int		index;

	scanf("%c %c",&input, &input2);
	push(&top, &bottom, &input);
	show(&top, &bottom);
	
	t_node *node = topf(&top, &bottom);
	index = 0;
	if (node != NULL)
	{
		while (bracketCls[index])
		{
			if (bracketOpn[index] == *(char *)node->data
				&&	bracketCls[index] == input2)
			{	
				pop(&top, &bottom);
				break ;
			}
			index++;
		}
	}
	show(&top, &bottom);
	if (top.next == &bottom)
		printf("success");
	else
		printf("fail");
}
