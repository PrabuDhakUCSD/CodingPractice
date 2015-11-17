Node* NthFromLast(Node* head, int N) {

    if (head == NULL)
        return NULL;

    Node* pointer1 = head;
    Node* pointer2 = head;

    int i=0;

    while (i<=N) {
        pointer2 = pointer2 -> next;
        if (pointer2 == NULL)
            return NULL;
        i++;
    }

    while(pointer2 -> next != NULL) {
        pointer1 = pointer1 -> next;
        pointer2 = pointer2 -> next;
    }

    return pointer1;
}
