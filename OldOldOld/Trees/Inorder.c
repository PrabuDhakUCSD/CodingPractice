void inorderRecursive(Node* root) {
	if (root == NULL)
		return;

	inorderRecursive(root->left);
	print root->data;
	inorderRecursive(root->right);
}

void inorderWOTailRecursion(Node* root) {
    while(root!= NULL) {
        inorderRecursive(root->left);
        print root->data;
        root = root->right;
    }
}

void inorderIterative(Node* root) {

	Node* currentNode = root;

	while  (currentNode != NULL) {

		while(currentNode->left != NULL) {
			push(currentNode);
			currentNode = currentNode->left;
		}

		print currentNode->data;

		if (currentNode->right != NULL)
			currentNode = currentNode->right;
		else {
			while (currentNode = pop() != NULL) {
				print currentNode->data;
				if (currentNode->right != NULL) {
					currentNode = currentNode->right;
					break;
				}
			}
		}
	}
}
