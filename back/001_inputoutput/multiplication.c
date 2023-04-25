#include <stdio.h>

int main() {
 int a;
 char b[4] = {};
 scanf("%d",&a);
 scanf("%s",b);
 int i, sum=0;
 for(i=2; i>=0; i--) {
  int k=2-i,digit=1;
  while(k>0) {
   digit = digit * 10;
   k--;
  }
  //printf("b is : %d, a*b is %d\n",(b[i]-'0')*digit,a*(b[i]-'0')*digit);
  sum += a * (b[i]-'0')*digit;
  printf("%d\n",a*(b[i]-'0'));
 }
  printf("%d\n",sum);
 return 0;
}
