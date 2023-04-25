#include <stdio.h>
#include <string.h>
#define ALPHABET_SIZE 26
int main() {
 char S[1000000];
 char alphabet[ALPHABET_SIZE] = "abcdefghijklmnopqrstuvwxyz";
 char alphabetU[ALPHABET_SIZE] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 int ret[ALPHABET_SIZE] = {0,};
 int i=0,j=0,max=0,maxIdx;
 scanf("%s",S);
 while(strlen(S) > i) {
  j=0;
  while(ALPHABET_SIZE >j) {
   if(alphabet[j] == S[i] ||alphabetU[j] == S[i]) {
    ret[j]++;
    j++;
    break;
   }
   j++;
  }
  i++;
 }
 i=0, j=0;
 while(ALPHABET_SIZE>i) {
  if(ret[i] > max) {
   max = ret[i];
   maxIdx = i;
  }
  i++;
 }
 while(ALPHABET_SIZE>j) {
  if(max == ret[j] && j != maxIdx) {
   maxIdx=-1;
   break;
  }
  j++;
 }

 if(maxIdx == -1) {
  printf("?");
 } else {
  printf("%c",alphabetU[maxIdx]);
 }
 return 0;
}
