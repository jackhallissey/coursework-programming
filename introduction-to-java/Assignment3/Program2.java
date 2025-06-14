public class Program2 {
    public static void main(String[] args) {
		// Create the linked list
        LinkedList myList = new LinkedList();

		// Add the elements <11, 22, 6, 89, 99> to the linked list
		myList.add(11);
		myList.add(22);
		myList.add(6);
		myList.add(89);
		myList.add(99);

		// Print the linked list
		System.out.println(myList);

		// Add the number 50 in 3rd position of the linked list and print it
		myList.insert(2, 50);
		System.out.println(myList);

		// Remove the element in 2nd position of the linked list and print it
		myList.remove(1);
		System.out.println(myList);

		// Remove the element in 1st position of the linked list and print it
		myList.remove(0);
		System.out.println(myList);

		// Remove the element in last position of the linked list and print it
		myList.removeLast();
		System.out.println(myList);
    }
}

class LinkedList {
	// head and tail refer to dummy head and tail nodes that do not change
	private final LLNode head, tail;
	// Number of elements in the linked list
	private int size;
	
	// A LinkedList is comprised of LLNode objects
	private static class LLNode {
		// The integer elements that the node holds
		int element;
		// References to the nodes that come before and after the node in the linked list
		LLNode prev, next;
		
		// Constructor for LLNode
		public LLNode(int newElement) {
			this.element = newElement;
			this.prev = null;
			this.next = null;
		}
	}
	
	// Constructor for LinkedList
    public LinkedList() {
		// Create dummy head and tail nodes
		this.head = new LLNode(0);
		this.tail = new LLNode(0);

		// Set references of head and tail
		this.head.next = this.tail;
		this.tail.prev = this.head;

		// Initalise size
		this.size = 0;
	}

	private LLNode getNode(int pos) {
		// Throw an exception if the index is out of bounds
		if (pos > this.size - 1) {
			throw new ArithmeticException("Linked List index out of bounds.");
		}

		// Start at node at index 0
		LLNode node = this.head.next;

		// Go forward pos times to reach the node at index pos
		for (int i = 0; i < pos; i++) {
			node = node.next;
		}

		// Return the node at index pos
		return node;
	}
	
	private void addAfter(LLNode nodeBefore, int newElement) {
		// Get the node that will be after the new node in the linked list
		LLNode nodeAfter = nodeBefore.next;

		// Create the new node
		LLNode newNode = new LLNode(newElement);

		// Set references of the node
		newNode.prev = nodeBefore;
		newNode.next = nodeAfter;

		// Set references of the nodes before and after
		nodeBefore.next = newNode;
		nodeAfter.prev = newNode;

		// Increment size of linked list
		this.size++;
	}

	private int removeNode(LLNode node) {
		// Get the nodes that come before and after the node being removed
		LLNode nodeBefore = node.prev;
		LLNode nodeAfter = node.next;

		// Set the references of the nodes before and after
		nodeBefore.next = nodeAfter;
		nodeAfter.prev = nodeBefore;

		// Wipe the references of the node being removed
		node.prev = null;
		node.next = null;

		// Decrement size of linked list
		this.size--;

		// Return the element of the node removed
		return node.element;
	}

	public int get(int pos) {
		// Get the node at index pos and return its element
		return this.getNode(pos).element;
	}
	
	public void add(int newElement) {
		// Add a new node in last position (after the last proper node, before the tail)
		this.addAfter(this.tail.prev, newElement);
	}

	public void addFirst(int newElement) {
		// Add a new node in first position (after the head)
		this.addAfter(this.head, newElement);
	}

	public void insert(int pos, int newElement) {
		// Get the node at index pos - 1
		LLNode node = this.getNode(pos - 1);

		// Insert a new node after index pos-1 at index pos
		this.addAfter(node, newElement);
	}

	public int remove(int pos) {
		// Remove the node at index pos and return its element
		return this.removeNode(this.getNode(pos));
	}

	public int removeLast() {
		// Remove the node in last position (the proper node before the tail)
		return this.removeNode(this.tail.prev);
	}

	public int size() {
		// Return the size of the linked list
		return this.size;
	}

    @Override
	public String toString() {
		// Create an array to hold the elements of the linked list to be in the returned string
		String[] items = new String[this.size];

		// Start at the first proper node
		LLNode node = this.head.next;

		// Go through each node in the linked list and add a string representing its element to the array
		for (int i = 0; i < this.size; i++) {
			items[i] = String.valueOf(node.element);
			node = node.next;
		}

		// Add < to the beginning of the string, join the string elements together with a comma separating them, add > to the end
		return "<" + String.join(", ", items) + ">";
	}
}