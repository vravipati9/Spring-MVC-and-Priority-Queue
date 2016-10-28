import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.util.BinaryMaxHeap;

public class PrinterTest {

	@Mock
	BinaryMaxHeap<Integer> mockPriorityQueue;	
	PriorityQueuePrinter printerWithMockPriorityQueue;
	
	@Test
	public void test1(String s) {
		
	}
	@Test
	public void testSortedStringWithMock() {
		Mockito.when(mockPriorityQueue.size()).thenReturn(5);
		printerWithMockPriorityQueue.asSortedString(1,4,6,3,2);
		ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
		Mockito.verify(mockPriorityQueue, Mockito.times(5)).insert( argumentCaptor.capture() );
		Mockito.verify(mockPriorityQueue, Mockito.times(5)).popMax();
	}
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		printerWithMockPriorityQueue = new PriorityQueuePrinter(mockPriorityQueue);
	}
}
