#include <stdio.h>
// 별찍기2
int main() {
 int N,i=0,j=0;
 scanf("%d",&N);
 while(N>i) {
  j=0;
  while(N>j) {
   if(j >= N-i-1)
    printf("*");
   else 
    printf(" ");
   j++;
  }
  printf("\n");
  i++;
 }
 return 0;
}
