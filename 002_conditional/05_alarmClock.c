#include <stdio.h>

int main() {
 int h,m;
 scanf("%d %d",&h,&m);
 m = m + h*60 - 45;
 if(m < 0) {
  h = 23;
  m = 60 + m;
 } else {
  h = m/60;
  m = m%60;
 }
 printf("%d %d",h,m);
 return 0;
}
