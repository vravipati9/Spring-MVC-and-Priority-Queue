package com.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BinaryMaxHeapTest {

	PriorityQueue<Integer> priorityQueue = null;

	@Test
    public void testOneItemCollection() {
        priorityQueue.insert(12);
        assertEquals(1, priorityQueue.size());
    }
	
	@Test
	public void testNumberOfElementInHeap() {
		priorityQueue.insert(12);
		assertEquals(1, priorityQueue.size());
		priorityQueue.insert(15);
		assertEquals(2, priorityQueue.size());
		priorityQueue.insert(13);
		priorityQueue.insert(11);
		assertNotSame(5, priorityQueue.size());
	}
	
	@Test
	public void testRootElement() {
		createTestData();
		assertEquals(15, priorityQueue.popMax().intValue());
		priorityQueue.insert(19);
		assertEquals(19, priorityQueue.popMax().intValue());
	}
	
	@Test
	public void testDeleteRoot() {
		createTestData();
		priorityQueue.popMax();
		assertEquals(13, priorityQueue.popMax().intValue());
	}
	
	@Test
	public void testHeapWithMoreThan10Elements() {
		for (int i=1; i<=15; i++) {
			priorityQueue.insert(i);
		}
		assertEquals(15, priorityQueue.size());
	}
	
	@Test
    public void testEmptyHeap() {
        assertEquals(priorityQueue.size(), 0);
    }
	
    @Test(expected=NullPointerException.class)
    public void testIfInsertNullElement() {
        priorityQueue.insert(null);
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testRetrieveElementInEmptyHeap() {
        priorityQueue.popMax();
    }

    private void createTestData() {
    	priorityQueue.insert(12);
    	priorityQueue.insert(15);
    	priorityQueue.insert(13);
    	priorityQueue.insert(11);
    }
	@Before
	public void setUp() throws Exception {
		priorityQueue = new BinaryMaxHeap<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}
}
