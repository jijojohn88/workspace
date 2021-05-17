package com.toplogy.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Node {

	List<Integer> next = new ArrayList<>();
	int courseName;
	boolean seen = false;

	public Node(int course) {
		this.courseName = course;
	}

	public Node(int course, Integer next) {
		this.courseName = course;
		this.next.add(next);
	}

	public boolean containsNext(Integer node) {
		return this.next.contains(node);
	}
}

public class CourseProblem {

	Map<Integer, Node> courseMap = new HashMap<Integer, Node>();

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		Node head = null;

		for (int[] course : prerequisites) {
			Node destination = null;
			Node source = null;
			System.out.println("Source=" + course[1] + ", destination=" + course[0]);
			if (!courseMap.containsKey(course[0])) {
				destination = new Node(course[0]);
				courseMap.put(course[0], destination);
			} else {
				destination = courseMap.get(course[0]);
			}
			if (courseMap.containsKey(course[1])) {
				source = courseMap.get(course[1]);
				source.next.add(destination.courseName);
			} else {
				source = new Node(course[1], course[0]);
				courseMap.put(course[1], source);
			}
			if (head == null) {
				head = source;
			}
		}
		for (Entry<Integer, Node> entry : courseMap.entrySet()) {
			System.out.println("iterating = " + entry.getKey());
			if (!entry.getValue().seen && isCycleFound(entry.getValue())) {
				return false;
			}
		}
		return true;
	}

	public boolean isCycleFound(Node root) {
		if (root == null) {
			return false;
		} else if (root.seen) {
			return true;
		} else {
			root.seen = true;
		}
		System.out.println("root = " + root.courseName);
		for (Integer n : root.next) {
			System.out.println("neighbor - " + n + " root=" + root.courseName);
			return isCycleFound(courseMap.get(n));
		}
		return false;
	}

	public static void main(String[] args) {
		/**
		 * "20\n" + "[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]"
		 */
		int[][] course = new int[4][2];
		course[0] = new int[] { 1, 4 };
		course[1] = new int[] { 2, 4 };
		course[2] = new int[] { 3, 1 };
		course[3] = new int[] { 3, 2 };

		CourseProblem cp = new CourseProblem();
		boolean value = cp.canFinish(20, course);
		System.out.println(value);

	}
}
