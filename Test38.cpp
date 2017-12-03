#include <iostream>
#include <stack>
#include "Tree.h"


using namespace std;

struct node{
    int data;
    node* right;
    node* left;
    int height;
};

int height(node* x){
    if(x==NULL)
        return 0;
    return x->height;
}

node *rightRotate(node *y)
{
    node *x = y->left;
    node *T2 = x->right;

    // Perform rotation
    x->right = y;
    y->left = T2;

    // Update heights
    y->height = max(height(y->left), height(y->right))+1;
    x->height = max(height(x->left), height(x->right))+1;

    // Return new root
    return x;
}

node *leftRotate(node *x)
{
    node *y = x->right;
    node *T2 = y->left;

    // Perform rotation
    y->left = x;
    x->right = T2;

    //  Update heights
    x->height = max(height(x->left), height(x->right))+1;
    y->height = max(height(y->left), height(y->right))+1;

    // Return new root
    return y;
}
node* newNode(int data){
    node* n = new node;
    n->height = 1;
    n->data = data;
    n->left =NULL;
    n->right=NULL;
    return n;
}
int getBalance(node *N)
{
    if (N == NULL)
        return 0;
    return height(N->left) - height(N->right);
}

node* insertNodeToAVL(node* node, int key)
{
    /* 1.  Perform the normal BST insertion */
    if (node == NULL)
        return(newNode(key));

    if (key < node->data)
        node->left  = insertNodeToAVL(node->left, key);
    else if (key > node->data)
        node->right = insertNodeToAVL(node->right, key);
    else // Equal keys are not allowed in BST
        return node;

    /* 2. Update height of this ancestor node */
    node->height = 1 + max(height(node->left),
                           height(node->right));

    /* 3. Get the balance factor of this ancestor
          node to check whether this node became
          unbalanced */
    int balance = getBalance(node);

    // If this node becomes unbalanced, then
    // there are 4 cases

    // Left Left Case
    if (balance > 1 && key < node->left->data)
        return rightRotate(node);

    // Right Right Case
    if (balance < -1 && key > node->right->data)
        return leftRotate(node);

    // Left Right Case
    if (balance > 1 && key > node->left->data)
    {
        node->left =  leftRotate(node->left);
        return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key < node->right->data)
    {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }

    /* return the (unchanged) node pointer */
    return node;
}
//node* insertNodeToAVL(node* node, int data)
//{
//    /* 1.  Perform the normal BST insertion */
//    if (node == NULL)
//        return(newNode(data));
//
//    if (data < node->data)
//        node->left  = insertNodeToAVL(node->left, data);
//    else if (data > node->data)
//        node->right = insertNodeToAVL(node->right, data);
//    else // Equal datas are not allowed in BST
//        return node;
//
//    /* 2. Update height of this ancestor node */
//    node->height = 1 + max(height(node->left),
//                           height(node->right));
//
//    /* 3. Get the balance factor of this ancestor
//          node to check whether this node became
//          unbalanced */
//    int balance = getBalance(node);
//
//    // If this node becomes unbalanced, then
//    // there are 4 cases
//
//    // Left Left Case
//    if (balance > 1 && data < node->left->data)
//        return rightRotate(node);
//
//    // Right Right Case
//    if (balance < -1 && data > node->right->data)
//        return leftRotate(node);
//
//    // Left Right Case
//    if (balance > 1 && data > node->left->data)
//    {
//        node->left =  leftRotate(node->left);
//        return rightRotate(node);
//    }
//
//    // Right Left Case
//    if (balance < -1 && data < node->right->data)
//    {
//        node->right = rightRotate(node->right);
//        return leftRotate(node);
//    }
//
//    /* return the (unchanged) node pointer */
//    return node;
//}

void insertNode(node* root, int data){
    if(root == NULL){
        root = new node();
        root->data=data;
    }

    node* tmp = root;
    node* tmp2 ;
    while(tmp!=NULL){
        tmp2 = tmp;
        if(tmp->data > data){
            tmp = tmp->left;
        }
        else
            {tmp = tmp->right;}
        }
    if(tmp2==NULL){
            root->data = data;
    }
    else if(tmp2->data<data){
        node* newNode = new node;
        newNode->data = data;
        newNode->left = NULL;
        newNode->right= NULL;
        tmp2->right = newNode;
    }

    else if(tmp2->data>data){
        node* newNode = new node;
        newNode->data = data;
        newNode->left = NULL;
        newNode->right= NULL;
        tmp2->left = newNode;
    }
}

void preorderTreePrint(node* root){
    if(root!=NULL){
        cout<<root->data<<endl;
        preorderTreePrint(root->left);
        preorderTreePrint(root->right);
    }

}

int main()
{

    node *root = NULL;

  /* Constructing tree given in the above figure */
  root = insertNodeToAVL(root, 10);



  root = insertNodeToAVL(root, 20);
  root = insertNodeToAVL(root, 30);
  root = insertNodeToAVL(root, 40);
  root = insertNodeToAVL(root, 50);

  root = insertNodeToAVL(root, 25);

  preorderTreePrint(root);
    /*node* root = new node;
    root->left = NULL;
    root->right =NULL;
    root->data = 3;

    insertNode(root,2);

    insertNode(root,4);
*/



    //cout << root->data<<root->right->data<<endl;
    return 0;
}
