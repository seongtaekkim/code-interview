#include <stdio.h>

int main() {
 int N,i=0,max=0,sum=0;
 scanf("%d",&N);
 float M[N];
 while(N>i) {
  scanf("%f",&M[i]);
  i++;
 }
 i=0;
 while(sizeof(M)/sizeof(float)>i) {
  if(M[i]>max) {
   max = M[i];
   //printf("max is : %d",max);
  }
  i++;
 }

 i=0;
 // 점수/M*100
 while(sizeof(M)/sizeof(float)>i) {
  //M[i] = (M[i]/max)*100;
  sum += M[i];
  i++;
 }
 //printf("max : %d\n",max); 
 printf("%f",(double)sum/max/(sizeof(M)/sizeof(float))*100);
 
 return 0;
}

