#include <iostream>
#include "Queue.h"

using namespace std;

int main()
{
    cout << "Hello world!" << endl;
       Queue aQueue;
    cout<<aQueue.isEmpty()<<endl;
              	 // read an item

   cout<<"Number of items to insert:";
   int n;
   cin>>n;


   for(int i=0; i<n; i++){
        int anItem;
        cin>>anItem;
        //cout<<aStack.isEmpty()<<endl;
        aQueue.enqueueElem(anItem);     	 // push it onto stack
        cout<<aQueue.frontElem()<<endl;
   }
    cout<<"Here printing"<<endl;

   while(!aQueue.isEmpty()){
     cout<<aQueue.dequeElem()<<endl;
   }
    return 0;
}
