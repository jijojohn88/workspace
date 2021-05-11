package com.lab.exercise;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheNew<K, V> {

	private Node<K, V> lruNode;
	private Node<K, V> mruNode;
	private Map<K, Node<K, V>> container;
	private int capacity;
	private int currentSize;

	public LRUCacheNew(int capacity) {
		this.capacity = capacity;
		this.currentSize = 0;
		lruNode = new Node<K, V>(null, null, null, null);
		mruNode = lruNode;
		container = new HashMap<K, Node<K, V>>();
	}

	public void put(K key, V value) {

		Node<K, V> tempNode = container.get(key);

		if (tempNode != null) {
			if (mruNode.key != tempNode.key) {
				mruNode.next = tempNode;
				tempNode.next.prev = tempNode.prev;
				tempNode.prev.next = tempNode.next;
				tempNode.next = null;
			}
			return;
		}

		Node<K, V> node = new Node<K, V>(null, null, key, value);

		if (currentSize == 0) {
			lruNode = node;
			mruNode = node;
		} else if (currentSize < capacity && currentSize > 0) {
			mruNode.next = node;
			node.prev = mruNode;
			mruNode = node;
			currentSize++;
		} else if (currentSize == capacity) {

			mruNode.next = node;
			container.remove(key);
			node.prev = mruNode;
			mruNode = node;
			lruNode = lruNode.next;
			lruNode.prev = null;

		}

	}

	public V get(K key) {
		Node<K, V> tempNode = container.get(key);

		if (tempNode == null) {
			return null;
		} else if (mruNode.key == tempNode.key) {
			return tempNode.value;
		}

		else if (tempNode.key == lruNode.key) {
			lruNode = lruNode.next;
			lruNode.prev = null;

		} else {

			Node<K, V> nextNode = tempNode.next;
			Node<K, V> prevNode = tempNode.prev;

			nextNode.prev = prevNode;
			prevNode.next = nextNode;

		}
		mruNode.next = tempNode;
		tempNode.prev = mruNode;
		mruNode = tempNode;
		tempNode.next = null;
		return tempNode.value;

	}

	class Node<T, U> {
		T key;
		U value;

		Node<T, U> prev;
		Node<T, U> next;

		public Node(Node<T, U> prev, Node<T, U> next, T Key, U Value) {
			this.key = Key;
			this.value = Value;
			this.prev = prev;
			this.next = next;
		}
	}

}
