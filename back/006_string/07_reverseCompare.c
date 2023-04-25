#include <stdio.h>

int main() {
 char s1[4],s2[4];
 int i1=0,i2=0;
 scanf("%s %s",s1,s2);
 i1 = (s1[2]-'0')*100 + (s1[1]-'0')*10 + (s1[0]-'0');
 i2 = (s2[2]-'0')*100 + (s2[1]-'0')*10 + (s2[0]-'0');
 if(i1 > i2) {
  printf("%d\n",i1);
 } else {
  printf("%d\n",i2);
 }

 return 0;
}
