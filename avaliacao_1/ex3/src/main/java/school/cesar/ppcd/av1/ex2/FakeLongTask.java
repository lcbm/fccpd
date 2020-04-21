package school.cesar.ppcd.av1.ex2;

import static school.cesar.ppcd.av1.ex2.Util.nap;

public class FakeLongTask implements Runnable {
	Object mutex;
	private static final long ONE_MINUTE = 60 * 1000;

	public FakeLongTask(Object mutex) {
		this.mutex = mutex;
	}

	public void run() {
		synchronized (mutex) {
			nap(ONE_MINUTE);
			mutex.notify();
		}
	}
}
