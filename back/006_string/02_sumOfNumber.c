#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
 int N,i=0,sum=0;
 scanf("%d",&N);
 char *s = (char*)malloc(sizeof(char)*N);
 scanf("%s",s);
 while(strlen(s)>i) {
  sum = sum + (s[i]-'0');
  i++;
 }
 printf("%d",sum);
 return 0;
}
