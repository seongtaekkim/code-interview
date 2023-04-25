#include <stdio.h>
#include <string.h>

int main() {
 char a[100001]="";
 char b[100001]="";
 char num_a[100001]="";
 char num_b[100001]="";
 scanf("%s %s",a,b);

 int carry=0, tmp=0;
 sprintf(num_a,"%0100000s",a);
 sprintf(num_b,"%0100000s",b);
 while(strlen(num_a) > tmp) {
  if(num_a[tmp] == 32)
    num_a[tmp] = '0';
  if(num_b[tmp] == 32)
    num_b[tmp] = '0';
  tmp++;
 }
 tmp=0;
 int i = strlen(num_a)-1;
 while(i > 0) {
  tmp = num_a[i]-'0' + num_b[i]-'0' + carry;
  //printf("num_a : %c,  %d\n",num_a[i], tmp);
  carry = tmp / 10;
  num_a[i] = tmp % 10 + '0';
  //printf("sum : %c\n",sum[i]);
  i--;
 }
 i = 0;
 while(i<strlen(num_a)) {
  if(num_a[i]-'0'!= 0) {
   break;
  }
  i++;
 }
 //char ret* = (char*)malloc(sizeof(char)*(i));
 char ret[100001]="";
 int k=0;
 while(strlen(num_a) > k) {
  ret[k] = num_a[k+i];
  k++;

 }
 //printf("%s\n",num_a);
 //printf("%s\n",num_b);
 printf("%s\n",ret);
 //printf("%d\n",strlen(sum));
 return 0;
}

  
