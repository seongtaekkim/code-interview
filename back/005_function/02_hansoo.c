#include <stdio.h>

int main() {
 int N,i=1,cnt=0;
 scanf("%d",&N);

 while(N>=i) {
  if(i < 100) {
   cnt++;
  } else if(i == 1000) {
  } else {
   // 100 < i <999
   if ((float)(i%10 + i/10/10)/2 == (i/10)%10) {
    cnt++;
   } 

  }
  

  i++;
 }
 printf("%d\n",cnt);

 return 0;
}
