package com.hyend.data.storage.structures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hyend.data.storage.arrays.matrix.MatrixRotation;
import com.hyend.data.storage.search.BinarySearch;
import com.hyend.data.storage.search.LinearSearch;
import com.hyend.data.storage.search.SubstringSearch;
import com.hyend.data.storage.search.SearchFromUnsortedArray;
import com.hyend.data.storage.sort.HeapSort;
import com.hyend.data.storage.sort.InsertionSort;
import com.hyend.data.storage.sort.MergeSort;
import com.hyend.data.storage.sort.QuickSort;
import com.hyend.data.storage.sort.SelectionSort;
import com.hyend.data.storage.sort.ShellSort;
import com.hyend.data.storage.structures.graphs.UndirectedGraph;
import com.hyend.data.storage.structures.hashtable.MyHashTable;
import com.hyend.data.storage.structures.linkedlists.DoublyLinkedList;
import com.hyend.data.storage.structures.linkedlists.LinkedListStack;
import com.hyend.data.storage.structures.linkedlists.LinkedListWithStackAndQueue;
import com.hyend.data.storage.structures.linkedlists.MyLinkedList;
import com.hyend.data.storage.structures.trees.BinarySearchTree.BinarySearchTree;
import com.hyend.data.storage.structures.trees.SelfBalancedBST.RedBlackBST;
import com.hyend.data.storage.structures.trees.SelfBalancedBST.SelfBalancedBSTres;
import com.hyend.data.storage.structures.trie.TernaryTrieDictionary;
import com.hyend.data.storage.structures.trie.TrieDictionary;
import com.hyend.data.storage.structures.trie.TrieDictionary.Node;
import com.hyend.logical.algorithms.FindKthElement;
import com.hyend.logical.algorithms.StackWithMin;
import com.hyend.logical.algorithms.dp.Fibonacci;
import com.hyend.logical.algorithms.dp.FindLargestSquareInMatrix;
import com.hyend.logical.algorithms.recursive.Staircase;
import com.hyend.logical.algorithms.recursive.StudentAttendance;
import com.hyend.logical.algorithms.strings.FindFirstUniqueChar;
import com.hyend.logical.algorithms.strings.HasStringAllUniqueChars;
import com.hyend.logical.algorithms.strings.Palindromicity;
import com.hyend.logical.algorithms.strings.RemoveDuplicatesFromString;
import com.hyend.logical.algorithms.AmountInWords;

class TestDataStructure<K> {

