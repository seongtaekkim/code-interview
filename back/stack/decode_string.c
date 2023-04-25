#include "stack.h"
#include "ft_strjoin.c"
#include "ft_atoi.c"

int	is_number(char c)
{
	return (c >= '0' && c <= '9');
}

int	main(void)
{
	const char	*input = "a2[b2[ab]]";
	int			i;
	int			j;
	t_node		head;
	t_node		tail;
	t_node		head2;
	t_node		tail2;
	int			flag;

	(&head->next) = tail;
	(&tail->prev) = head;
	(&head2->next) = tail2;
	(&tail2->prev) = head2;
	i = 0;
	j = 0;
	flag = 0;
	while (input[i])
	{
		if (flag == 0 && !is_number(input[i]))
			push(&head, &tail, &input[i]);
		else
			push(&head2, &tail2, &input[i]);
		if ('[' == input[i])
		{
			i++;
			j = i;
			while (is_number(input[i] || ']' == input[i])
				i++;
			char	*data = (char *)malloc(sizeof(char) * (i - j + 1));
			while (i - j > 0)
			{
				*data = input[j];
				data++;
				j++;	
			}
			input[j] = '\0';
			node->data = data;
		}
		if (']' == input[i])
		{
			// pop logic
		}
		index++;
	}
}
