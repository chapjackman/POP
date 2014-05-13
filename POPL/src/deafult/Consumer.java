package deafult;
public class Consumer extends Thread {
	private BoundedBuffer buffer;
 
	public Consumer(BoundedBuffer buffer) {
		this.buffer = buffer;
	}
 
	public void run() {
			while (true) {
				buffer.removeItem();
 
	}
}
}
