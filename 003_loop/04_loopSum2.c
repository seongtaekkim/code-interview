#include <stdio.h>
#include <stdlib.h>

int main() {
 int T=0;
 scanf("%d",&T);
 int* A = (int*)malloc(sizeof(int)*T);
 int* B = (int*)malloc(sizeof(int)*T);
 int i=0;
 while(i<T) {
  scanf("%d %d",&A[i],&B[i]);
  i++;
 }
 i=0;
 while(i<T) {
  printf("%d\n",A[i]+B[i]);
  i++;
 }
}
