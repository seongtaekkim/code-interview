#include <stdio.h>

// 별찍기1
int main() {
 int N,i=0,j;
 scanf("%d",&N);
 while(N>i) {
  j=0;
  while(i>=j) {
   printf("*");
   j++;  
  }
  i++;
  printf("\n");
 }
 return 0;
}
