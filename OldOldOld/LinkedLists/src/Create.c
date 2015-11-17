#include<stdio.h>
#include<stdlib.h>

typedef struct node NODE;

struct node {
	int value;
	NODE* next;
};

printList(NODE* head, char* msg) {
	printf("======%s=======\n", msg);
	while(head != NULL) {
		printf("%d  ", head->value);
		head = head -> next;
	}

	printf("\n");
}

void insertNext2Node(NODE** head, NODE* newNode) {
	NODE* currentFirstNode = *head;
	*head = newNode;
	(*head)->next = currentFirstNode;
}

void insertNth(NODE** head, NODE* newNode, int targetPos) {
	// insert as the first node
	if (targetPos == 0 ) {
		insertNext2Node(head, newNode);
		return;
	}

	// assume that there are enough nodes in the list such that we can traverse till the desired position
	NODE* curNode = *head;
	while( --targetPos != 0) {
		curNode = curNode->next;
	}

	insertNext2Node(&(curNode->next), newNode);
}

NODE* createNode(int value, NODE* next) {
	NODE* node = (NODE*)malloc(sizeof(NODE));
	node->value = value;
	node->next = next;
	return node;
}

void sortedInsertNode(NODE** head, NODE* newNode) {
	if (*head == NULL || (*head)->value > newNode->value) {
		insertNext2Node(head, newNode);
	}

	NODE* curNode = *head;

	while (curNode->next != NULL && curNode->next->value < newNode->value)
		curNode = curNode->next;

	insertNext2Node(&(curNode->next), newNode);
}

NODE* NthFromLast(NODE* head, int N) {

    if (head == NULL)
        return NULL;

    NODE* pointer1 = head;
    NODE* pointer2 = head;

    int i=0;

    while (i!=N) {
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

int main() {
	int num = 0, pos = 0;
	NODE* head = NULL;

	while(1) {
		scanf("%d", &num);
		if (num == -1)
			break;
		insertNext2Node(&head, createNode(num, NULL));
		printList(head, "after an insert");
	}

	printf("Enter value position to insert at desired position\n");
	while(1) {
		scanf("%d %d", &num, &pos);
		if (num == -1)
			break;
		insertNth(&head, createNode(num, NULL), pos);
		printList(head, "after an insert");
	}

	printf("Enter the value to insert sorted\n");
	while(1) {
		scanf("%d", &num);
		if (num == -1)
			break;
		sortedInsertNode(&head, createNode(num, NULL));
		printList(head, "after an insert");
	}

	printf("Enter the N value to find the N from last: \n");
    NODE* t;
	while(1) {
		scanf("%d", &num);
		if (num == -1)
			break;
        t = NthFromLast(head, num);
        if (t!=NULL)
            printf("%dth from last: %d\n", num, t->value); 
        else
            printf("%dth from last does not exist\n", num);
	}
}
