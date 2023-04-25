#include <stdio.h>
#include <string.h>

int main() {
 int sec=0,i=0;
 char s1[16];
 scanf("%s",s1);

 while(strlen(s1)>i) {
  if(s1[i] == 'A' || s1[i] == 'B' || s1[i] == 'C')
   sec += 3;
  else if(s1[i] == 'D' || s1[i] == 'E' || s1[i] == 'F')
   sec += 4;
  else if(s1[i] == 'G' || s1[i] == 'H' || s1[i] == 'I')
   sec += 5;
  else if(s1[i] == 'J' || s1[i] == 'K' || s1[i] == 'L')
   sec += 6;
  else if(s1[i] == 'M' || s1[i] == 'N' || s1[i] == 'O')
   sec += 7;
  else if(s1[i] == 'P' || s1[i] == 'Q' || s1[i] == 'R' || s1[i] == 'S')
   sec += 8;
  else if(s1[i] == 'T' || s1[i] == 'U' || s1[i] == 'V')
   sec += 9;
  else if(s1[i] == 'W' || s1[i] == 'X' || s1[i] == 'Y' || s1[i] == 'Z')
   sec += 10;
 i++;
 }

 printf("%d\n",sec);


 return 0;
}
