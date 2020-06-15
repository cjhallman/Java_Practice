import java.util.*;

public class Practice_BST{
	public static void main(String[] args){
		BinarySearchTree bst = BinarySearchTree.getInstance();
		bst.insert(40);
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(25);
		bst.insert(35);
		bst.insert(60);
		bst.insert(50);
		bst.insert(70);
		bst.print();
		LinkedList<Integer> ll = bst.ConvertToLinkedList();
		for(Integer i : ll){
			System.out.print(i + " ");
		}
		System.out.println(); 
	}

	static class BinarySearchTree{
		private static class Node{
			private int val;
			private Node left;
			private Node right;

			public Node(int pval){
				val = pval;
				left = null;
				right = null;
			}

			private boolean isLeaf(){
				return (left == null && right == null);
			}
		}

		private Node root;
		private static BinarySearchTree instance = new BinarySearchTree();


		private BinarySearchTree(){
			root = null;
		}

		public static BinarySearchTree getInstance(){
			return instance;
		}

		public LinkedList<Integer> ConvertToLinkedList(){
			LinkedList<Integer> ll = new LinkedList<Integer>();
			ll = ConvertToLinkedListRecursively(ll, root);
			return ll;
		}

		private LinkedList<Integer> ConvertToLinkedListRecursively(LinkedList<Integer> ll, Node proot){
			if(proot==null){
				return ll;
			}
			ConvertToLinkedListRecursively(ll, proot.left);
			ll.add(proot.val);
			ConvertToLinkedListRecursively(ll, proot.right);
			return ll;
		}


		public void insert(int pint){
			root = insertRecursively(root,pint);
		}

		private Node insertRecursively(Node proot, int pint){
			if(proot==null){
				return new Node(pint);
			}

			if(pint < proot.val)
				proot.left = insertRecursively(proot.left,pint);
			else if(pint > proot.val)
				proot.right = insertRecursively(proot.right,pint);

			return proot;
		}

		public int countLeaves(){
			return countLeavesRecursively(root);
		}

		private int countLeavesRecursively(Node proot){
			if(proot != null){
				if(proot.isLeaf()){
					return 1;
				}else{
					return countLeavesRecursively(proot.left) + countLeavesRecursively(proot.right);
				}		
			}else{
				return 0;
			}
		}

		public void printLeaves(){
			printLeavesRecursively(root);
			System.out.println();
		}

		private void printLeavesRecursively(Node proot){
			if(proot != null){
				if(proot.isLeaf()){
					System.out.print(proot.val + " ");
				}else{
					printLeavesRecursively(proot.left);
					printLeavesRecursively(proot.right);
				}		
			}
		}

		public int height(){
			return heightRecursively(root);
		}

		private int heightRecursively(Node proot){
			if(proot == null){
				return 0;
			}

			return 1 + Math.max(heightRecursively(proot.left),heightRecursively(proot.right));
		}

		public boolean search(int pint){
			return searchRecursively(root, pint);
		}

		private boolean searchRecursively(Node proot, int pint){
			if(proot == null){
				return false;
			}else if(proot.val == pint){
				return true;
			}else if(proot.val < pint){
				return searchRecursively(proot.right, pint);
			}else{
				return searchRecursively(proot.left, pint);
			}
		}

		public void print(){
			Queue<Node> nodeQueue = new LinkedList<Node>();
			nodeQueue.add(root);
			nodeQueue.add(null);
			Node cur = nodeQueue.remove();
			while(nodeQueue.size()!=0){
				if(cur != null){
					System.out.print(cur.val + " ");
					if(cur.left != null)
						nodeQueue.add(cur.left);
					if(cur.right != null)
						nodeQueue.add(cur.right);
				}else{
					System.out.println("");
					nodeQueue.add(null);
				}
				cur = nodeQueue.remove();
			}
			System.out.println("");
		}

		public void printInOrder(){
			printInOrderRecursively(root);
			System.out.println("");
		}

		public void printIteratively(){
			Stack<Node> s = new Stack<Node>();
			Node cur = root;
			while(cur != null || !s.empty()){
				if(cur != null){
					s.add(cur);
					cur = cur.left;
				}else{
					Node temp = s.pop();
					System.out.print(temp.val + " ");
					cur = temp.right;
				}
			}
			System.out.println("");
		}

		private void printInOrderRecursively(Node proot){
			if(proot == null){
				return;
			}
			printInOrderRecursively(proot.left);
			System.out.print(proot.val + " ");
			printInOrderRecursively(proot.right);
		}

		public void printByLayer(){
			PrintByLayerRecursively(root);
			System.out.println();
		}

		private void PrintByLayerRecursively(Node proot){
			if(proot == null){
				return;
			}
			PrintByLayerRecursively(proot.left);
			PrintByLayerRecursively(proot.right);
			System.out.print(proot.val + " ");
		}

		public void pringByLayerIteratively(){
			Stack<Node> s = new Stack<Node>();
			Stack<Node> sright = new Stack<Node>();
			Node cur = root;
			while(cur != null || !s.empty()){
				if(cur != null){
					s.add(cur);
					if(cur.right != null){
						sright.add(cur.right);
					}
					cur = cur.left;
				}else{
					Node temp = s.pop();
					System.out.print(temp.val + " ");
					if(!sright.empty() && temp.val < s.peek().val){
						cur = sright.pop();
					}
				}
			}
			System.out.println("");
		}
	}
}