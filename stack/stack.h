#ifndef STACK_H
# define STACK_H

#include <stdio.h>
#include <stdlib.h>

typedef struct s_node
{
	struct s_node	*next;
	struct s_node	*prev;
	void			*data;
}	t_node;

void	push(t_node *head, t_node *tail, void *data);
void	pop(t_node *head, t_node *tail);
t_node	*top(t_node *head, t_node *tail);
void	show(t_node *head, t_node *tail);
void	show_r(t_node *head, t_node *tail);
void	show_d_r(t_node *head, t_node *tail);

#endif
