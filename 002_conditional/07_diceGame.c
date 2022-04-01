#include <stdio.h>


/* 
*  주사위3개를 던져서 1.세개가 같은경우, 2.두개만 같은경우, 3.모두 다른경우. 상금을 준다.
*  1 : 10000 + 주사위수*1000
*  2 : 1000 + 두개가 같은수*100
*  3 : 가장큰수*100
*/
int main() {
 int a,b,c,reward;
 scanf("%d %d %d",&a, &b, &c);
 if(a == b && b == c) {
  reward = 10000 + a*1000;
 } else if(a==b || b==c || a==c) {
  reward = 1000 + (a==b ? 100*a : 0) + (b==c ? b*100 : 0) + (a==c ? a*100 : 0);
 } else if(a!=b && b!=c && a!=c) {
  reward = a>b&&a>c ? 100*a:0 + b>a&&b>c ? 100*b : 0 + c>a&&c>b ? 100*c : 0;
 }
 printf("%d",reward);
 return 0;
}
