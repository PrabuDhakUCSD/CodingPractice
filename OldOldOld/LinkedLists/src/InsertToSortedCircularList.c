void insert(Node* aNode, Node* toInsert) {

    if (aNode == NULL)
        return;

    if (aNode -> data > toInsert -> data) {
        while (aNode -> data < (aNode->next->data)){
            aNode = aNode->next;
        }

        if (aNode->next->data > toInsert->data) {
            t = aNode->next;
            aNode->next = toInsert;
            toInsert->next = t;
            return;
        }

        aNode = aNode->next;
    }

    while(aNode->next->data < toInsert->data) {
        aNode = aNode->next;
    }

    t = aNode->next;
    aNode->next = toInsert;
    toInsert->next = t;

    return;

}
