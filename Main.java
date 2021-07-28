public class Main
{
	public static void searchElement(BST<Integer> tree, Integer element)
	{
		if (tree.isEmpty())
			System.out.println("Tree is empty");
		else
		{
			Integer result = tree.search(element);
			if (result != null)
				System.out.println("Found element " + result);
			else
				System.out.println("Element " + element + " not found");	
		}
	}

	public static void deleteElement(BST<Integer> tree, Integer element, String type)
	{
		if (tree.isEmpty())
			System.out.println("Tree is empty");
		else
		{
			boolean result = false;
			if (type.trim().equals("m"))
				result = tree.deleteByMerge(element);
			else if (type.equals("c"))
				result = tree.deleteByCopy(element);

			if (result)
				System.out.println("Deleted element " + element);
			else
				System.out.println("Element " + element + " not found for deletion");	
		}
	}

	public static void printTree(BST<Integer> tree, int method) 
	{ 
    		switch (method) 
		{
			case 0: //verbose
				String result;
				System.out.println();
				System.out.println("Binary Search Tree Content:"); 
	    			result = tree.inorder(tree.root);
				System.out.println(result);
				break;
			case 1: //preorder
				tree.printPreorder();
				break;
			case 2: //postorder
				tree.printPostorder();
		}
	}

	public static void main(String[] args)
	{
		

		
		BST<Integer> tree = new BST<Integer>();
		
		tree.insert(8);

		tree.insert(5);

		tree.insert(12);

		printTree(tree, 1);

		printTree(tree, 2);

		BST<Integer> mirror = new BST<Integer>();
		mirror.root = tree.mirror();
		printTree(mirror, 1);
		printTree(mirror, 2);
		
		searchElement(tree, 10);

		tree.insert(14);

		tree.insert(7);

		tree.insert(10);

		tree.insert(3);

		printTree(tree, 0);

		searchElement(tree, 10);

		BST<Integer> clone = new BST<Integer>();
		clone.root = tree.clone();

		deleteElement(tree, 8, "m");

		printTree(tree, 0);

		deleteElement(clone, 8, "c");

		printTree(clone, 0);

		mirror.root = tree.mirror();

		printTree(mirror, 0);
		
	}
}
