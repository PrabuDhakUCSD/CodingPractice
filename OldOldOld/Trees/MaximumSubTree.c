Node* maxSubTree1(Node* root, int* max) {
    if (root == NULL)
        return NULL;

    int subTreeSum = 0;

    return maxSubTree2(root, max, &subTreeSum);
}

Node* maxSubTree2(Node* root, int* max, int* subTreeSum) {

    if (root == NULL)
        return NULL;

    int leftTreeSum = 0, rightTreeSum = 0, currentTreeSum = 0;

    Node* leftMax = maxSubTree1(root->left, max, &leftTreeSum);
    Node* rightMax = maxSubTree1(root->right, max, &rightTreeSum);

    currentTreeSum = root->data;
    currentTreeSum += leftTreeSum; 
    currentTreeSum += rightTreeSum; 

    *subTreeSum = currentTreeSum;

    if (currentTreeSum > *max) {
        *max = currentTreeSum;
        return root;
    }

    if (left != NULL && right != NULL)
        return right;

    (left == NULL)? right:left
}
