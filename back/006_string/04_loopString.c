#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
 int T=0,R,i=0,j=0,k=0;
 char buffer[20];
 char *S;

 scanf("%d",&T);
 while(T>i) {
  scanf("%d %s",&R,buffer);
  S = (char*)malloc(sizeof(char)*(strlen(buffer)+1));
  strcpy(S,buffer);
  j=0;
  while(strlen(S) > j) {
   k=0;
   while(R>k) {
    printf("%c",S[j]);
    k++;
   }
   j++;
  }
  i++;
  printf("\n");
 }
 
 free(S); 
 return 0;
}
