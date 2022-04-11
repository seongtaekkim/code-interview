#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
 int C,N,i=0,j=0,k=0,aboveCnt=0;
 float *arr,avg=0.0;
 scanf("%d",&C);
 while(C>i) {
  scanf("%d",&N);
  j=0,avg=0.0;
  arr = (float*)malloc(sizeof(float)*N);
  while(N>j) {
   scanf("%f",&arr[j]);
   avg += arr[j];
   j++;
  }
  k=0, aboveCnt=0;
  avg = avg/N;
  //printf("average : %f\n",avg);
  while(N>k) {
   if(arr[k] > avg) {
    aboveCnt++;
   }
   k++;
  }
  //printf("aboveCnt : %d, N : %d, avg : %f\n",aboveCnt,N,avg);
  printf("%.3f\n%",(float)aboveCnt/N*100);
  i++;
  free(arr);
 }
 return 0;
}
