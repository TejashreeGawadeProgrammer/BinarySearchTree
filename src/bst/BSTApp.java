package bst;
class Node {
	Node left;
	Node right;
	int data;
}

class BST {
	
	// getMax value of Node
	public void getMax(Node node)
	{
		if(node == null)
		{
			System.out.println("Tree Is Null");
		}
		while(node.right != null)
		{
			node = node.right;
		}
		
		System.out.println("\nMaximum Node is :" +node.data );
	}
	
	// getMin value function
	public void getMin(Node node)
	{
		if(node == null)
		{
			System.out.println("\nTree Is Null");
		}
		while(node.left != null)
		{
			node = node.left;
		}
		System.out.println("\n Minimum value Node is :" +node.data);
	}
	
	//sibling of node
	public Node getSiblingNode(Node node, int val)
	{
		if(node == null)
		{
			return null;
		}
		
		Node parentNode = null;
		while(node != null)
		{
			if(val < node.data)
			{
				parentNode = node;
				node = node.left;
				
				if(val == parentNode.left.data)
				{
					return parentNode.right;
				}
			}else if(val > node.data)
			{
				parentNode = node;
				node = node.right;
				if(val == parentNode.right.data)
				{
					return parentNode.left;
				}
			}else
			{
				break;
			}
		}
		return null;
		
	}
	
	//getParent Node
	public Node getParentNode(Node node, int val)
	{
		if(node == null)
		{
			return null;
		}
		
		Node parentNode = null;
		while(node != null)
		{
			if(val < node.data)
			{
				parentNode = node;
				node = node.left;
			}
			else if(val > node.data)
			{
				parentNode = node;
				node = node.right;
			}
			else
			{
				break;
			}
		}
		return parentNode;
	}




	public void ifNodePresent(Node node, int searchval)
	{
		if(node == null)
		{
			System.out.println("Node is null");
		}		

		while(node != null)
		{
			if(searchval < node.data){
				node = node.left;
			}
			else if(searchval > node.data )
			{
				node = node.right;
			}
			else{
				System.out.println("Search Element is Present:-" + searchval);
				break;
			}
		}
		System.out.println("Search Element is not Present :-" + searchval);
	}



	public Node insert(Node node, int val) {
		if(node == null) {
			return createNewNode(val);
		}

		if(val < node.data) {
			node.left = insert(node.left, val);
		} else if((val > node.data)) {
			node.right = insert(node.right, val);
		}

		return node;
	}

	public Node createNewNode(int k) {
		Node a = new Node();
		a.data = k;
		a.left = null;
		a.right = null;
		return a;
	}
}

public class BSTApp {

	public static void main(String[] args) {
		BST a = new BST();
		Node root = null;

		root = a.insert(root, 8);
		root = a.insert(root, 3);
		root = a.insert(root, 6);
		root = a.insert(root, 10);
		root = a.insert(root, 4);
		root = a.insert(root, 7);
		root = a.insert(root, 1);
		root = a.insert(root, 14);
		root = a.insert(root, 13);
		
		//call get Parent Node fumction
		a.ifNodePresent(root, 16);
		
		Node parentNode = a.getParentNode(root, 7);
		if(parentNode != null)
		{
			System.out.println("Parent:-" +parentNode.data);
		}
		else
		{
			System.out.println("Parent is Null");
		}
		
		// call get sibling node function
		Node siblingNode = a.getSiblingNode(root, 13);
		if(siblingNode != null) {
			System.out.println("Sibling: " + siblingNode.data);
		} else {
			System.out.println("No Sibling");
				    }
		
		//call getmax function
		a.getMax(root);
		
		// call getMin dunction
		a.getMin(root);
	}

}