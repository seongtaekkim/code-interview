#include <stdio.h>


int pibonacci(int n1, int n2, int currIdx, int endIdx) {
 if(currIdx == endIdx) {
  return n1+n2;
 } else {
  return pibonacci(n2, n1+n2, currIdx+1,endIdx);
 }
}

int main() {
 int n;
 scanf("%d",&n);
 if(n ==0) {
  printf("0\n");
 } else if(n == 1) {
  printf("1\n");
 } else {
  printf("%d\n",pibonacci(0,1,2,n));
 }
 return 0;
}
