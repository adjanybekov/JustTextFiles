#include "Queue.h"

Queue::Queue()
{
    head=0;
    tail=0;
}

Queue::~Queue()
{
    //dtor
}
ItemType Queue::dequeElem()
{
    ItemType item = items[head];
    if(head==maxLength){
        head=0;
    }
    else head++;
    return item;
}

ItemType Queue::frontElem()
{
    if(!isEmpty())
        return items[head];
}

void Queue::enqueueElem(ItemType item)
{
    items[tail] = item;
    if(tail==maxLength)
        tail = 0;
    else tail++;
}

bool Queue::isEmpty()
{
    return tail+1==head;
}
