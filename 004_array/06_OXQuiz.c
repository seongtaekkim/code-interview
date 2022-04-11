#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
 int n,i=0,j=0,tinyCnt=0,totalCnt=0;
 scanf("%d",&n);
 char *quiz;
 while(n>i) {
  //printf("input n: %d, i: %d\n",n,i);
  quiz = (char*)malloc(sizeof(char)*80);
  scanf("%s",quiz);
  totalCnt=0;
  tinyCnt=0;
  j=0;
  while(strlen(quiz)>j) {
   if(quiz[j] == 'O') {
    ++tinyCnt;
    totalCnt = totalCnt + tinyCnt;
   } else {
    tinyCnt=0;
   }
   j++;
  }
  free(quiz);
  printf("%d\n",totalCnt);
  i++;
 }
 
 return 0;
}
