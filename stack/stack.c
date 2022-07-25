#include <stdio.h>
#include <stdlib.h>

#include "stack.h"


void	push(t_node *head, t_node *tail, void *data)
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
		node->next = head->next;
		node->prev = head;
		head->next = node;
		(node->next)->prev = node;
	}
}

void	pop(t_node *head, t_node *tail)
{
	t_node *node;
	node = head->next;
	if (head == tail)
		return ;
	head->next = node->next;
	(node->next)->prev = head;
	free(node);
}

t_node	*top(t_node *head, t_node *tail)
{
	t_node	*node;
	node = head->next;
	if (node != NULL && node != tail)
		return (node);
	return (NULL);
}

void	show(t_node *head, t_node *tail)
{
	t_node *node;
	node = head->next;
	
	while (node != NULL && node != tail)
	{
		printf("%c ",*(char *)node->data);
		node = node->next;
	}
	printf("\n");
}

void	show_r(t_node *head, t_node *tail)
{
	t_node *node;
	node = tail->prev;
	
	while (node != NULL && node != head)
	{
		printf("%c ",*(char *)node->data);
		node = node->prev;
	}
}
