package school.cesar.ppcd.av1.ex1.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounterServerRunnable implements Runnable {
	private Socket client;
	private DataOutputStream dataOutputStream;
	private DataInputStream dataInputStream;
	private static final byte[] INC = new byte[] { 'I' };
	private static AtomicInteger counter = new AtomicInteger(0);

	public SharedCounterServerRunnable(Socket client) throws IOException {
		this.client = client;
		this.dataInputStream = new DataInputStream(client.getInputStream());
		this.dataOutputStream = new DataOutputStream(client.getOutputStream());
	}

	public void run() {
		try {
			int currentValue;
			while (true) {
				if (this.dataInputStream.read(INC) == 1) {
					currentValue = counter.getAndIncrement();
					this.dataOutputStream.writeInt(currentValue);
					TimeUnit.SECONDS.sleep(1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
