#include <stdio.h>
#include <stdlib.h>

int main() {
 int N=1,i=0,max=0,min=0;
 scanf("%d",&N);
 //int arr[N] = {0,};
 int* arr = (int*)malloc(sizeof(int)*N);
 while(N>i) {
  scanf("%d",&arr[i]);
  i++;
 }
 i=0;
 min = arr[0];
 max = arr[0];
 while(N>i) {
  if(arr[i] > max) {
   max = arr[i];
  }
  if(arr[i] < min) {
   min = arr[i];
  }
  i++;
 }
 printf("%d %d\n",min,max);
 return 0;
}
