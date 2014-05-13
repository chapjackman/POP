package deafult;

public class Producer3 extends Thread {
	private BoundedBufferM buffer;
	private int item;
 
	public Producer3(BoundedBufferM buffer) {
		this.buffer = buffer;
	}
 
	public void run() {
			while (true) {
				item = (int) (Math.random() * 100);
				buffer.additem(item);
 
	}
	}
}
