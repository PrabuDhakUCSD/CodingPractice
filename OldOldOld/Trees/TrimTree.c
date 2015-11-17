Node* TrimTree(Node* root, int min, int max) {

    if (root->data >= min && root->data <= max) {
        root->left = TrimTree(root->left, min, root->data)
        root->right = TrimTree(root->right, root->data+1, max)
        return root;
    }

    else if (root->data < min ) {
        root->left = NULL;
        root->right = TrimTree(root->right, min, max)
        return root->right;
    }

    else {
        root->right= NULL;
        root->left = TrimTree(root->left, min, max)
        return root->left;
    }
}
