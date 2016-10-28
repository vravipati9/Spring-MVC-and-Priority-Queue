package com.util;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class BinaryMaxHeap<T extends Comparable<T>> implements PriorityQueue<T> {
	
	private volatile T[] items;
	private int size;
	private static final int INITIAL_LENGTH = 10;

	public BinaryMaxHeap() {
		items = (T[])new Comparable[INITIAL_LENGTH];
		size = 0;
	}	

	public int size() {
		return size;
	}

	/*
	 * Insert new element at last position, and arrange 
	 * @see com.util.PriorityQueue#insert(java.lang.Comparable)
	 */
	public void insert(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (size >= items.length-1) {
			items = Arrays.copyOf(items, items.length * 2);
		}
		items[size] = element;
		size++;
		shiftElementsUp();
	}

	/*
	 * 
	 * popMax() retrieves root element from BinaryTree and replace it with leaf node 
	 * and then rearranges the Elements in HeapTree
	 */
	public T popMax() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		if (size == 1) {
			return items[0];
		}
		T rootElement = items[0];
		
		items[0] = items[--size];
		items[size] = null;
		shiftElementsDown();
		return rootElement;
	}

	/*
	 * Place newly added leaf element in correct position in binary tree, hence it 
	 * will fit in correct position
	 */
	private void shiftElementsUp() {
		int childElementIndex = size-1;
		while (childElementIndex > 0) {
			int parentElementIndex = (childElementIndex-1) / 2;	// get parent element index
			T child = items[childElementIndex];
			T parent = items[parentElementIndex];
			if (child.compareTo(parent) > 0) {
				// parent and child are not in correct position, need to swap
				items[childElementIndex] = parent;
				items[parentElementIndex] = child;
				childElementIndex = parentElementIndex;
			} else {
				break;
			}
		}
	}

	/*
	 * Arranges the elements in proper order because we replaced root node with leaf node
	 */
	private void shiftElementsDown() {
		int rootIndex = 0;
		int leftLeafIndex = 2*rootIndex+1;	// left leaf node
		while (leftLeafIndex < size) {
			int max = leftLeafIndex; 	// assume left node as max element
			int rightLeafIndex = leftLeafIndex+1;	// right leaf node
			if (rightLeafIndex < size) {	
				if (items[rightLeafIndex].compareTo(items[leftLeafIndex]) > 0) {	
					max++;	// identify max element in leaf nodes
				}
			}
			T parent = items[rootIndex];
			T child = items[max];
			if (parent.compareTo(child) < 0) {
				// parent element is less than leaf node, need to swap it
				T temp = items[rootIndex];
				items[rootIndex] = items[max];
				items[max] = temp;
				rootIndex = max;
				leftLeafIndex = 2*rootIndex+1;
			} else {
				break;
			}
		}
	}
}