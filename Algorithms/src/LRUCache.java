
import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private Node<K, V> lruNode;
	private Node<K, V> mruNode;
	private Map<K, Node<K, V>> container;
	private int capacity;
	private int currentSize;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.currentSize = 0;
		lruNode = new Node<K, V>(null, null, null, null);
		mruNode = lruNode;
		container = new HashMap<K, Node<K, V>>();
	}

	public V get(K key) {
		Node<K, V> tempNode = container.get(key);
		if (tempNode == null) {
			return null;
		}
		// If MRU leave the list as it is
		else if (tempNode.key == mruNode.key) {
			return mruNode.value;
		}

		// Get the next and prev nodes
		Node<K, V> nextNode = tempNode.next;
		Node<K, V> prevNode = tempNode.prev;

		// If at the left-most, we update LRU
		if (tempNode.key == lruNode.key) {
			nextNode.prev = null;
			lruNode = nextNode;
		}

		// If we are in the middle, we need to update the items before and after our
		// item
		else if (tempNode.key != mruNode.key) {
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}

		// Finally move our item to the MRU
		tempNode.prev = mruNode;
		mruNode.next = tempNode;
		mruNode = tempNode;
		mruNode.next = null;

		return tempNode.value;

	}

	public void put(K key, V value) {
		if (container.containsKey(key)) {
			return;
		}

		// Put the new node at the right-most end of the linked-list
		Node<K, V> myNode = new Node<K, V>(mruNode, null, key, value);
		mruNode.next = myNode;
		container.put(key, myNode);
		mruNode = myNode;

		// Delete the left-most entry and update the LRU pointer
		if (currentSize == capacity) {
			container.remove(lruNode.key);
			lruNode = lruNode.next;
			lruNode.prev = null;
		}

		// Update container size, for the first added entry update the LRU pointer
		else if (currentSize < capacity) {
			if (currentSize == 0) {
				lruNode = myNode;
			}
			currentSize++;
		}
	}

	// Node for doubly linked list
	class Node<T, U> {
		T key;
		U value;
		Node<T, U> prev;
		Node<T, U> next;

		public Node(Node<T, U> prev, Node<T, U> next, T key, U value) {
			this.prev = prev;
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}

}