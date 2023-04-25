#include <stdio.h>

int main() {
 int T,A,B,i=0;
 scanf("%d",&T);
 i=0;
 while(T>i) {
  scanf("%d %d",&A,&B); 
  printf("Case #%d: %d\n",i+1,A+B);
  i++;
 }
 return 0;
}
