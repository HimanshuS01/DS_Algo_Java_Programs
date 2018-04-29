package DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeUse {

	public static BinaryTreeNode<Integer> getTreeFromPreAndIn(
			int[] in, int[] pre, int inB, int inE, int preB, int preE) {
		if (inB > inE) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		root.data = pre[preB];
		int rootInOrderIndex = -1;
		for (int i = inB; i <= inE; i++) {
			if (in[i] == root.data) {
				rootInOrderIndex = i;
				break;
			}
		}

		if (rootInOrderIndex == -1) {
			// Throw an Exception
			return null;
		}

		int leftInOrderB = inB;
		int leftInorderE = rootInOrderIndex - 1;
		int rightInOrderB = rootInOrderIndex + 1;
		int rightInOrderE = inE;

		int leftLength = rootInOrderIndex - inB;
		int leftPreOrderB = preB + 1;
		int leftPreOrderE = leftPreOrderB + leftLength - 1;
		int rightPreOrderB = leftPreOrderE + 1;
		int rightPreOrderE = preE;

		//Left
		root.left = getTreeFromPreAndIn(in, pre, leftInOrderB, leftInorderE, leftPreOrderB, leftPreOrderE);

		//right
		root.right = getTreeFromPreAndIn(in, pre, rightInOrderB, rightInOrderE, rightPreOrderB, rightPreOrderE);

		return root;
	}

	public static BinaryTreeNode<Integer> getBinaryTreeInput() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		root.data = s.nextInt();
		QueueusingLL<BinaryTreeNode<Integer>> queue = 
				new QueueusingLL<BinaryTreeNode<Integer>>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> current;
			try {
				current = queue.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

			System.out.println("Enter left child of " + current.data);
			int left = s.nextInt();
			if (left != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>();
				leftNode.data = left;
				current.left = leftNode;
				queue.enqueue(leftNode);
			}

			System.out.println("Enter right child of " + current.data);
			int right = s.nextInt();
			if (right != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>();
				rightNode.data = right;
				current.right = rightNode;
				queue.enqueue(rightNode);
			}
		}
		return root;
	}

	public static int getHeight(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static DoubleInt diameterHeight(BinaryTreeNode<Integer> root) {
		if (root == null) {
			DoubleInt output = new DoubleInt();
			output.y = 0;
			output.x = 0;
			return output;
		}

		DoubleInt leftOutput = diameterHeight(root.left);
		DoubleInt rightOutput = diameterHeight(root.right);
		DoubleInt output = new DoubleInt();
		output.y = Math.max(leftOutput.x + rightOutput.x,
				Math.max(leftOutput.y, rightOutput.y));
		output.x = 1 + Math.max(leftOutput.x, rightOutput.x);
		return output;


	}

	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int height1, height2, diameter1, diameter2;
		diameter1 = diameter(root.left);
		diameter2 = diameter(root.right);
		height1 = getHeight(root.left);
		height2 = getHeight(root.right);
		return Math.max(height2 + height1, Math.max(diameter1, diameter2));
	}

	public static void printBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		String printString = root.data + ":";
		if (root.left != null) {
			printString += " left:" + root.left.data;
		}
		if (root.right != null) {
			printString += " right:" + root.right.data;
		}
		System.out.println(printString);

		printBinaryTree(root.left);
		printBinaryTree(root.right);
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		QueueusingLL<BinaryTreeNode<Integer>> queue = 
				new QueueusingLL<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> current;
			try {
				current = queue.dequeue();
			} catch (QueueEmptyException e) {
				return;
			}
			if (current.left != null) {
				queue.enqueue(current.left);
			}
			if (current.right != null) {
				queue.enqueue(current.right);
			}
			System.out.print(current.data + " ");
		}
	}

	public static void preOrder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public static BinaryTreeNode<Integer> findElement(BinaryTreeNode<Integer> root, int k) {
		if (root == null)
			return null;
		if (root.data == k)
			return root;
		else if (k >root.data) {
			return findElement(root.right, k);
		} else {
			return findElement(root.left, k);
		}
	}

	//Print Starting node from the left at each level
	//https://www.geeksforgeeks.org/print-left-view-binary-tree/
	public static void PrintLeftViewOfTree(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return;
		}
		QueueusingLL<BinaryTreeNode<Integer>> queue = new QueueusingLL<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		int count = 1;
		boolean isFirstNode = true;
		while (!queue.isEmpty())
		{
			BinaryTreeNode<Integer> current;
			try {
				current = queue.dequeue();
				count--;
			}
			catch (QueueEmptyException e)
			{
				return;
			}
			if(isFirstNode) {
				System.out.print(current.data + " ");
				isFirstNode = false;
			}
			if (current.left != null) {
				queue.enqueue(current.left);
			}

			if (current.right != null) {
				queue.enqueue(current.right);
			}
			if (count == 0) {
				System.out.println();
				isFirstNode = true;
				count = queue.size();
			}
		}
	}

	public static int maxLevel = 0;
	public static void LeftView(BinaryTreeNode<Integer> root,int level){

		if(root == null) {
			return;
		}
		if(maxLevel < level) {
			System.out.print(root.data + " ");
			maxLevel = level;
		}
		LeftView(root.left, level+1);
		LeftView(root.right, level+1);
	}

	public static int max_level = 0;
	public static void RightView(BinaryTreeNode<Integer> root,int level){

		if(root == null) {
			return;
		}
		if(max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}
		RightView(root.right, level+1);
		RightView(root.left, level+1);
	}

	//https://www.geeksforgeeks.org/bottom-view-binary-tree/
	public class pair{
		int data;
		int height;

		pair(int data,int height){
			this.data = data;
			this.height = height;
		}
	}

	public static void BottomView(BinaryTreeNode<Integer> root,int height,int hd,
			HashMap<Integer,BinaryTreeUse.pair> map) {

		if(root == null) {
			return;
		}
		BinaryTreeUse btu = new BinaryTreeUse();
		if(!map.containsKey(hd)) {
			map.put(hd,btu.new pair(root.data,height));
		}
		else {
			if(map.get(hd).height <= height) {
				map.put(hd, btu.new pair(root.data,height));
			}
		}
		BottomView(root.left, height+1, hd-1, map);
		BottomView(root.right, height+1, hd+1, map);
	}

	public static void BottomViewBinaryTree(BinaryTreeNode<Integer> root) {

		HashMap<Integer, pair> map = new HashMap<Integer, BinaryTreeUse.pair>();

		BottomView(root,0,0,map);

		for(int i : map.keySet()) {
			System.out.println(map.get(i).data);
		}

	}

	public static int findMin(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data, Math.min(findMin(root.left), findMin(root.right)));
	}

	public static int findMax(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
	}

	public static class IsBSTReturnNode {
		boolean isBST;
		int min;
		int max;
		int size;//this is only to find largest bst
	}

	public static IsBSTReturnNode isBSTFaster(BinaryTreeNode<Integer> root) {
		if (root == null) {
			IsBSTReturnNode output = new IsBSTReturnNode();
			output.isBST = true;
			output.min = Integer.MAX_VALUE;
			output.max = Integer.MIN_VALUE;
		}

		IsBSTReturnNode leftOutput = isBSTFaster(root.left);
		IsBSTReturnNode rightOutput = isBSTFaster(root.right);
		IsBSTReturnNode output = new IsBSTReturnNode();
		if (leftOutput.isBST && rightOutput.isBST && root.data > leftOutput.max && root.data < rightOutput.min) {
			output.isBST = true;
			// In case root.left was null and leftoutput.min is Integer.MAX_VALUE
			// We need to return root.data as min. 
			output.min = Math.min(leftOutput.min, root.data);
			output.max = Math.max(root.data, rightOutput.max);
		} else {
			output.isBST = false;
			// No need to set min max if the tree is not BST
		}

		return output;
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;

		if (root.data < findMax(root.left) || root.data > findMin(root.right)) {
			return false;
		}

		if (!isBST(root.left) || !isBST(root.right))
			return false;

		return true;
	}

    //Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.
	//https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/LargestBSTInBinaryTree.java
	public static IsBSTReturnNode LargestBST(BinaryTreeNode<Integer> root){
		
		if(root == null) {
			IsBSTReturnNode output = new IsBSTReturnNode();
			output.isBST = true;
			output.min = Integer.MAX_VALUE;
			output.max = Integer.MIN_VALUE;
			output.size = 0;
			return output;
		}
		
		IsBSTReturnNode leftOutput = LargestBST(root.left);
		IsBSTReturnNode rightOutput = LargestBST(root.right);
		
		IsBSTReturnNode out = new IsBSTReturnNode();

		if(leftOutput.isBST && rightOutput.isBST && leftOutput.max < root.data &&
				rightOutput.min > root.data) {
			out.isBST = true;
			out.size = leftOutput.size + rightOutput.size + 1;
			out.min = Math.min(leftOutput.min, root.data);
			out.max = Math.max(root.data, rightOutput.max);
		}
		else {
			out.isBST = false;
            out.size = Math.max(leftOutput.size, rightOutput.size);
		}	
		return out;

		
	}
	
	public static void printBetweenK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (root == null)
			return;

		if (root.data > k1 && root.data < k2) {
			System.out.println(root.data);
		}
		if (root.data >= k1)
			printBetweenK1K2(root.left, k1, k2);
		if (root.data <= k2)
			printBetweenK1K2(root.right, k1, k2);
	}

	public static void inOrder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	public static DoubleInt secondLargest(BinaryTreeNode<Integer> root) {

		if (root == null) {
			DoubleInt output = new DoubleInt();
			output.x = Integer.MIN_VALUE;
			output.y = Integer.MIN_VALUE;
			return output;
		}

		int largest = root.data;
		int secondLargest = Integer.MIN_VALUE;

		DoubleInt left = secondLargest(root.left);
		DoubleInt right = secondLargest(root.right);

		if (left.x > largest) {
			secondLargest = largest;
			largest = left.x;
		} else if (left.x > secondLargest) {
			secondLargest = left.x;
		} 

		if (left.y > secondLargest) {
			secondLargest = left.y;
		}

		if (right.x > largest) {
			secondLargest = largest;
			largest = right.x;
		} else if (right.x > secondLargest) {
			secondLargest = right.x;
		} 

		if (right.y > secondLargest) {
			secondLargest = right.y;
		}
		DoubleInt output = new DoubleInt();
		output.x = largest;
		output.y = secondLargest;


		return output;
	}

	//Question : Root to leaf sum Binary Tree : https://www.youtube.com/watch?v=Jg4E4KZstFE

	//Also do one question : Convert binary tree to a doubly link list.
	//https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
	public static Node<Integer> getSortedLinkedList(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}

		Node<Integer> currentnode = new Node<Integer>();
		currentnode.data = root.data;

		Node<Integer> leftHead = getSortedLinkedList(root.left);
		Node<Integer> rightHead = getSortedLinkedList(root.right);

		currentnode.next = rightHead;
		if (leftHead != null) {
			Node<Integer> tail = leftHead;
			while (tail.next != null) {
				tail = tail.next;
			}
			tail.next = currentnode;
			return leftHead;
		} else {
			return currentnode;
		}
	}

	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;

		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		}
		if (!isBalanced(root.left)) {
			return false;
		}
		if (!isBalanced(root.right)) {
			return false;
		}

		return true;
	}

	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return null;
		}
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;
	}

	public static void printLevelWiseNextLine2(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		QueueusingLL<BinaryTreeNode<Integer>> queue = new QueueusingLL<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		int currentLevelCount =1;
		int nextLevelCount = 0;

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> current;
			try {
				current = queue.dequeue();
				currentLevelCount--;
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			System.out.print(current.data + " ");
			if (current.left != null) {
				queue.enqueue(current.left);
				nextLevelCount++;
			}

			if (current.right != null) {
				nextLevelCount++;
				queue.enqueue(current.right);
			}

			if (currentLevelCount == 0) {
				System.out.println();
				currentLevelCount = nextLevelCount;
				nextLevelCount = 0;
			}
		}

	}

	public static void printLevelWiseNextLine1(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		QueueusingLL<BinaryTreeNode<Integer>> currentLevelQueue = new QueueusingLL<BinaryTreeNode<Integer>>();
		QueueusingLL<BinaryTreeNode<Integer>> nextLevelQueue = new QueueusingLL<BinaryTreeNode<Integer>>();
		currentLevelQueue.enqueue(root);

		while (!currentLevelQueue.isEmpty()) {
			BinaryTreeNode<Integer> current;
			try {
				current = currentLevelQueue.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			System.out.print(current.data + " ");
			if (current.left != null)
				nextLevelQueue.enqueue(current.left);

			if (current.right != null)
				nextLevelQueue.enqueue(current.right);

			if (currentLevelQueue.isEmpty()) {
				QueueusingLL<BinaryTreeNode<Integer>> swap = currentLevelQueue;
				currentLevelQueue = nextLevelQueue;
				nextLevelQueue = swap;
				System.out.println();
			}
		}

	}

	public static int SumOfLeafNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return root.data;
		}
		return SumOfLeafNodes(root.left) + SumOfLeafNodes(root.right);
	}

	public static void push_left_right(Stack<BinaryTreeNode<Integer>> currStack,Stack<BinaryTreeNode<Integer>> tempStack) {

		while(!currStack.isEmpty()) {
			BinaryTreeNode<Integer> currNode = currStack.pop();
			System.out.print(currNode.data);
			if(currNode.left != null) {
				tempStack.push(currNode.left);
			}
			if(currNode.right!=null) {
				tempStack.push(currNode.right);
			}
		}
	}

	public static void push_right_left(Stack<BinaryTreeNode<Integer>> currStack,Stack<BinaryTreeNode<Integer>> tempStack) {

		while(!currStack.isEmpty()) {
			BinaryTreeNode<Integer> currNode = currStack.pop();	
			System.out.print(currNode.data);
			if(currNode.right!=null) {
				tempStack.push(currNode.right);
			}
			if(currNode.left != null) {
				tempStack.push(currNode.left);
			}
		}

	}

	public static void ZigZagPrinting(BinaryTreeNode<Integer> root) {

		if(root == null ) {
			return ;
		}
		if(root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		Stack<BinaryTreeNode<Integer>> currStack = new Stack<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> tempStack = new Stack<BinaryTreeNode<Integer>>();

		int level = 1;
		currStack.push(root);

		while(!currStack.isEmpty()) {

			if(level % 2 != 0) {
				push_left_right(currStack,tempStack);
			}
			else {
				push_right_left(currStack,tempStack);
			}

			level++;
			Stack<BinaryTreeNode<Integer>> temp = currStack;
			currStack = tempStack;
			tempStack = temp;

		}

	}

	public static void PrinPathWithGivenHeight(BinaryTreeNode<Integer> root,int height,ArrayList<BinaryTreeNode<Integer>> path){

		//Do something like this
		//https://www.geeksforgeeks.org/print-paths-root-specified-sum-binary-tree/
		
		height = height-1;
		path.add(root);
		
		if(height == 0) {
			for(int i = 0 ; i < path.size() ; i++) {
				System.out.print(path.get(i).data+" ");
			}
			System.out.println();
		}
		if(root.left!=null) {
			PrinPathWithGivenHeight(root.left,height,path);
		}
		if(root.right!=null) {
			PrinPathWithGivenHeight(root.right,height,path);
		}
		path.remove(path.size()-1);
	}
	
	public static void PrinPathWithGivenHeightUtil(BinaryTreeNode<Integer> root){
		
		int height = getHeight(root);
		ArrayList<BinaryTreeNode<Integer>> path = new ArrayList<BinaryTreeNode<Integer>>();
		
		PrinPathWithGivenHeight(root,height,path);
		
	}
	
	
	//https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
	public class Values{
		int min;
		int max;
	}
	public static void FindMinMax(BinaryTreeNode<Integer> root,Values min,Values max,int hd) {
		if(root == null) {
			return;
		}
		if(hd < min.min) {
			min.min = hd;
		}
		else if(max.max < hd) {
			max.max = hd;
		}
		FindMinMax(root.left, min, max, hd-1);
		FindMinMax(root.right, min, max, hd+1);
	}		
	public static void PrintVerticalTree(BinaryTreeNode<Integer> root,int lineNo,int hd) {
		if(root == null) {
			return;
		}
		if(hd == lineNo) {
			System.out.print(root.data+" ");
		}
		PrintVerticalTree(root.left, lineNo, hd-1);
		PrintVerticalTree(root.right, lineNo, hd+1);
	}
	public static void PrintVerticalOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		BinaryTreeUse btu = new BinaryTreeUse();
		Values val = btu.new Values();
		FindMinMax(root, val, val, 0);

		for(int i = val.min ; i<= val.max ; i++) {
			PrintVerticalTree(root,i,0);
			System.out.println();
		}
	}


	//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	public static  ArrayList<Integer> path1 = new ArrayList<Integer>();
	public static  ArrayList<Integer> path2 = new ArrayList<Integer>();

	public static void PrintLCA(BinaryTreeNode<Integer> root,int n1,int n2) {

		if(!findPath(root,n1,path1) || !findPath(root,n2,path2)) {
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
			System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
		}
		int i;
		for(i = 0; i < path1.size() && i< path2.size() ; i++) {
			if(path1.get(i) != path2.get(i)) {
				break;
			}
		}
		System.out.println(path1.get(i-1));
	}

	public static boolean findPath(BinaryTreeNode<Integer> root,int n,ArrayList<Integer> path) {
		if(root == null) {
			return false;
		}

		path.add(root.data);

		if(root.data == n) {
			return true;
		}

		if(root.left != null && findPath(root.left, n, path)) {
			return true;
		}
		if(root.right != null && findPath(root.right, n, path)) {
			return true;
		}
		path.remove(path.size()-1);
		return false;

	}

	public static  void FindLCA_BinaryTree(BinaryTreeNode<Integer> root,int n1,int n2) {
		PrintLCA(root,n1,n2);
	}

	//Method 2 for finding the LCA in a binary tree using Single Traversal
	public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> node, int n1, int n2)
	{
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.data == n1 || node.data == n2)
			return node;

		BinaryTreeNode<Integer> left_lca = findLCA(node.left, n1, n2);
		BinaryTreeNode<Integer> right_lca = findLCA(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca!=null && right_lca!=null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	//Write the program to find LCA in a binary search tree : https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/


	//Program to check if one binary tree is a subtree of another tree
	//https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

	//This method is present in Gayle's Laakmann CCI . Time Complexity is O(M nodes + N nodes) and Space:O(M+N)
	public static boolean isSubtree(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2) {

		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();

		getOrderString(root1,str1);
		getOrderString(root2,str2);
		return str1.indexOf(str2.toString()) != -1;
	}

	public static void getOrderString(BinaryTreeNode<Integer> root,StringBuilder str) {

		if(root == null) {
			str.append("X");
			return;
		}
		str.append(root.data + " ");
		getOrderString(root.left, str);
		getOrderString(root.right, str);
	}

	//This is a quite tricky method for connecting the nodes at the same level using Constant Space
	//https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/

	//This is a level order traversal using Queue Space
	//https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/

	/*
	 * Using below concept we can also find the next right node of a given key in a tree
	 * See : https://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
	 */

	public static BinaryTreeNode<Integer> ConnectNodesAtSameLevel(BinaryTreeNode<Integer> root){

		if(root == null) {
			return root;
		}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		q.add(null);

		while(!q.isEmpty()) {

			BinaryTreeNode<Integer> p = q.peek();
			q.remove();
			if(p != null) {
				p.nextRight = q.peek();

				if(p.left != null) {
					q.add(p.left);
				}
				if(p.right != null) {
					q.add(p.right);
				}
			}
			else if(!q.isEmpty()) {
				q.add(null);
			}

		}

		return root;
	}

	//This function is for printing connected nodes at the same level
	public static void PrintTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return ;
		}

		BinaryTreeNode<Integer> tempRoot = root;
		while(tempRoot!=null) {
			System.out.print(tempRoot.data);
			tempRoot = tempRoot.nextRight;
		}
		System.out.println();
		if(root.left != null) {
			PrintTree(root.left);
		}
		else {
			PrintTree(root.right);
		}
	}


	public class Pair1{
		int max;
		BinaryTreeNode<Integer> targetLeaf;	
		public Pair1() {
			max = Integer.MIN_VALUE;
			targetLeaf = null;
		}
	}

	public static void MaxSumLeafToRootPath(BinaryTreeNode<Integer> root,Pair1 p,int sum) {

		if(root == null) {
			return;
		}

		sum = sum + root.data;

		if(root.left == null && root.right == null) {
			if(sum > p.max) {
				p.max = sum;
				p.targetLeaf = root;
			}
		}
		MaxSumLeafToRootPath(root.left, p, sum);
		MaxSumLeafToRootPath(root.right, p, sum);
	}

	public static boolean PrintPath_MaxSumLeafToRootPath(BinaryTreeNode<Integer> root,Pair1 p) {

		if(root == null) {
			return false;
		}

		if(root == p.targetLeaf || PrintPath_MaxSumLeafToRootPath(root.left,p)
				|| PrintPath_MaxSumLeafToRootPath(root.right, p)) {
			System.out.print(root.data+" ");
			return true;
		}
		System.out.println("Maximum sum from leaf to root is:"+p.max);
		return false;
	}

	public static void MaxSumLeafToRootPathUtil(BinaryTreeNode<Integer> root){

		BinaryTreeUse btu = new BinaryTreeUse();
		Pair1 p = btu.new Pair1();

		MaxSumLeafToRootPath(root,p,0);
		PrintPath_MaxSumLeafToRootPath(root,p);

	}

	public static void main(String[] args) {

		int[] in = {4,2,5,1,6,3,7};
		int[] pre = {1,2,4,5,3,6,7};


		BinaryTreeNode<Integer> root1 = getBinaryTreeInput();

		System.out.println(LargestBST(root1).size);
		
//		PrinPathWithGivenHeightUtil(root1);

		//Max leaf to root path printing
		//		MaxSumLeafToRootPathUtil(root1);

		//Connect nodes at the same level
		//		PrintTree(ConnectNodesAtSameLevel(root1));

		//		BinaryTreeNode<Integer> root2 = getBinaryTreeInput();
		//		System.out.println(isSubtree(root1, root2));
		//		System.out.println(findLCA(root1, 4, 7).data);
		//		FindLCA_BinaryTree(root1, 4, 5);
		//		BottomViewBinaryTree(root1);
		//		System.out.println("LeftView");
		//		LeftView(root1, 1);
		//		System.out.println("RightView");
		//		RightView(root1, 1);
		//		PrintLeftViewOfTree(root1);
		//		System.out.println("Print Vertical Order tree");
		//		PrintVerticalOrder(root1);
		//		System.out.println("Sum"+SumOfLeafNodes(root1));
		//		ZigZagPrinting(root1);
		//		BinaryTreeNode<Integer> root= getTreeFromPreAndIn(in, pre, 0, in.length - 1,
		//				0, pre.length - 1);
		//		System.out.println(isBalanced(root));
		//
		//		printLevelWiseNextLine2(root);

		// TODO Auto-generated method stub
		//		
		//		BinaryTreeNode<Integer> root = getBinaryTreeInput();
		//		printLevelWise(root);
	}

}
