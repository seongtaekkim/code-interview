#include <stdio.h>
#include <string.h>

int main() {
 char S[101];
 int i=0,idx=0,flag=0;
 char alphabet[26] = "abcdefghijklmnopqrstuvwxyz";
 scanf("%s",S);
 while(26 > i) {
  flag=0, idx=0;
  while(strlen(S) > idx) {
   if(alphabet[i] == S[idx]) {
    flag=1;
    break;
   } else {
    idx++;
   }
  } 

  if(flag==1)
   printf("%d ",idx);
  else
   printf("-1 "); 
  i++;
 }

 return 0;
}
