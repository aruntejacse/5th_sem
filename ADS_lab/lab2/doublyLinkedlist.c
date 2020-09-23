#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>
struct node
{
    int data;
    struct node* next;
};
typedef struct node * Node;

Node XOR(Node a, Node b)
{
    return (Node)((uintptr_t)(a) ^ (uintptr_t)(b));
}

Node insert_front(Node head, int data)
{
    Node newn = (Node)malloc(sizeof(struct node) );
    newn->data = data;
    newn->next = head;
    if(head != NULL)
    {
        head->next = XOR(newn, head->next);
    }

    head = newn;
    return head;
}

Node insert_end(Node head, int data)
{
    Node newn = (Node)malloc(sizeof(struct node));
    newn->data = data;
    Node curr = head;
    Node prev = NULL;
    Node next;

    if(head == NULL)
    {
    head = newn;
    return head;
    }
    else
    {
        while(curr != NULL)
        {
            next = XOR(prev,curr->next);
            prev = curr;
            curr = next;
        }

        newn->next = prev;
        prev->next = XOR(newn, prev->next);
        return head;
    }
}

void printList (Node head)
{
    Node curr = head;
    Node prev = NULL;
    Node next;

    printf ("Following are the nodes of Linked List: \n");

    while (curr != NULL)
    {
        printf ("%d ", curr->data);

        next = XOR (prev, curr->next);
        prev = curr;
        curr = next;
    }
}
int main()
{
    Node head = NULL;

    head = insert_front(head,3);
    head = insert_front(head,7);
    head = insert_front(head,9);
    printList(head);

    printf("\n");

    head = insert_end(head,12);
    printList(head);


    return 0;
}
