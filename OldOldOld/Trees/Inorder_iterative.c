void inorder(Node* node) {
    if (node == NULL)
        return;
    inorder(node->left);
    print(node->data);
    inorder(node->right);
}

void inorder(Node* node) {
    if (node==NULL)
        return;

    while(1) {
        while(node->left!=NULL) {
            push(node);
            node=node->left;
        }

        print(node->data);

        while(node->right==NULL) {
            node = pop();
            if (node==NULL)
                return;
            print(node->data);
        }
        node = node->right;
    }
}
