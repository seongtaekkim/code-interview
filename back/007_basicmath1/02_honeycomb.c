#include <stdio.h>


int main() {
 long long in=0,n=1,ret=0;
 scanf("%lld",&in);
 while(in > n) {
  if(3*n*(n+1)+1 >= in) {
   n++;
   break;
  } 
  n++;
 }
 printf("%lld\n",n);
 return 0;
}
