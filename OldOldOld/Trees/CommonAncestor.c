Node* commmonAncestor(Node* head, Node* child1, Node* child2) {

	if (head == NULL || head->left == child1 || head->right == child1 || head->left == child2 || head->right == child2) {
		return head;
	}

	Node* left = commmonAncestor(head->left, child1, child2);
	Node* right = commmonAncestor(head->right, child1, child2);

	if (left!= NULL && right!= NULL)
		return head;
	
	(left!=NULL)?return left: return right;
}
