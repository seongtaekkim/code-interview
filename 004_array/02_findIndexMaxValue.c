#include <stdio.h>

int main() {
 int n=9,i=0,max=0,idx=0;
 int arr[10] = {0,}; 
 while(n>i) {
  scanf("%d",&arr[i]);
  i++;
 }
 i=0;
 while(n>i) {
  if(arr[i] > max) {
   max = arr[i];
   idx = i+1;
  }
  i++;
 }
 printf("%d\n",max);
 printf("%d\n",idx);
 return 0;
}
