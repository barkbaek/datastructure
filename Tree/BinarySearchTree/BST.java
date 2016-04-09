class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;
}

class BinarySearchTree {
	private TreeNode root = new TreeNode(); // create a root node

	public TreeNode insertKey(TreeNode root, char x) {
		TreeNode p = root; // get root node

		TreeNode newNode = new TreeNode(); // create a new node

		// initialize new node
		newNode.data = x;
		newNode.left = null;
		newNode.right = null;

		// Always reconnect to the BST with newNode
		// if root is empty
		if ( p == null ) {
			return newNode;
		} else if (newNode.data < p.data) {
			// if newNode is smaller than parent
			p.left = insertKey(p.left, x); // insertKey returns the newNode if p.left is null
			return p;
		} else if (newNode.data > p.data) {
			// if newNode is bigger than parent
			p.right = insertKey(p.right, x); // insertKey returns the newNode if p.right is null
			return p; 
		} else return p; 
	}

	public void insertBST(char x) {
		root = insertKey(root, x); // insert newNode which holds the value of x, and finally root node is returned to the variable 'root'
	}

	public TreeNode searchBST(char x) {
		TreeNode p = root;
		while ( p != null) {
			if (x < p.data) p = p.left;
			else if (x > p.data) p = p.right;
			else return p; // return the node which value is x.
		}
		return p; // Finally this value becomes null
	}

	public void inorder(TreeNode root) { // print BST by inorder
		if (root != null) {
			inorder(root.left);
			System.out.printf(" %c", root.data);
			inorder(root.right);
		}
	}

	public void printBST() {
		inorder(root);
		System.out.println();
	}
}

class BST {
	public static void main (String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insertBST('G');
		bst.insertBST('I');
		bst.insertBST('H');
		bst.insertBST('D');
		bst.insertBST('B');
		bst.insertBST('M');
		bst.insertBST('N');
		bst.insertBST('A');
		bst.insertBST('J');
		bst.insertBST('E');
		bst.insertBST('Q');

		System.out.printf("\nBinary Tree >>> ");
		bst.printBST();

		System.out.printf("Is There \"A\" ? >>> ");
		TreeNode p1 = bst.searchBST('A');
		if (p1 != null) {
			System.out.printf("Searching Success! Searched key : %c \n", p1.data);
		} else {
			System.out.printf("Searching Fail! There is no %c \n", 'A');
		}

		System.out.printf("Is There \"Z\" ? >>> ");
		TreeNode p2 = bst.searchBST('Z');
		if (p2 != null) {
			System.out.printf("Searching Success! Searched key : %c \n", p2.data);
		} else {
			System.out.printf("Searching Fail! There is no %c \n", 'Z');
		}
	}
} 
