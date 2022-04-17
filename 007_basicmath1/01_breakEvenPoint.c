#include <stdio.h>

int main() {
 int a,b,c;
 int x=0;
 scanf("%d %d %d",&a,&b,&c);
 if(c == b || (float)a/(c-b) <= 0) {
  printf("-1\n");
 } else {
  x = a/(c-b);
  while(x<=2100000001) {
   if(x > a/(c-b)) {
    printf("%d\n",x);
    break;
   }
   x++;
  }
 }
 //printf("%d\n",x); 

 return 0;
}
