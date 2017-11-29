#ifndef QUEUE_H
#define QUEUE_H

typedef int ItemType;
const int maxLength = 10;
class Queue
{
    public:
        Queue();
        ~Queue();
        ItemType dequeElem();
        ItemType frontElem();
        void enqueueElem(ItemType item);
        bool isEmpty();


    private:
        int head;
        int tail;
        ItemType items[];
};

#endif // QUEUE_H