	public static void main(String args[]) {	
				
		PrintMSG("\nThe Value Is : ¥" + new AmountInWords().translateMoney(6600));
		int[] arr = {6,3,2,1,5,4,9,7,10,8};
		int[] sortedArr = {11,17,30,47,55,69,72,88,96,101};
		int[] arr1 = {2, 3, 6, 7, 9};
		int[] arr2 = {1, 4, 8, 10};
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		//System.out.println(arr.length);
		/*SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(arr);*/
		/*InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(arr);*/
		/*ShellSort shellSort = new ShellSort();
		shellSort.sort(arr);*/
		//MergeSort mergeSort = new MergeSort();
		//mergeSort.sort(arr);
		//QuickSort quickSort = new QuickSort();
		//quickSort.sort(arr, 0, arr.length-1);
		/*HeapSort heapSort = new HeapSort();
		heapSort.sort(arr);
		for(int x: arr) {
			System.out.println(x);
		}*/
		//System.out.println("Found at " + new BinarySearch().recursiveSearch(sortedArr, 0, arr.length-1, 96) + " position");
		//System.out.println(new RecursiveBinarySearch().searchWithLessCompares(sortedArr, 0, arr.length, 11));
		//System.out.println(new RecursiveLinearSearch().search(arr, 0, arr.length-1, 1));
		//System.out.println(new SearchFromUnsortedArray().search(arr, 0, arr.length-1, 12));
		//System.out.println(new RecursiveSubstringSearch("geeksforgeeks".toCharArray(), "forgeeks".toCharArray());
		//System.out.println(new FindKthElement().find(arr1, arr2, arr1.length-1, arr2.length-1, 5));
		//System.out.println(new FindKthElement().findKth(arr1, arr1.length, arr2, arr2.length, 5));
		//System.out.println("Fibonacci Number At 6th Position is : " + new Fibonacci().findFib(8));
		/*int[] fib = new int[9];
		System.out.println("Fibonacci Number At 6th Position is : " + new Fibonacci().findFib(8, fib));*/		
		/*int[] fib = new Fibonacci(10).recursive();
		for(int i : fib) {
			System.out.println(i);
		}*/
		//System.out.println("There're "+ new Staircase(4).numberOfWays(4, null) + " ways to climb 4 steps of staricase.");
		//int[] range = new int[3];
		//range[0] = 1; range[1] = 3; range[2] = 5;
		//System.out.println("There're "+ new Staircase().numOfWaysWithInRange(8, range) + " ways to climb 5 steps of staricase.");
		//System.out.println(new StudentAttendance().waysToGetPenalty(6));
		//System.out.println(new StudentAttendance().getTotalWaysOfPenalty(6));
		//TestStack();
		//TestQueue();
		//TestSinglyLinkedList();
		//TestDoubleyLinkedList();
		//TestQueueFromStack();
		//TestBinaryTree();
		//TestBalacedBSTree();
		//TestHashTable();
		//
		//new RemoveDuplicatesFromString().removeDuplicates("abcde".toCharArray());
		//new Fibonacci().recursive(10);
		//System.out.println(mid);
		//System.out.println(new StringHasUniqueChars().areAllCharsUnique("system"));
		//System.out.println("Largest Square = " + new FindLargestSquare().findLargestSquare());
		
		/*try {
			String dt = "29-12-2018, 09:16 PM";
			String dt2 = "29-10-2018";
			String[] dts = dt.split(", ");
			System.out.println(dts[0]);
			System.out.println(dts[1]);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = dateFormat.parse(dts[0]);
			Date date2 = dateFormat.parse(dt2);
			System.out.println(date2.before(date));
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			String outputString = sdf2.format(date);			
		} catch (ParseException e) {
			// TODO: handle exception
		}*/	
		//System.out.println();
		//System.out.println(new PalindromeString().canItBeAPalindrome("geeksogeeks"));
		
		//TestBinarySearchTree();
		//TestGraphStructure();
		TestTrieDictionary();
		//TestSinglyLinkedList();
	}
	
	private static void TestStackWithMin() {
		StackWithMin minStack = new StackWithMin();
		minStack.push(10);
		minStack.push(22);
		minStack.push(3);
		minStack.push(41);
		minStack.push(15);
		minStack.push(69);
		minStack.push(47);
		minStack.push(38);
		minStack.push(9);
		minStack.push(1);
		minStack.push(17);
		minStack.push(52);
		minStack.push(22);
		PrintMSG("Popping = " + minStack.pop());
		PrintMSG("Minimum val = " + minStack.getMin());
	}
	
	private static void TestSinglyLinkedList() {
		MyLinkedList<String> lList = new MyLinkedList<String>();
		lList.add("One");
		lList.add("Two");
		lList.add("Three");
		lList.add("Four");
		lList.add("Five");
		/*lList.add("Five");
		lList.add("Six");
		lList.add("Seven");
		lList.add("Eight");
		lList.add("Eight");
		lList.add("Nine");
		lList.add("Ten");*/		
		MyLinkedList.Node<String> node = lList.reverse();		
		Iterator<String> items = lList.iterator();
		while(items.hasNext()) {
			PrintMSG(items.next());
			ArrayList<Integer> al = new ArrayList<>();
			al.remove(al.size());
		}
		
		//PrintMSG("Total Size = " + lList.size());
		/*Iterator<String> nodes = lList.reverseKGroups(3).iterator();				
		while(nodes.hasNext()) {
			PrintMSG(nodes.next());			
		}*/
		/*MyLinkedList.Node<String> nodes = lList.reverseKGroups(2);
		while(nodes.next != null) {
			PrintMSG(nodes.item);
			nodes = nodes.next;
		}*/
		
		//lList.removeAllDuplicates();
		//PrintMSG("Item Deleted = " + lList.delete("Two"));
		/*Iterator<String> items = lList.iterator(); 
		while(items.hasNext()) {
			PrintMSG(items.next());
		}*/		
		//lList.printAllNodes();
	}
	
