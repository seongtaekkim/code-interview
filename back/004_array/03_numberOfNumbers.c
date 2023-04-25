#include <stdio.h>
#include <stdlib.h>

int main() {
 int A,B,C,mul,i=0,tmp,count=0;
 int arr[10] = {0,};
 scanf("%d",&A);
 scanf("%d",&B);
 scanf("%d",&C);
 mul = A*B*C;
 tmp = mul;
 while(tmp!=0) {
  tmp = tmp/10;
  ++count;
 }
 char *ret = (char*)malloc(sizeof(char)*count);
 printf("char size is : %lu\n",sizeof(char));
 printf("ret size is : %lu\n",sizeof(ret));
 sprintf(ret,"%d",mul);
 printf("ret value is : %s\n",ret);
 // 0~9숫자입력개수 배열에 추가.
 while(count > i) {
  arr[ret[i]-'0']++;
  //printf("arr : %d, %d\n",arr[ret[i]-'0'], ret[i]-'0');
  i++;
 }
 i=0;
 while((sizeof(arr)/sizeof(int))>i) {
  printf("%d\n",arr[i]);
  i++;
 } 
 return 0;
}
