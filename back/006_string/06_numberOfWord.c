#include <stdio.h>
#include <string.h>
int main() {
 char S[1000001];
 int i=0,cnt=0;
 scanf("%[^\n]s",S);
 while(strlen(S)>i) {
  if(S[i] == ' ') {
   if(i==0) {}
   else if(i==strlen(S)-1) {}
   else {
    cnt++;
   }
  } 
  i++;
 }
 if(strlen(S) == 1 && S[0] == ' ') 
  cnt = 0;
 else 
  cnt +=1;
 printf("%d\n",cnt);

 return 0;
}