	private static void TestDoubleyLinkedList() {
		DoublyLinkedList dblList = new DoublyLinkedList();
		dblList.put("One");
		dblList.put("Two");
		dblList.put("Three");
		dblList.put("Four");
		dblList.put("Five");
		dblList.put("Six");
		dblList.put("Seven");
		dblList.put("Eight");
		dblList.put("Nine");
		dblList.put("Ten");
		System.out.println("Length = " + dblList.getLength());
		dblList.printAllNodesInReverse();
		//dblList.reorderLinkedList();
		//dblList.printAllNodes();
	}
	
	private static void TestStack() {
	
		LinkedListStack myStack = new LinkedListStack();
		myStack.push("One");
		myStack.push("Two");
		PrintMSG(myStack.pop());
		myStack.push("Three");
		myStack.push("Four");
		PrintMSG(myStack.pop());
		myStack.push("Five");
		PrintMSG(myStack.pop());
		PrintMSG(myStack.pop());
		//PrintMSG(myStack.isEmpty());
		PrintMSG(myStack.pop());
		//PrintMSG(myStack.isEmpty());
	}
	
	private static void TestQueueFromStack() {
		LinkedListWithStackAndQueue queue = new LinkedListWithStackAndQueue();
		queue.pushOrEnqueue("One");
		queue.pushOrEnqueue("Two");
		queue.pushOrEnqueue("Three");
		queue.pushOrEnqueue("Four");
		queue.pushOrEnqueue("Five");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.pushOrEnqueue("Six");
		queue.pushOrEnqueue("Seven");
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.pushOrEnqueue("Eight");
		queue.pushOrEnqueue("Nine");
		System.out.println(queue.dequeue());
		queue.pushOrEnqueue("Ten");
		System.out.println(queue.pop());
	}
	
	private static void TestBalacedBSTree() {
					
		SelfBalancedBSTres<Character, String> bt = new SelfBalancedBSTres<Character, String>();		
	    bt.put('S', "Hexa");
	    bt.put('E', "Quadra");
	    bt.put('A', "Octa");
	    bt.put('R', "Tri");
	    bt.put('C', "Penta");
	    bt.put('H', "Seven");
	    bt.put('X', "Nine");
	    bt.put('M', "Deca");
	    bt.put('P', "Uno");
	    bt.put('L', "Duo");
	    	    
	    //PrintMSG("Tree Size = " + bt.size());
	    //PrintMSG("Value For R = " + bt.find('R'));	    
	    bt.printAllNodesInOrder();
	    //bt.delete('L');
	    //bt.printAllNodesLevelOrder();
	    //bt.printAllNodesDiagonally();
		/*RedBlackBST<Character, String> bt = new RedBlackBST<>();
		bt.put('S', "Hexa");
	    bt.put('E', "Quadra");
	    bt.put('A', "Octa");
	    bt.put('R', "Tri");
	    bt.put('C', "Penta");
	    bt.put('H', "Seven");
	    bt.put('X', "Nine");
	    bt.put('M', "Deca");
	    bt.put('P', "Uno");
	    bt.put('L', "Duo");
	    bt.printAllNodesInOrder();*/
	}
	
	private static void TestHashTable() {
		MyHashTable<String, String> hashTable = new MyHashTable<>();
		hashTable.put("apple", "17.172.224.47");
		hashTable.put("amazon", "176.32.98.166");
		hashTable.put("facebook", "31.13.95.36");
		hashTable.put("google", "172.217.25.110");		
		hashTable.put("microsoft", "40.112.72.205");				
		PrintMSG("Value for google = " + hashTable.get("apple"));
	}
	
