#include <stdio.h>
#include <string.h>

int main() {
 int N=0,i=0,j=0,k=0,rCnt=0,flag=0;
 char word[101];
 char chkArr[101];
 scanf("%d",&N);
 
 while(N>i) {
  scanf("%s",word);
  j=0;
  flag=1;
  memset(chkArr,'\0',sizeof(chkArr));
  while(strlen(word)>j) {
   //printf("strlen : %d\n",strlen(chkArr));
   if(j==0) {
    chkArr[0] = word[0];
   } else {
    if(chkArr[strlen(chkArr)-1] != word[j]) {
     k=0;
      while(strlen(chkArr)-1 > k) {
      //printf("%d : %c %d : %c\n",k,chkArr[k],j,word[j]);
      if(chkArr[k] == word[j]) {
       flag = 0;
      }
      k++;
     }
    }
    if(flag!=0) {
     //printf("insert %c, strlen: %d \n",word[j],strlen(chkArr));
     chkArr[strlen(chkArr)] = word[j];
    }
   }

   j++;
  }
  if(flag!=0)
   rCnt+=1;
  i++;
 }
 printf("%d\n",rCnt);
 return 0;
}
