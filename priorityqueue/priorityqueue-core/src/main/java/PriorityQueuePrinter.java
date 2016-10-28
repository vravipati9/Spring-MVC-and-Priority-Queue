import com.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class PriorityQueuePrinter implements Printer {

	@SuppressWarnings("rawtypes")
	private PriorityQueue priorityQueue = null;

	public <T extends Comparable<T>> PriorityQueuePrinter(PriorityQueue<T> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public <T extends Comparable<T>> String asSortedString(T... values) {
		addElements(values);
		return getSortedElements();
	}

	private <T extends Comparable<T>> void addElements(T... values) {
		for (T element : values) {
			priorityQueue.insert(element);
		}
	}

	private String getSortedElements() {
		StringBuilder sortedElements =  new StringBuilder();
		boolean isFirstElement = true;
		int queueSize = priorityQueue.size();
		for (int i = 0; i < queueSize; i++) {
			if (!isFirstElement) {
				sortedElements.append(",");
			}
			isFirstElement = false;
			sortedElements.append(priorityQueue.popMax());
		}
		return sortedElements.toString();
	}
}
