#include <stdio.h>

int main() {
 int A,B,T,i=0;
 scanf("%d",&T);
 while(T>i) {
  scanf("%d %d",&A,&B);
  printf("Case #%d: %d + %d = %d\n",i+1,A,B,A+B);
  i++;
 }
 return 0;
}
