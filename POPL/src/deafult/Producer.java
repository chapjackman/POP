package deafult;

public class Producer extends Thread {
	private BoundedBuffer buffer;
	private int item;
 
	public Producer(BoundedBuffer buffer) {
		this.buffer = buffer;
	}
 
	public void run() {
			while (true) {
				item = (int) (Math.random() * 100);
				buffer.additem(item);
 
	}
	}
}
