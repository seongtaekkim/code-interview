#include <stdio.h>
#include <string.h>
#include <stdlib.h>
// 최적화 필요
int main() {
 int cycle=0,sum=0;
 char* N = (char*)malloc(sizeof(char)*2);
 char* nextN = (char*)malloc(sizeof(char)*2);
 scanf("%s",N);
 if(strlen(N) == 1) {
  N[1] = N[0];
  N[0] = 0+'0'; 
 }
 strcpy(nextN,N);
 do {
  cycle++;
  //printf("size : %lu value : %s \n", strlen(nextN),nextN);
  sum = (nextN[0]-'0') + (nextN[1]-'0');
  //printf("%c + %c = %d\n",nextN[0],nextN[1],sum);
  if(sum >=10) {
   sum = sum%10;
  }
  
  nextN[0] = nextN[1];
  nextN[1] = sum + '0';
  if(strcmp(N,nextN)!=0) {
  } else {
   //printf("%s, %s\n",N,nextN);
   break;
  }
 }while(1);
 printf("%d",cycle);
 return 0;
}
