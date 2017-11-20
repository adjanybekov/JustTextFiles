#include <stdio.h>
#include <stdlib.h>

int foo() // given method that returns 1 to 5 with equal probability
{
    
    return rand()%5+1;
    // some code here
}
 
int my_rand() // returns 1 to 7 with equal probability
{
    int i;
    i = 5*foo() + foo() - 5;
    if (i < 22)
        return i%7 + 1;
    return my_rand();
}
 
int main()
{
  time_t t;
  srand((unsigned) time(&t));
  int a[7] = {0};
  for(int i=0; i<10000; i++){
    int an=my_rand();
    //printf ("%d \n",an);
    switch(an){
      case 7:a[0]++;
        break;
      case 1:a[1]++;
        break;
      case 2:a[2]++;
        break;
      case 3:a[3]++;
        break;
      case 4:a[4]++;
        break;
      case 5:a[5]++;
        break;
      case 6:a[6]++;
        break;
    }
    
  }
  printf ("%d %d %d %d %d %d %d \n",a[1],a[2],a[3],a[4],a[5],a[6],a[0]);
    
  return 0;
}
