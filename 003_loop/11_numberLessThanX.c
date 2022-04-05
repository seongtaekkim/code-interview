#include <stdio.h>
#include <stdlib.h>

int main() {
 int N,X,i=0;
 int* A;
 scanf("%d %d",&N,&X);
 A = (int*)malloc(sizeof(int)*N);
 while(N>i) {
  scanf("%d",&A[i]);
  i++;
 }
 i=0;
 while(N>i) {
  if(X > A[i]) {
   printf("%d ",A[i]);
  }
  i++;
 }
 free(A);
 return 0;
}
