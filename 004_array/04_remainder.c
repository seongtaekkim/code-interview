#include <stdio.h>

int main() {
 int dividend = 42;
 int divisor[10] = {0,};
 int i=0,j=0;
 int remainders[10] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
 int remainder;
 while(sizeof(divisor)/sizeof(int)>i) {
  scanf("%d",&divisor[i]);
  i++;
 }
 //printf("divisor size : %lu\n",sizeof(divisor)/sizeof(int));
 //printf("remainders size : %lu\n",sizeof(remainders)/sizeof(int));
 i=0;
 while(sizeof(divisor)/sizeof(int)>i) {
  j=0;
  remainder = divisor[i]%dividend;
  while(sizeof(remainders)/sizeof(int)>j) {
   if(remainders[j] == -1) {
    //printf("i : %d, j : %d, reaminders[j] : %d, divisor[i] : %d\n",i,j,remainders[j],divisor[i]);
    remainders[j] = remainder;
    break;
   }
   if(remainders[j] == remainder) {
    break;
   }
   j++;
  }
  i++;
 }
 i=0;
 while(sizeof(remainders)/sizeof(int)>i) {
  //printf("%d\n",remainders[i]);
  if(remainders[i] != -1) {
  } else {
   break;
  }
  i++; 
 }
 printf("%d",i);
 return 0;
}
