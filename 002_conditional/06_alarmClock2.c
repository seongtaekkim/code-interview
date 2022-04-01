#include <stdio.h>

int main() {
 int h,m,in_m;
 scanf("%d %d",&h,&m);
 scanf("%d",&in_m);
 m = m + in_m + h*60;
 h = m/60;
 h = h%24;
 m = m%60;
 printf("%d %d",h,m);
 return 0;
}
