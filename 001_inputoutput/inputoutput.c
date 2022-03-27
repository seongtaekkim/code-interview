#include <stdio.h>

int aPlusB();
void aDivB();
void concat();

int main() {
    //printf("강한친구 대한육군");
    //printf("강한친구 대한육군");
    //printf("%d\n",aPlusB());
    //aDivB();
    concat();    
    return 0;
}


int aPlusB() {
 int a, b;
 scanf("%d %d",&a,&b);
 return a+b;
}

void aDivB() {
 int a,b;
 scanf("%d %d",&a,&b);
 printf("%.10lf",(double)a/b);
}

/*
* 준하는 사이트에 회원가입을 하다가 joonas라는 아이디가 이미 존재하는 것을 보고 놀랐다. 준하는 놀람을 ??!로 표현한다. 준하가 가입하려고 하는 사이트에 이미 존재하는 아이디가 주어졌을 때, 놀람을 표현하는 프로그램을 작성하시오.
*/
void concat() {
 char a[51] = {};
 scanf("%s", &a);
 
 printf("%s??!",a); 
}
