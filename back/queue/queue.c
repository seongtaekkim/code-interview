#include <stdio.h>
#include <stdlib.h>
typedef struct s_node
{
	struct s_node	*next;
	struct s_node	*prev;
	int	data;
}	t_node;

void	enqueue(t_node *head, t_node *tail, int data)
{
	t_node *node;
	node = (t_node *)malloc(sizeof(t_node));
	node->data = data;
	if (!head->next)
	{
		node->next = tail;
		tail->prev = node;
		head->next = node;
		node->prev = head;
	}
	else
	{
		node->prev = tail->prev;
		(tail->prev)->next = node;
		node->next = tail;
		tail->prev = node;
	}
}

void	dequeue(t_node *head, t_node *tail)
{
	t_node *node;
	node = head->next;
	if (node == tail)
		return ;
	head->next = node->next;
	(node->next)->prev = head;
	free(node);
}

void	show(t_node *head, t_node *tail)
{
	t_node *node;
	node = head->next;
	
	while (node != tail)
	{
		printf("%d ",node->data);
		node = node->next;
	}
	printf("\n");
}


int	main(void)
{
	t_node head;
	t_node tail;
	enqueue(&head, &tail, 1);
	enqueue(&head, &tail, 5);
	enqueue(&head, &tail, 10);
	show(&head, &tail);
	dequeue(&head, &tail);
	dequeue(&head, &tail);
	dequeue(&head, &tail);
	show(&head, &tail);

	enqueue(&head, &tail, 20);
	enqueue(&head, &tail, 30);
	show(&head, &tail);
}
