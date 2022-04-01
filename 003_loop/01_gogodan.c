#include <stdio.h>

int main() {
 int N;
 scanf("%d",&N);
 int i=1;
 while(i<10) {
  printf("%d * %d = %d\n",N,i,N*i);
  i++;
 }
 return 0;
}
