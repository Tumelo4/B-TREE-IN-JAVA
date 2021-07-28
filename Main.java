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
		//Practical 3

		
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
	
           
		/* Expected Output:
		8 5 12
		5 12 8
		8 12 5
		12 5 8
		Element 10 not found

		Binary Search Tree Content:
		3 [L: null]  [R: null]
		5 [L: 3]  [R: 7]
		7 [L: null]  [R: null]
		8 [L: 5]  [R: 12]
		10 [L: null]  [R: null]
		12 [L: 10]  [R: 14]
		14 [L: null]  [R: null]

		Found element 10
		Deleted element 8

		Binary Search Tree Content:
		3 [L: null]  [R: null]
		5 [L: 3]  [R: 7]
		7 [L: null]  [R: 12]
		10 [L: null]  [R: null]
		12 [L: 10]  [R: 14]
		14 [L: null]  [R: null]
		
		Deleted element 8

		Binary Search Tree Content:
		3 [L: null]  [R: null]
		5 [L: 3]  [R: null]
		7 [L: 5]  [R: 12]
		10 [L: null]  [R: null]
		12 [L: 10]  [R: 14]
		14 [L: null]  [R: null]


		Binary Search Tree Content:
		14 [L: null]  [R: null]
		12 [L: 14]  [R: 10]
		10 [L: null]  [R: null]
		7 [L: 12]  [R: null]
		5 [L: 7]  [R: 3]
		3 [L: null]  [R: null]


		*/
		
		// String sampleString = "01:20";
		// String[] stringArray = sampleString.split(":");
		// int[] intArray = new int[stringArray.length];
		
		// for(int i = 0; i < stringArray.length; i++){
		// 	String numberAsString = stringArray[i];
		// 	intArray[i] = Integer.parseInt(numberAsString);
		// }
		// int j;
		// for(j = 0; j < intArray.length; j++)
		// 	System.out.println(intArray[j]);
		
		// System.out.println(j);
		
	}
}
