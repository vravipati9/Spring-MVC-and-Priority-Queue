import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

import com.util.BinaryMaxHeap;
import com.util.PriorityQueue;

public class PrinterIntegrationTest {
	
	private PriorityQueue<Integer> priorityQueue = null;
	private Printer printer = null;
	
	@Test
	public void testSortedString() {
		String s = printer.asSortedString(1,4,6,3,2);
		assertEquals("6,4,3,2,1", s);
		assertNotSame("6,3,4,2,1", s);
	}
	
	@Test
	public void testHeapWithMoreThan10Elements() {
		String s = printer.asSortedString(1,4,6,3,2,12,19,29,27,3,30,35);
		assertEquals("35,30,29,27,19,12,6,4,3,3,2,1", s);
	}
	
	@Test(expected=NullPointerException.class)
	public void testSortedStringWithNull() {
		String s = printer.asSortedString(1,null,6,3,2);
		assertEquals("6,4,3,2,1", s);
	}
	
	@Before
	public void setUp() throws Exception {
		priorityQueue = new BinaryMaxHeap<Integer>();
		printer = new PriorityQueuePrinter(priorityQueue);
	}
	
}
