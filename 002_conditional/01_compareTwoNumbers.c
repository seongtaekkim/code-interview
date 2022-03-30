#include <stdio.h>

int main() {
 int A,B;
 scanf("%d %d",&A,&B);
 if(A>B) {
  printf("%s",">");
 } else if(B>A) {
  printf("%s","<");
 } else {
  printf("%s","==");
 }
 return 0;
}
