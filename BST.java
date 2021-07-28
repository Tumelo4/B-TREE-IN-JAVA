@SuppressWarnings("unchecked")
public class BST<T extends Comparable<? super T>> {
    
	protected BSTNode<T> root = null;
	protected static int count = 0;

	public BST() 
	{
    	}
    
	public void clear() 
	{
		root = null;
	}

	public String inorder(BSTNode<T> node) 
	{
		boolean verbose = true;
		if (node != null) {
			String result = "";
			result += inorder(node.left);
			if (verbose) {
				result += node.toString()+"\n";
			} else {
				result += node.element.toString() + " ";
			}
			result += inorder(node.right);
			return result;
		}
		return "";
	}


	public boolean isEmpty() 
	{
		//Your code goes here
		if(root == null)
			return true;
		
		return false;
	}

	public BSTNode<T> mirror() 
	{
		//Your code goes here
		BSTNode<T> node = mirror(root);
		
		return node;
	}

	public BSTNode<T> clone() 
	{
		//Your code goes here
		
		BSTNode<T> node = clone(root);
		
		return node;
	}

	public void printPreorder() 
	{
		//Your code goes here
		BSTNode<T> p = root;
		printPreorder(p);
		System.out.println();
	}

        public void printPostorder() 
	{
		//Your code goes here
		BSTNode<T> p = root;
		printPostorder(p);
		System.out.println();
	}

	public void insert(T element) 
	{
		//Your code goes here
		if(search(element) != null)
			return;
		
		BSTNode<T> node, iter = root;
		
		if(isEmpty()){
			root = new BSTNode<T>(element);
			return;
		}
		
		while(iter != null){
		
			if(element.compareTo(iter.element) < 0){
				if(iter.left != null){
					iter = iter.left;
				}else{
					iter.left = new BSTNode<T>(element);
					return;
				}
			}else if(element.compareTo(iter.element) > 0){
				if(iter.right != null){
					iter = iter.right;
				}else{
					iter.right = new BSTNode<T>(element);
					return;
				}
			}
		}
	}

	public boolean deleteByMerge(T element) 
	{
		//Your code goes here

		if (isEmpty() || search(element) == null)
			return false;

		BSTNode<T> temp, node, itr = root, prev = null;

		while (itr != null && !itr.element.equals(element)){
			prev = itr;

			if (element.compareTo(itr.element) < 0)
				itr = itr.left;
			else
				itr = itr.right;
		}

		node = itr;

		if (itr != null && element.equals(itr.element)){

			if (node.right == null) {
				node = node.left;
			}else if(node.left == null) {
				node = node.right;
			}else {
				temp = node.left;

				while (temp.right != null){
					temp = temp.right;
				}

				temp.right = node.right;
				node = node.left;
			}

			if (itr == root)
				root = node;
			else if (prev.left == itr)
				prev.left = node;
			else
				prev.right = node;
		}

		return true;
	}

	public boolean deleteByCopy(T element) 
	{
		//Your code goes here

		if (isEmpty() || search(element) == null)
			return false;

		BSTNode<T> node, itr = root, prev = null;

		while (itr != null && itr.element != element) {
			prev = itr;

			if (itr.element.compareTo(element) < 0)
				itr = itr.right;
			else
				itr = itr.left;
		}

//		node = new BSTNode<T>(itr.element);
		node = itr;

		if (itr != null && element.equals(itr.element)) {
			if (node.right == null)
				node = node.left;
			else if (node.left == null)
				node = node.right;
			else {

				BSTNode<T> tmp = node.left;
				BSTNode<T> previous = node;

				while (tmp.right != null) {
					previous = tmp;
					tmp = tmp.right;
				}
				node.element = tmp.element;

				if (previous == node)
					previous.left = tmp.left;
				else
					previous.right = tmp.left;
			}

			if (itr == root)
				root = node;
			else if (prev.left == itr)
				prev.left = node;
			else
				prev.right = node;
		}

		return true;
	}

	public T search(T element) 
	{
		//Your code goes here
		BSTNode<T> node = root;
		
		if(isEmpty())
			return null;
		
		while(node != null){
		
			if(element.compareTo(node.element) < 0){
				node = node.left;
			}else if(element.compareTo(node.element) > 0){
				node = node.right;
			}else{
				return node.element;
			}
		
		}
		
		return null;
	}

	
	//Helper functions
	public BSTNode<T> mirror(BSTNode<T>  oldNode){
		
		if(oldNode == null)
			return null;
		
		BSTNode<T> node = new BSTNode<T>(oldNode.element);
		
		node.right = mirror(oldNode.right);
		node.left = mirror(oldNode.left);
		
		oldNode = new BSTNode<T>(node.element, node.right, node.left);
		
		return oldNode;
	}	

	public BSTNode<T> clone(BSTNode<T>  oldNode){
		
		if(oldNode == null)
			return null;
		
		BSTNode<T> node = new BSTNode<T>(oldNode.element);
		
		node.right = clone(oldNode.right);
		node.left = clone(oldNode.left);

//		oldNode = new BSTNode<T>(node.element, node.left, node.right);
		
		return node;
	}	
	
	public void printPreorder(BSTNode<T> p){
		if(p != null){
			System.out.print(p.element + " ");
			printPreorder(p.left);
			printPreorder(p.right);
		}
	}	
	
	public void printPostorder(BSTNode<T> p){
		if(p != null){
			printPostorder(p.left);
			printPostorder(p.right);
			System.out.print(p.element + " ");
		}
	}

}