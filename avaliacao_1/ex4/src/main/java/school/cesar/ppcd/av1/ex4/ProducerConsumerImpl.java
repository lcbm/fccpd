package school.cesar.ppcd.av1.ex4;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerImpl implements ProducerConsumer {
	private static Queue<SomeRequest> queue = new LinkedList<SomeRequest>();;
	private static final int maxSize = 2;

	public void produce(SomeRequest request) {
		synchronized (queue) {
			try {
				while (queue.size() == maxSize) {
					queue.wait();
				}
				queue.add(request);
				queue.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public SomeRequest consume() {
		try {
			synchronized (queue) {
				while (queue.isEmpty()) {
					queue.wait();
				}
				SomeRequest consumed = queue.remove();
				queue.notify();
				return consumed;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
