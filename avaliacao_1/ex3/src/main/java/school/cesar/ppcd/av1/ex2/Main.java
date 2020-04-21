package school.cesar.ppcd.av1.ex2;

public class Main {
	public static void main(String[] args) {
		Object mutex = 1;
		FakeLongTask fakeLongTask = new FakeLongTask(mutex);
		Thread threadFakeLongTask = new Thread(fakeLongTask);

		synchronized (mutex) {
			try {
				threadFakeLongTask.start();
				System.out.println("waiting...");
				mutex.wait();
				System.out.println("done!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
