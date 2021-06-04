import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxOfSlidingWindow {

	static ArrayList<Integer> findKMaxElement(int[] array, int k, int n) {

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		ArrayList<Integer> result = new ArrayList<>();

		if (k > n) {
			return null;
		}

		int i = 0;
		int leftPointer = i;
		for (; i < k; i++) {
			queue.add(array[i]);
		}
		result.add(queue.peek());
		queue.remove(array[leftPointer++]);

		while (i < n) {
			queue.add(array[i++]);
			result.add(queue.peek());
			queue.remove(leftPointer++);
		}
		return result;

	}

	// Driver Code
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int k = 3, n = arr.length;

		List<Integer> res = findKMaxElement(arr, k, n);
		for (int x : res)
			System.out.print(x + " ");
	}
}
