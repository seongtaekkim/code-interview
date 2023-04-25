#include <stdio.h>
#include <stdlib.h>

long sum(int *a, int n);

int main() {
 int n,i=0;
 scanf("%d",&n);
 int *a = (int*)malloc(sizeof(int)*n);
 while(n>i)  {
  scanf("%d",&a[i]);
  i++;
 }
 printf("%ld\n",sum(&a[0], n));
 
 return 0;
}

long sum(int *a, int n) {
 int i=0;
 long sum=0;
 while(n>i) {
  sum = sum + a[i];
  i++;
 }
 return sum;
}

