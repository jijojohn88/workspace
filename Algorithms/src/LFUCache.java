import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/lfu-cache/
 * 
 * @author jjijo
 *
 */
public class LFUCache {

	public SortedMap<Integer, LinkedHashMap<Integer, Node>> countMap = new TreeMap<Integer, LinkedHashMap<Integer, Node>>();
	public Map<Integer, Node> cacheMap = new HashMap<Integer, Node>();
	public int leastFrequency = 0;
	public int capacity = 0;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		cacheMap = new HashMap<Integer, Node>();

	}

	public int get(int key) {

		int returnValue = -1;
		if (cacheMap.containsKey(key)) {
			Node node = cacheMap.get(key);
			LinkedHashMap<Integer, Node> internalMap = countMap.get(node.frequency);
			internalMap.remove(key);
			node.frequency = node.frequency + 1;
			internalMap = countMap.get(node.frequency);

			if (internalMap == null) {
				internalMap = new LinkedHashMap<>();
			}
			internalMap.put(key, node);
			countMap.put(node.frequency, internalMap);
			returnValue = node.value;
		}
		System.out.print(returnValue + ",");
		return returnValue;

	}

	public void put(int key, int value) {

		System.out.print("null,");

		if (capacity <= 0) {
			return;
		}

		if (capacity <= cacheMap.size() && !cacheMap.containsKey(key)) {

			Set<Integer> keys = countMap.keySet();
			leastFrequency = Integer.MAX_VALUE;
			for (int i : keys) {
				if (countMap.get(i) != null && countMap.get(i).size() > 0) {
					leastFrequency = Math.min(leastFrequency, i);
				}

			}

			HashMap<Integer, Node> internalMap = countMap.get(leastFrequency);
			Entry<Integer, Node> lastEntry = null;
			for (Entry<Integer, Node> entry : internalMap.entrySet()) {
				lastEntry = entry;
				break;
			}
			internalMap.remove(lastEntry.getKey());
			cacheMap.remove(lastEntry.getKey());
			System.out.print("[key-deleted-" + lastEntry.getKey() + "],");
		}

		if (cacheMap.containsKey(key)) {
			Node node = cacheMap.get(key);
			countMap.get(node.frequency).remove(key);
			node.frequency = node.frequency + 1;
			node.value = value;
			LinkedHashMap<Integer, Node> internalMap = countMap.get(node.frequency);
			if (internalMap == null) {
				internalMap = new LinkedHashMap<>();
			}
			internalMap.put(key, node);
			countMap.put(node.frequency, internalMap);
			cacheMap.put(key, node);
			leastFrequency = 1;
		} else {
			Node node = new Node();
			node.frequency = 1;
			node.key = key;
			node.value = value;
			cacheMap.put(key, node);
			LinkedHashMap<Integer, Node> internalMap = countMap.get(1);
			if (internalMap == null) {
				internalMap = new LinkedHashMap<>();
			}
			internalMap.put(key, node);
			countMap.put(1, internalMap);
		}

	}

	/**
	 * ["LFUCache", "put","put","get","put","get","get","put","get","get","get"]
	 * [[2],[1,1],[2,2], [1], [3,3], [2], [3], [4,4], [1], [3], [4]]
	 * 
	 * ["LFUCache","put","put","put","put","get"] [[2],[3,1],[2,1],[2,2],[4,4],[2]]
	 * 
	 * ["LFUCache","put","put","get","get","put","get","get","get"]
	 * [[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		cache.get(2);
		cache.get(3);
		cache.put(4, 4);
		cache.get(1);
		cache.get(3);
		cache.get(4);

		/*
		 * LFUCache cache = new LFUCache(2); cache.put(2, 1); cache.put(3, 2);
		 * cache.get(3); cache.get(2); cache.put(4, 3); cache.get(2); cache.get(3);
		 * cache.get(4);
		 */

	}
}

class Node {
	int frequency;
	int key;
	int value;
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
