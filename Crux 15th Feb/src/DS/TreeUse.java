package DS;

import java.util.Scanner;

public class TreeUse {
	
	public static TreeNode<Integer> takeTreeInput2() {
		QueueusingLL<TreeNode<Integer>> queue = new QueueusingLL<TreeNode<Integer>>();
		System.out.println("Enter root");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		
		queue.enqueue(root);
		
		while(!queue.isEmpty()) {
			TreeNode<Integer> currentNode;
			try {
				currentNode = queue.dequeue();
			} catch (QueueEmptyException e) {
				// Cant reach here
				return null;
			}
			System.out.println("Enter number of children of " + currentNode.data);
			int numChildren = s.nextInt();
			for (int i =0; i < numChildren; i++) {
				System.out.println("Enter data for " + i + "th child of " + currentNode.data);
				int childData = s.nextInt();
				TreeNode<Integer> child = new TreeNode<Integer>(childData);
				currentNode.children.add(child);
				queue.enqueue(child);
			}
		}
		return root;
		
	}
	
	public static TreeNode<Integer> takeTreeInput() {
		System.out.println("Enter root");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		System.out.println("Enter number of children of " + rootData);
		int numChildren = s.nextInt();
		
		for (int i =0; i< numChildren; i++) {
			TreeNode<Integer> child = takeTreeInput();
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String rootString = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			rootString = rootString + root.children.get(i).data + ",";
		}
		System.out.println(rootString);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	
	public static void printAtK(TreeNode<Integer> root, int k) {
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		for (int i =0; i < root.children.size(); i++) {
			System.out.println("Calling " + root.children.get(i).data + " with " + (k-1));
			printAtK(root.children.get(i), k-1);
		}
	}
	
	public static boolean sameStructure(TreeNode<Integer> root1,TreeNode<Integer> root2) {
		if (root1.data != root2.data)
			return false;
		if (root1.children.size() != root2.children.size())
			return false;
		
		for (int i =0; i < root1.children.size(); i++) {
			boolean currentChildrenSame = sameStructure(
					root1.children.get(i), root2.children.get(i));
			if (!currentChildrenSame) {
				return false;
			}
		}
		return true;	
	}
	
	
	public static void preorder(TreeNode<Integer> root) {
		System.out.print(root.data + " ");
		for (int i =0; i < root.children.size(); i++) {
			preorder(root.children.get(i));
		}
	}
	
	public static void postorder(TreeNode<Integer> root) {
		for (int i =0; i < root.children.size(); i++) {
			preorder(root.children.get(i));
		}
		System.out.print(root.data + " ");
	}
	
	
	public static int largestNode(TreeNode<Integer> root) {
		int max = root.data;
		
		for (int i =0; i < root.children.size(); i++) {
			int currentMax = largestNode(root.children.get(i));
			if (currentMax > max) 
				max = currentMax;
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = takeTreeInput2();
		//print(root);
		printAtK(root, 2);
		//System.out.println(largestNode(root));
	}

}