	private static void TestGraphStructure() {
		int[][] graph = {{0, 5}, {4, 3}, {0, 1}, {9, 12}, {6, 4},
						 {5, 4}, {0, 2}, {11, 12}, {9, 10}, {0, 6},
						 {7, 8}, {9, 11}, {5, 3}, {2, 6, 4}};
		UndirectedGraph uGraph = new UndirectedGraph(graph, UndirectedGraph.ADJACENCY_LIST);
		PrintMSG("Total Number of Vertices = " + uGraph.getTotalVertices());
		PrintMSG("Total Number of Edges = " + uGraph.getTotalEdges(UndirectedGraph.ADJACENCY_LIST)/2);
		int source = 2;
		int vertex = 4;
		int destination = 5;
		//uGraph.dfsPath(source);
		uGraph.bfsPath(source);
		
		if(uGraph.hasPathTo(destination)) {
			
			Iterator<Integer> path = uGraph.pathTo(destination, source).iterator();
			PrintMSG("\n");
			while(path.hasNext()) {
				System.out.print("" + path.next() + "->");
			}
		}
		PrintMSG("\n\nIs There A Path Between " + source + " to " + destination + " = " + uGraph.hasPathTo(destination));
		//PrintMSG("\nTotal Number of Vertices Connected to " + vertex + " = " + uGraph.getDFSCount());
		
		//DirectedGraph diGraph = new DirectedGraph(graph);
		//DirectedGraph.DirectedTraversals dfs = diGraph.new DirectedTraversals();
		//dfs.dfs(0);
	}
	
	private static <E> void TestTrieDictionary() {
		
		TrieDictionary<String> trieDict = new TrieDictionary<>();
		trieDict.put("Asuka", "a");
		trieDict.put("Kiaan", "b");
		trieDict.put("Keshav", "c");
		trieDict.put("Kush", "d");
		trieDict.put("Kia", "e");
		trieDict.put("Tulsi", "f");		
		trieDict.put("Karan", "g");
		trieDict.put("Kunal", "h");
		trieDict.put("Kiran", "i");
		trieDict.put("Kabir", "j");
		
		/*Iterator<TrieDictionary<String>.Node<String>> itr = trieDict.keysWithPrefix("As").iterator(); 
		while(itr.hasNext())
			PrintMSG("Total Keys = " + itr.next().prefix);*/			
		
		/*trieDict.putChunks("googleishiring", "google");
		trieDict.putChunks("shesellsseashells", "shore");
		trieDict.putChunks("godhelpmeforinterview", "god");
		trieDict.putChunks("appletisnothiring", "apple");
		trieDict.putChunks("appleisnothiring", "apple");*/
		
		//PrintMSG("Longest Prefix = " + trieDict.longestCommonPrefixOf("Kiaaan"));		
		//PrintMSG("Count = " + trieDict.allDistinctSubstrings("ababa"));
		/*Iterator<String> itr = trieDict.substringMatch("interview").iterator();
		while(itr.hasNext()) 
			PrintMSG("Substrings Are = " + itr.next());*/
		/*String key = "cgcgggcgcg";
		int length = key.length();
		int index = 0, n = 3;
		while(index < (length-n)) {
			trieDict.put(key.substring(index, index + n), (""+index));
			index+=1;
		}*/
		//PrintMSG("Unique Substrings = " + trieDict.uniqueNSubstrings("cgcgggcgcg", 3));
		//PrintMSG("Unique Substrings = " + trieDict.longestSubStringWithKDistinctChars("abcxaabbcyabcz", 3));
		
		//TrieDictionary<String> trieDict = new TrieDictionary<>();		
		/*Iterator<TrieDictionary<String>.Node<String>> iterator = trieDict.keysWithPrefix("an").iterator();						
		while(iterator.hasNext()) {
			TrieDictionary<String>.Node<String> node = iterator.next();
			PrintMSG(""+ node.prefix + " and value = " + node.value);
		}*/		
	}
	
	private static void PrintMSG(Object msg) {
		System.out.println(msg);
	}
}
